package com.cst.androidlab.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.cst.androidlab.R;

public class FragmentJava extends Fragment {

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_java, container, false);

      return view;
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);


   }

   private void goToKotlinFragmentSecond() {
      NavDirections action = FragmentKotlinDirections.actionFragmentKotlinToFragmentKotlinSecond();

      NavHostFragment navHostFragment =
              (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.nav_host);
      NavController navController = navHostFragment.getNavController();

      navController.navigate(action);
   }
}
