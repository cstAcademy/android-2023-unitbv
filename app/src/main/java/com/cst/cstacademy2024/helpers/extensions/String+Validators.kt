package com.cst.cstacademy2024.helpers.extensions

fun String.isPasswordValid(): Boolean {
    val regex = "^(?=.*[A-Z])(?=.*[^A-Za-z]).{6,}\$".toRegex()
    return this.matches(regex)
}