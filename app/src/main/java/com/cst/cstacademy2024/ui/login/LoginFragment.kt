package com.cst.cstacademy2024.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cst.cstacademy2024.BuildConfig

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.cst.cstacademy2024.R
import com.cst.cstacademy2024.databinding.FragmentLoginBinding
import com.cst.cstacademy2024.helpers.extensions.VolleyRequestQueue
import com.cst.cstacademy2024.helpers.extensions.logErrorMessage
import com.cst.cstacademy2024.models.LoginModel
import org.json.JSONObject

class LoginFragment : Fragment(), LoginFragmentListener {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.listener = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(BuildConfig.DEBUG) {
            viewModel.username.set("mor_2314")
        }
    }

    private fun goToProductList(token: String) {
        val action = LoginFragmentDirections.actionFragmentLoginToProductListFragment(token)
        findNavController().navigate(action)
    }
	
    override fun doLogin(model: LoginModel) {
//        val username = view?.findViewById<EditText>(R.id.et_user_name)?.text?.toString() ?: ""
//        val password = view?.findViewById<EditText>(R.id.et_password)?.text?.toString() ?: ""
//        val loginModel = when (BuildConfig.DEBUG) {
//            true -> LoginModel("mor_2314", "83r5^_")
//            false -> LoginModel(username, password)
//        }

        val url = "https://fakestoreapi.com/auth/login"

        val stringRequest = object: StringRequest(
            Request.Method.POST,
            url,
            Response.Listener<String> { response ->
                "Success".logErrorMessage()
                val jsonResponse = JSONObject(response)
                try {
                    val token = jsonResponse.getString("token")
                    "Token: $token".logErrorMessage()
                    goToProductList(token)
                } catch (e: Exception) {
                    e.message?.logErrorMessage()
                }
            },
            Response.ErrorListener {
                "Error".logErrorMessage()
            }) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["username"] = model.username
                params["password"] = model.password
                return params
            }

        }

        VolleyRequestQueue.addToRequestQueue(stringRequest)
    }

    override fun goToRegister() {
        val action = LoginFragmentDirections.actionFragmentLoginToFragmentRegister()
        findNavController().navigate(action)
    }
}

interface LoginFragmentListener {
    fun doLogin(model: LoginModel)
    fun goToRegister()
}