package com.cst.cstacademy2024

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.cst.cstacademy2024.helpers.extensions.logErrorMessage
import com.cst.cstacademy2024.models.LoginModel

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registerButton = view.findViewById<Button>(R.id.btn_register)
        registerButton.setOnClickListener(::goToRegister)

        val loginButton = view.findViewById<Button>(R.id.btn_id)
        loginButton.setOnClickListener { doLogin() }
    }

    private fun goToRegister(view: View) {
        val action = LoginFragmentDirections.actionFragmentLoginToFragmentRegister()
        findNavController().navigate(action)
    }

    private fun doLogin() {
        val username = view?.findViewById<EditText>(R.id.et_user_name)?.text?.toString() ?: ""
        val password = view?.findViewById<EditText>(R.id.et_password)?.text?.toString() ?: ""
        val loginModel = LoginModel(username, password)
        // Call the login method from the view model

        val queue = Volley.newRequestQueue(context ?: return)
        val url = "https://fakestoreapi.com/products"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> { response ->
                "Success".logErrorMessage()
            },
            Response.ErrorListener {
                "Error".logErrorMessage()
            })

        queue.add(stringRequest)
    }


}