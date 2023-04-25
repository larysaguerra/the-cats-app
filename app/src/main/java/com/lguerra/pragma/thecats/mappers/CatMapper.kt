package com.lguerra.pragma.thecats.mappers

import com.lguerra.pragma.thecats.data.model.Cat
import com.lguerra.pragma.thecats.data.network.CatsResponse

fun CatsResponse.toCat(imageUrlBase: String): Cat? {

    name ?: return null
    origin ?: return null
    affectionLevel ?: return null
    intelligence ?: return null
    imageId ?: return null

    return Cat(
        breedName = name,
        origin = origin,
        affectionLevel = affectionLevel,
        intelligence = intelligence,
        imageUrl = "$imageUrlBase$imageId.jpg"
    )

}