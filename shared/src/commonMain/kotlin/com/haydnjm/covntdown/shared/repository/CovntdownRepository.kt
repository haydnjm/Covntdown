package com.haydnjm.covntdown.shared.repository

import android.util.Log
import com.haydnjm.covntdown.shared.remote.Event
import com.haydnjm.covntdown.shared.remote.EventsApi
import com.haydnjm.covntdown.shared.remote.Infections
import com.haydnjm.covntdown.shared.remote.InfectionsApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CovntdownRepository: KoinComponent {
    private val infectionsApi by inject<InfectionsApi>()
    private val eventsApi by inject<EventsApi>()

    suspend fun fetchInfections(): Infections {
        Log.i("DATA_REPO", "FETCHING INFECTIONS")
        var res = infectionsApi.fetchLatestInfectionData()
        Log.i("DATA_REPO", res.toString())
        return res
    }

    suspend fun fetchEvents(): List<Event> {
        Log.i("DATA_REPO", "FETCHING EVENTS")
        var res =  eventsApi.fetchEvents()
        Log.i("DATA_REPO", res.toString())
        return res
    }

}