package com.lguerra.pragma.thecats.data.network

import retrofit2.http.GET

private const val BREEDS = "breeds"

interface ApiClient {

    @GET(BREEDS)
    suspend fun getCats(): List<CatsResponse>

}
