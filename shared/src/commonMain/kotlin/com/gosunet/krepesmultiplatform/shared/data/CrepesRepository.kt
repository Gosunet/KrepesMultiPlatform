package com.gosunet.krepesmultiplatform.shared.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class CrepesRepository() : KoinComponent {
    private val coroutineScope: CoroutineScope = MainScope()
    private val crepesApi: CrepesApi by inject()

    var crepesJob: Job? = null

    init {
    }

    suspend fun getCrepes(city: City = City.Brest): List<Crepe> {
        val crepes = crepesApi.getCrepes() + getGalettes()
        crepes.map {
            it.name =
                if (City.Brest == city) it.name.replaceGaletteToCrepes() else it.name.replaceCrepesToGalettes()
            it.description =
                if (City.Brest == city) it.description.replaceGaletteToCrepes() else it.description.replaceCrepesToGalettes()
            it
        }
        return crepes
    }

    private suspend fun getGalettes(): List<Crepe> {
        return crepesApi.getGalettes()
    }

    private fun String.replaceCrepesToGalettes() =
        this.replace("Crêpes de blé noir", "Galettes", true)
            .replace("Crêpes au Sarrasin", "Galettes", true)

    private fun String.replaceGaletteToCrepes() =
        this.replace("Galette", "Crêpe")
            .replace("Galettes", "Crêpes")
            .replace("galettes", "crêpes")
            .replace("galette", "crêpe")

    // called from Kotlin/Native clients
    fun startObservingCrepesUpdates(success: (List<Crepe>) -> Unit) {
        crepesJob = coroutineScope.launch {
            success(getCrepes())
        }
    }
}
