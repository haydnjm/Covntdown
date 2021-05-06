package com.haydnjm.covntdown.shared.repository

import com.haydnjm.covntdown.shared.remote.Infections
import com.haydnjm.covntdown.shared.remote.InfectionsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CovntdownRepository: KoinComponent {
    private val infectionsApi by inject<InfectionsApi>()

    private val coroutineScope: CoroutineScope = MainScope()

    lateinit var data: Infections

    init {
        coroutineScope.launch {
            fetchInfections()
        }
    }

    suspend fun fetchInfections() {
        data = infectionsApi.fetchLatestInfectionData()
    }

}