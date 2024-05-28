package com.cst.cstacademy2024.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2024.R
import com.cst.cstacademy2024.helpers.extensions.logErrorMessage
import com.cst.cstacademy2024.models.CartItemModel
import com.cst.cstacademy2024.models.CartItemType
import com.cst.cstacademy2024.models.CategoryModel
import com.cst.cstacademy2024.models.ProductModel

class ProductListAdapter(
    private val items: List<CartItemModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].type.key

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        "onCreateViewHolder".logErrorMessage("ProductListAdapter")
        return when(viewType) {
            CartItemType.PRODUCT.key -> {
                val view = inflater.inflate(R.layout.item_product_cell, parent, false)
                ProductViewHolder(view)
            }
            CartItemType.CATEGORY.key -> {
                val view = inflater.inflate(R.layout.item_category_cell, parent, false)
                CategoryViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cartItemModel = items[position]
        when(holder) {
            is ProductViewHolder -> (cartItemModel as? ProductModel)?.let { holder.bind(it) }
            is CategoryViewHolder -> (cartItemModel as? CategoryModel)?.let { holder.bind(it) }
        }
        "onBindViewHolder; position = $position".logErrorMessage("ProductListAdapter")
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val productNameTextView : TextView
        private val productDescriptionTextView : TextView

        init {
            productNameTextView = view.findViewById(R.id.tv_product_name)
            productDescriptionTextView = view.findViewById(R.id.tv_product_description)
        }
        fun bind(product: ProductModel) {
            productNameTextView.text = product.name
            productDescriptionTextView.text = product.description
        }
    }

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val categoryNameTextView : TextView
        private val categoryDescriptionTextView : TextView

        init {
            categoryNameTextView = view.findViewById(R.id.tv_category_name)
            categoryDescriptionTextView = view.findViewById(R.id.tv_category_description)
        }
        fun bind(category: CategoryModel) {
            categoryNameTextView.text = category.name
            categoryDescriptionTextView.text = category.description
        }
    }
}