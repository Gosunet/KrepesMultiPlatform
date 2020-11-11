package com.gosunet.krepesmultiplatform.shared.data

import org.koin.core.KoinComponent

class CrepesRepository(private val crepesApi: CrepesApi) : KoinComponent {
    suspend fun getCrepes(city: City = City.Brest): List<Crepe> {
        return crepesApi.getCrepes() + getGalettes(city)
    }

    private suspend fun getGalettes(city: City): List<Crepe> {
        return if (City.Brest == city) {
            crepesApi.getGalettes().map {
                it.name = it.name.replaceGaletteToCrepes()
                it.description = it.description.replaceGaletteToCrepes()
                it
            }
        } else {
            crepesApi.getGalettes()
        }
    }

    fun String.replaceGaletteToCrepes() =
        this.replace("Galette", "Crêpe")
            .replace("Galettes", "Crêpes")
            .replace("galettes", "crêpes")
            .replace("galette", "crêpe")
}
