package com.cst.cstacademy2024.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cst.cstacademy2024.data.models.CategoryDBModel
import com.cst.cstacademy2024.data.models.CategoryWithProducts
import com.cst.cstacademy2024.models.ProductAPIResponse

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(product: ProductAPIResponse)

    @Insert
     fun insertAll(products: List<ProductAPIResponse>)

    @Query("SELECT * FROM products")
     fun getAll(): List<ProductAPIResponse>

     @Query("SELECT * FROM categories")
    fun getCategoriesWithProducts(): List<CategoryWithProducts>

    @Insert
    fun insertCategory(category: CategoryDBModel)
}