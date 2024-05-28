package com.cst.cstacademy2024.data.repositories

import com.cst.cstacademy2024.data.models.CategoryWithProducts
import com.cst.cstacademy2024.data.tasks.GetCategoriesProductsTask
import com.cst.cstacademy2024.data.tasks.InsertAllProductsTask
import com.cst.cstacademy2024.data.tasks.InsertProductTask
import com.cst.cstacademy2024.models.ProductAPIResponse

object ProductRepository {
    fun insertProduct(product: ProductAPIResponse, onSuccess: () -> Unit) {
        InsertProductTask(onSuccess).execute(product)
    }

    fun insertAllProducts(products: List<ProductAPIResponse>, onSuccess: () -> Unit) {
        InsertAllProductsTask(onSuccess).execute(products)
    }

    fun getCategoriesWithProducts(onSuccess:( List<CategoryWithProducts>) -> Unit) {
        GetCategoriesProductsTask(onSuccess).execute()
    }


}