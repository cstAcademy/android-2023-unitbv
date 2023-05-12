package com.cst.androidlab.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.cst.androidlab.models.ToDoItemElement;

@Entity
public class ToDoItem {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "description")
    public String description;

    public ToDoItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ToDoItemElement convert() {
        return new ToDoItemElement(title, description);
    }
}
