package com.gosunet.krepesmultiplatform.shared.data

import org.koin.core.KoinComponent

class CrepesRepository(private val crepesApi: CrepesApi) : KoinComponent {
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
}
