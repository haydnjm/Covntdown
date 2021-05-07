package com.haydnjm.covntdown.shared.repository

import android.util.Log
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

    var data: Infections = Infections(recovered = 0, infected = 0)

    init {
        coroutineScope.launch {
            fetchInfections()
        }
    }

    suspend fun fetchInfections() {
        var res = infectionsApi.fetchLatestInfectionData()
        Log.d("DATA IN REPO", res.toString())
        data = res
    }

}