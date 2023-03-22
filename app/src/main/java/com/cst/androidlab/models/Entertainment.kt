package com.cst.androidlab.models

enum class Type(val key: Int) {
    MOVIE(0),
    TV_SHOW(1)
}

open class Entertainment (val type: Type)