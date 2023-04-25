package com.lguerra.pragma.thecats.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getCats(): List<CatsResponse> = withContext(Dispatchers.IO) {
        apiClient.getCats()
    }

}