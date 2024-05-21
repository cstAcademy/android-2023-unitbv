package com.cst.cstacademy2024.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.cst.cstacademy2024.models.LoginModel

class LoginViewModel: ViewModel() {

    val logoImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Google_Images_2015_logo.svg/1200px-Google_Images_2015_logo.svg.png"

    val username = ObservableField<String>("")
    val password = ObservableField<String>("")
    

    fun getLoginFormData(userName: String, password: String) : LoginModel {
        return LoginModel(userName, password)
    }
}