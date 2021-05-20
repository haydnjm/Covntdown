package com.haydnjm.covntdown.androidApp.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haydnjm.covntdown.shared.remote.Event
import com.haydnjm.covntdown.shared.remote.Infections
import com.haydnjm.covntdown.shared.repository.CovntdownRepository
import kotlinx.coroutines.launch

class CovntdownViewModel(
    repo: CovntdownRepository
): ViewModel() {

    val infections: MutableState<Infections> = mutableStateOf(Infections(recovered = 0, infected = 0))
    val events: MutableState<List<Event>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            infections.value = repo.fetchInfections()
            events.value = repo.fetchEvents()
        }
    }
}