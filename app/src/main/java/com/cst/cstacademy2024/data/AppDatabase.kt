package com.cst.cstacademy2024.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cst.cstacademy2024.data.models.CategoryDBModel
import com.cst.cstacademy2024.models.ProductAPIResponse

@Database(entities = [ProductAPIResponse::class,CategoryDBModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{
    abstract val productsDao: ProductsDao
}