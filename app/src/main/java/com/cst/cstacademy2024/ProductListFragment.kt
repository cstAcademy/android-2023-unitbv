package com.cst.cstacademy2024

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2024.adapters.ProductListAdapter
import com.cst.cstacademy2024.helpers.extensions.logErrorMessage
import com.cst.cstacademy2024.models.CategoryModel
import com.cst.cstacademy2024.models.ProductModel

class ProductListFragment : Fragment() {

    val arguments : ProductListFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_product_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val token = arguments.token
        // Use the token to call the API
        //log the token
        token.logErrorMessage()
        setupProductList()
    }

    private fun setupProductList() {
        // Call the API to get the list of products
        val layoutManager = LinearLayoutManager(context)

        val productList = listOf(
            ProductModel(1, "Product 1", "Description 1"),
            ProductModel(2, "Product 2", "Description 2"),
            ProductModel(3, "Product 3", "Description 3"),
            ProductModel(4, "Product 4", "Description 4"),
            ProductModel(5, "Product 5", "Description 5"),
            ProductModel(6, "Product 6", "Description 6"),
            ProductModel(7, "Product 7", "Description 7"),
            ProductModel(8, "Product 8", "Description 8"),
            ProductModel(9, "Product 9", "Description 9"),
            ProductModel(10, "Product 10", "Description 10"),
            CategoryModel(1, "Category 1", "Description 1"),
            CategoryModel(2, "Category 2", "Description 2"),
            ProductModel(11, "Product 1", "Description 1"),
            ProductModel(12, "Product 2", "Description 2"),
            ProductModel(13, "Product 3", "Description 3"),
            ProductModel(14, "Product 4", "Description 4"),
            ProductModel(15, "Product 5", "Description 5"),
            ProductModel(16, "Product 6", "Description 6"),
            ProductModel(17, "Product 7", "Description 7"),
            ProductModel(18, "Product 8", "Description 8"),
            ProductModel(19, "Product 9", "Description 9"),
            ProductModel(20, "Product 10", "Description 10"),
            CategoryModel(3, "Category 3", "Description 3"),
            CategoryModel(4, "Category 4", "Description 4"),
            ProductModel(21, "Product 1", "Description 1"),
            ProductModel(22, "Product 2", "Description 2"),
            ProductModel(23, "Product 3", "Description 3"),
            ProductModel(24, "Product 4", "Description 4"),
            ProductModel(25, "Product 5", "Description 5"),
            ProductModel(26, "Product 6", "Description 6"),
            ProductModel(27, "Product 7", "Description 7"),
            ProductModel(28, "Product 8", "Description 8"),
            ProductModel(29, "Product 9", "Description 9"),
            ProductModel(30, "Product 10", "Description 10"),
            ProductModel(31, "Product 1", "Description 1"),
            ProductModel(32, "Product 2", "Description 2"),
            ProductModel(33, "Product 3", "Description 3"),
            ProductModel(34, "Product 4", "Description 4"),
            ProductModel(35, "Product 5", "Description 5"),
            CategoryModel(5, "Category 5", "Description 5"),
            ProductModel(36, "Product 6", "Description 6"),
            ProductModel(37, "Product 7", "Description 7"),
            ProductModel(38, "Product 8", "Description 8"),
            ProductModel(39, "Product 9", "Description 9"),
            ProductModel(40, "Product 10", "Description 10")

        )

        val adapter = ProductListAdapter(productList)

        view?.findViewById<RecyclerView>(R.id.rv_product_list)?.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }
    }
}