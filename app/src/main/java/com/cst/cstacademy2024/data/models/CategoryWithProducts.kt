package com.cst.cstacademy2024.data.models

import androidx.room.Embedded
import androidx.room.Relation
import com.cst.cstacademy2024.models.ProductAPIResponse

class CategoryWithProducts(
    @Embedded
    val category: CategoryDBModel,
    @Relation(
        parentColumn = CategoryDBModel.ARG_CATEGORY_NAME,
        entityColumn = ProductAPIResponse.ARG_PRODUCT_CATEGORY
    )
    val products: List<ProductAPIResponse>
)