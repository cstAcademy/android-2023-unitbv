package com.cst.cstacademy2024.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
class CategoryDBModel (
    @PrimaryKey
    @ColumnInfo(name = ARG_CATEGORY_NAME)
    val name: String
)
{
    companion object {
        const val ARG_CATEGORY_NAME = "name"
    }
}