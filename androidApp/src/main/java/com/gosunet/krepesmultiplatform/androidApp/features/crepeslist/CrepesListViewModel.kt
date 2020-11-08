package com.gosunet.krepesmultiplatform.androidApp.features.crepeslist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gosunet.krepesmultiplatform.shared.data.Crepe
import com.gosunet.krepesmultiplatform.shared.data.CrepesRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class CrepesListViewModel(private val crepesRepository: CrepesRepository) : ViewModel() {

    var crepes: List<Crepe> by mutableStateOf(listOf())
        private set

    init {
        viewModelScope.launch {
            crepes = crepesRepository.getCrepes()
        }
    }
}
