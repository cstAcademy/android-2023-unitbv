package com.cst.androidlab.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cst.androidlab.R

class FragmentKotlin : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_kotlin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btn_press_me)
        button.setOnClickListener {
            goToFragmentJava()
        }
    }

    private fun goToFragmentJava() {
        val action = FragmentKotlinDirections.actionFragmentKotlinToFragmentJava()
        val fragmentController = findNavController()

        fragmentController.navigate(action)
    }
}