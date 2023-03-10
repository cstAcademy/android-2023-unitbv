package com.cst.androidlab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.cst.androidlab.fragments.FragmentJavaDirections;
import com.cst.androidlab.fragments.FragmentKotlinDirections;
import com.cst.androidlab.fragments.FragmentKotlinSecond;

public class MainActivityJava extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.e("MainActivityJava", "onCreate");

        Button button = findViewById(R.id.btn_press_me);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("MainActivityJava", "button clicked");
                goToKotlinFragmentSecond();

                button.setText(getString(R.string.go_to_home));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goToHome();
                    }
                });
            }
        });

        Log.e("MainActivityJava", "end of onCreate");
    }

    private void goToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);

        finish();
    }

    private void goToKotlinFragmentSecond() {
        NavDirections actionKotlinToKotlin = FragmentKotlinDirections.actionFragmentKotlinToFragmentKotlinSecond();

        NavDirections actionJavaToKotlin = FragmentJavaDirections.actionFragmentJavaToFragmentKotlinSecond();

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host);

        if(navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();

            NavDestination currentDestination = navController.getCurrentDestination();
            if(currentDestination == null) {
                return;
            }

            if(navController.getCurrentDestination().getId() == R.id.fragment_kotlin) {
                navController.navigate(actionKotlinToKotlin);
            } else if(navController.getCurrentDestination().getId() == R.id.fragment_java) {
                navController.navigate(actionJavaToKotlin);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e("MainActivityJava", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("MainActivityJava", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e("MainActivityJava", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e("MainActivityJava", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e("MainActivityJava", "onDestroy");
    }
}
