package com.lguerra.pragma.thecats.data.network

import com.google.gson.annotations.SerializedName

class CatsResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("origin") val origin: String? = null,
    @SerializedName("affection_level") val affectionLevel: Int? = null,
    @SerializedName("intelligence") val intelligence: Int? = null,
    @SerializedName("reference_image_id") val imageId: String? = null,
)
