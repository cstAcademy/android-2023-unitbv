package com.cst.androidlab.helpers

import android.util.Log

fun String.errorLog(tag: String = "tag"){
    Log.e(tag, this);
}