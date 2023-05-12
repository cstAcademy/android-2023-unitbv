package com.cst.androidlab;

import android.app.Application;

import androidx.room.Room;

import com.cst.androidlab.data.ToDoDataBase;

public class ApplicationController extends Application {
    private static ApplicationController instance;
    private static ToDoDataBase toDoDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setupDataBase();
    }

    private void setupDataBase() {
        String toDoDataBaseName = "ToDoDB";

        toDoDataBase = Room.databaseBuilder(
                getApplicationContext(),
                ToDoDataBase.class,
                        toDoDataBaseName)
//                .addMigrations(ToDoDataBase.MIGRATION_1_2)
                // .fallbackToDestructiveMigration()
                .build();
    }

    public static ToDoDataBase getToDoDataBase() {
        return toDoDataBase;
    }

    public static ApplicationController getInstance() {
        return instance;
    }
}
