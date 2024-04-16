package com.cst.cstacademy2024.data.tasks

import android.os.AsyncTask
import com.cst.cstacademy2024.ApplicationController
import com.cst.cstacademy2024.models.ProductAPIResponse

class InsertProductTask(
    private val onSuccess: () -> Unit,
) : AsyncTask<ProductAPIResponse, Unit, Unit>(){
override fun doInBackground(vararg params: ProductAPIResponse) {
    params.getOrNull(0)?.let {product ->
        ApplicationController.instance.appDatabase.productsDao.insert(product)
    }
}

    override fun onPostExecute(result: Unit?) {
       onSuccess.invoke()
    }


}