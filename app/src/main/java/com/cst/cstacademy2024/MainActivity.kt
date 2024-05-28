package com.cst.cstacademy2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.cst.cstacademy2024.helpers.extensions.logErrorMessage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btn_press)
        button.setOnClickListener { goToSecondActivity() }

        "onCreate".logErrorMessage()
    }

    override fun onStart() {
        super.onStart()

        "onStart".logErrorMessage()
    }

    override fun onResume() {
        super.onResume()

        "onResume".logErrorMessage()
    }

    override fun onPause() {
        super.onPause()

        "onPause".logErrorMessage()
    }

    override fun onStop() {
        super.onStop()

        "onStop".logErrorMessage()
    }

    override fun onDestroy() {
        super.onDestroy()

        "onDestroy".logErrorMessage()
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
//        finish()
    }
}