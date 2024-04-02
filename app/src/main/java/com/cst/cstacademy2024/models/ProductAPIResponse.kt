package com.cst.cstacademy2024.models

import com.google.gson.annotations.SerializedName

class ProductAPIResponse(
    val id: Int,
    @SerializedName("title") val name: String,
    val description: String,
    val category: String,
    val image: String
)