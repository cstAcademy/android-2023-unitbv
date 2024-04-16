package com.cst.cstacademy2024.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
class ProductAPIResponse(
    @PrimaryKey

    val id: Int,
    @SerializedName("title") val name: String,
    val description: String,
    @ColumnInfo(name = ARG_PRODUCT_CATEGORY)
    val category: String,
    val image: String
) {
    companion object {
        const val ARG_PRODUCT_CATEGORY = "category"
    }
}

