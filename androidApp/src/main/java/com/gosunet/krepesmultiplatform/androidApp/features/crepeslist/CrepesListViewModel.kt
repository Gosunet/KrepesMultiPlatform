package com.gosunet.krepesmultiplatform.androidApp.features.crepeslist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gosunet.krepesmultiplatform.shared.data.City
import com.gosunet.krepesmultiplatform.shared.data.Crepe
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import kotlinx.coroutines.launch

class CrepesListViewModel(private val crepesRepository: CrepesRepository) : ViewModel() {

    var crepes: List<Crepe> by mutableStateOf(listOf())
        private set

    fun getCrepes(city: City): List<Crepe> {
        viewModelScope.launch {
            crepes = crepesRepository.getCrepes(city)
        }
        return crepes
    }
}
