package com.cst.androidlab.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cst.androidlab.R;
import com.cst.androidlab.models.UserPostItemModel;

import java.util.ArrayList;

public class UserPostsAdapter extends RecyclerView.Adapter<UserPostsAdapter.UserPostsViewHolder> {
    ArrayList<UserPostItemModel> userPosts;

    public UserPostsAdapter(ArrayList<UserPostItemModel> userPosts) {
        this.userPosts = userPosts;
    }

    @NonNull
    @Override
    public UserPostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_post, parent, false);
        UserPostsViewHolder holder = new UserPostsViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserPostsViewHolder holder, int position) {
        UserPostItemModel item = userPosts.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return this.userPosts.size();
    }

    public class UserPostsViewHolder extends RecyclerView.ViewHolder {

        private final TextView userId;
        private final TextView title;
        private final TextView description;

        UserPostsViewHolder(View view) {
            super(view);
            userId = view.findViewById(R.id.tv_user);
            title = view.findViewById(R.id.tv_title);
            description = view.findViewById(R.id.tv_description);
        }

        void bind(UserPostItemModel item) {
            String id = "User ID: " + item.getId();
            userId.setText(id);

            title.setText(item.getTitle());
            description.setText(item.getDescription());
        }
    }
}
