package com.cst.cstacademy2024.data.tasks

import android.os.AsyncTask
import com.cst.cstacademy2024.ApplicationController
import com.cst.cstacademy2024.data.models.CategoryWithProducts
import com.cst.cstacademy2024.models.ProductAPIResponse

class GetCategoriesProductsTask(
    private val onSuccess: (List<CategoryWithProducts>) -> Unit,
) : AsyncTask<Unit, Unit, List<CategoryWithProducts>>() {
    override fun doInBackground(vararg params: Unit) : List<CategoryWithProducts> {
        return ApplicationController.instance.appDatabase.productsDao.getCategoriesWithProducts()
    }

    override fun onPostExecute(result: List<CategoryWithProducts>) {
        onSuccess.invoke(result)
    }


}