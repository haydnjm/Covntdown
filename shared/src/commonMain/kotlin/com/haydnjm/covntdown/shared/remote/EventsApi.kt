package com.haydnjm.covntdown.shared.remote

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent

@Serializable
data class Event(val key: String, val fullName: String, val date: String)

class EventsApi(
    private val client: HttpClient,
    private val baseUrl: String = Constants.HOST
): KoinComponent {
    suspend fun fetchEvents(): List<Event> {
        return client.get("$baseUrl/get-events");
    }
}