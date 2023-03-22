package com.cst.androidlab.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cst.androidlab.R;
import com.cst.androidlab.models.Entertainment;
import com.cst.androidlab.models.MovieKotlinModel;
import com.cst.androidlab.models.MovieModel;
import com.cst.androidlab.models.TvShow;
import com.cst.androidlab.models.Type;

import java.util.List;

public class MovieItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Entertainment> movies;

    public MovieItemsAdapter(List<Entertainment> movies) {
        this.movies = movies;
    }

    @Override
    public int getItemViewType(int position) {
        return movies.get(position).getType().getKey();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == Type.MOVIE.getKey()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

            MovieViewHolder viewHolder = new MovieViewHolder(view);

            Log.e("Adapter", "onCreateViewHolder movie");

            return viewHolder;
        } else if (viewType == Type.TV_SHOW.getKey()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_show, parent, false);

            TVShowViewHolder viewHolder = new TVShowViewHolder(view);

            Log.e("Adapter", "onCreateViewHolder tvshow");

            return viewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof MovieViewHolder) {
            MovieKotlinModel movieModel = (MovieKotlinModel) movies.get(position);

            ((MovieViewHolder)holder).bind(movieModel);
        } else if(holder instanceof TVShowViewHolder) {
            TvShow model = (TvShow) movies.get(position);

            ((TVShowViewHolder)holder).bind(model);
        }


        Log.e("Adapter", "onBindViewHolder; position=" + position);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView movieTitleTextView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitleTextView = itemView.findViewById(R.id.tv_title);
        }

        public void bind(MovieKotlinModel movieModel) {
            movieTitleTextView.setText(movieModel.getTitle());
        }
    }

    class TVShowViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView descriptionTextView;

        public TVShowViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.tv_title);
            descriptionTextView = itemView.findViewById(R.id.tv_description);
        }

        public void bind(TvShow model) {
            titleTextView.setText(model.getTitle());
            descriptionTextView.setText(model.getDescription());
        }
    }
}
