package com.cst.androidlab.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cst.androidlab.R;
import com.cst.androidlab.models.ToDoItemElement;

import java.util.ArrayList;

public class ToDosAdapter extends RecyclerView.Adapter<ToDosAdapter.ToDoViewHolder> {
    ArrayList<ToDoItemElement> todoList;

    public ToDosAdapter(ArrayList<ToDoItemElement> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cell_todo, parent, false);
        ToDoViewHolder todoViewHolder = new ToDoViewHolder(view);

        Log.e("ToDosAdapter", "onCreateViewHolder");

        return todoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDoItemElement toDoItemElement = todoList.get(position);
        holder.bind(toDoItemElement);

        Log.e("ToDosAdapter", "onBindViewHolder: " + position);
    }

    @Override
    public int getItemCount() {
        return this.todoList.size();
    }

    class ToDoViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;

        ToDoViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tv_title);
            description = view.findViewById(R.id.tv_description);
        }

        void bind(ToDoItemElement toDoItemElement) {
            title.setText(toDoItemElement.getTitle());
            description.setText(toDoItemElement.getDescription());
        }
    }
}
