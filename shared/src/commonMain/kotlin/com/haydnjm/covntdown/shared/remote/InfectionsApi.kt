package com.haydnjm.covntdown.shared.remote

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent

@Serializable
data class Infections(val infected: Int, val recovered: Int)

class InfectionsApi(
    private val client: HttpClient,
    private val baseUrl: String = "https://api.apify.com/v2/key-value-stores/vqnEUe7VtKNMqGqFF/records/LATEST?disableRedirect=true",
): KoinComponent {
    suspend fun fetchLatestInfectionData(): Infections {
        return client.get(baseUrl);
    }
}