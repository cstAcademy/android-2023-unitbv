package com.cst.cstacademy2024.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.cst.cstacademy2024.helpers.extensions.isPasswordValid
import com.cst.cstacademy2024.models.LoginModel

class LoginViewModel: ViewModel() {

    val logoImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Google_Images_2015_logo.svg/1200px-Google_Images_2015_logo.svg.png"

    val username = MutableLiveData("")
    val isUsernameError = username.map { username ->
        MutableLiveData(username.length > 3)
    }

    val password = MutableLiveData("")
    val isPasswordError = password.map { password ->
        MutableLiveData(password.isPasswordValid())
    }

    val loginModel = MutableLiveData<LoginModel>()

    fun setLoginFormData(userName: String, password: String) {
        this.loginModel.value = LoginModel(userName, password)
    }
}