package com.lguerra.pragma.thecats.data

import com.lguerra.pragma.thecats.data.model.Cat
import com.lguerra.pragma.thecats.data.network.ApiService
import com.lguerra.pragma.thecats.mappers.toCat
import javax.inject.Inject

private const val IMAGE_URL_BASE = "https://cdn2.thecatapi.com/images/"

class CatsRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCatsFromApi(): List<Cat> {
        return try {
            apiService.getCats().mapNotNull { it.toCat(IMAGE_URL_BASE) }
        } catch (e: Throwable) {
            e.printStackTrace()
            emptyList()
        }
    }

}