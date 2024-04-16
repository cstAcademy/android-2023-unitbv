package com.cst.cstacademy2024.data.tasks

import android.os.AsyncTask
import com.cst.cstacademy2024.ApplicationController
import com.cst.cstacademy2024.data.models.CategoryDBModel
import com.cst.cstacademy2024.models.ProductAPIResponse

class InsertAllProductsTask(
    private val onSuccess: () -> Unit,
) : AsyncTask<List<ProductAPIResponse>, Unit, Unit>() {
    override fun doInBackground(vararg params: List<ProductAPIResponse>) {

        params.getOrNull(0)?.let {responseList ->
            ApplicationController.instance.appDatabase.productsDao.insertAll(responseList)

            responseList.groupBy { it.category }
                .forEach { (category, products) ->
                    ApplicationController.instance.appDatabase.productsDao.insertCategory(
                        CategoryDBModel (name = category)
                    )
                }
        }

    }

    override fun onPostExecute(result: Unit?) {
        onSuccess.invoke()
    }


}