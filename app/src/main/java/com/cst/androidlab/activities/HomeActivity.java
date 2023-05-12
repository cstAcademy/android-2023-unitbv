package com.cst.androidlab.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cst.androidlab.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button button = findViewById(R.id.btn_press_me);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("HomeActivity", "button clicked");

                button.setVisibility(View.GONE);
                findViewById(R.id.nav_host).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.btn_go_to_todos).setOnClickListener(view -> {
            Intent intent = new Intent(this, LocalDataBaseActivity.class);
            startActivity(intent);
        });
    }
}