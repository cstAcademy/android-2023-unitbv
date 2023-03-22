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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cst.androidlab.R;
import com.cst.androidlab.adapters.MovieItemsAdapter;
import com.cst.androidlab.models.Entertainment;
import com.cst.androidlab.models.MovieKotlinModel;
import com.cst.androidlab.models.TvShow;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecyclerView extends Fragment {

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

      return view;
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);

      RecyclerView recyclerView = view.findViewById(R.id.rv_movies);

      List<Entertainment> movies = new ArrayList<>();
      movies.add(new MovieKotlinModel("Star Wars"));
      movies.add(new MovieKotlinModel("Avatar"));
      movies.add(new MovieKotlinModel("Avengers"));
      movies.add(new TvShow("Big Bang Theory", "Some Description"));
      movies.add(new TvShow("Game of Thrones", "Other desc"));
      movies.add(new TvShow("The last of us", "Description"));
      movies.add(new MovieKotlinModel("Star Wars"));
      movies.add(new TvShow("Big Bang Theory", "Some Description"));
      movies.add(new MovieKotlinModel("Avatar"));
      movies.add(new MovieKotlinModel("Avengers"));
      movies.add(new MovieKotlinModel("Avengers"));
      movies.add(new TvShow("Big Bang Theory", "Some Description"));
      movies.add(new TvShow("Game of Thrones", "Other desc"));
      movies.add(new TvShow("The last of us", "Description"));
      movies.add(new MovieKotlinModel("Star Wars"));
      movies.add(new TvShow("Big Bang Theory", "Some Description"));
      movies.add(new MovieKotlinModel("Avatar"));
      movies.add(new MovieKotlinModel("Avengers"));
      movies.add(new MovieKotlinModel("Avengers"));
      movies.add(new TvShow("Big Bang Theory", "Some Description"));
      movies.add(new TvShow("Game of Thrones", "Other desc"));
      movies.add(new TvShow("The last of us", "Description"));
      movies.add(new MovieKotlinModel("Star Wars"));
      movies.add(new TvShow("Big Bang Theory", "Some Description"));
      movies.add(new MovieKotlinModel("Avatar"));
      movies.add(new MovieKotlinModel("Avengers"));

      MovieItemsAdapter adapter = new MovieItemsAdapter(movies);

      recyclerView.setAdapter(adapter);

      LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
      recyclerView.setLayoutManager(layoutManager);
   }
}
