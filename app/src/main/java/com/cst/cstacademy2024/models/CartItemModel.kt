package com.cst.cstacademy2024.models

enum class CartItemType(
    val key: Int
) {
    PRODUCT(0),
    CATEGORY(1)
}

sealed class CartItemModel(
    val type: CartItemType
)

data class ProductModel(
    val id: Int,
    val name: String,
    val description: String,
) : CartItemModel(CartItemType.PRODUCT)

data class CategoryModel(
    val id: Int,
    val name: String,
    val description: String
) : CartItemModel(CartItemType.CATEGORY)