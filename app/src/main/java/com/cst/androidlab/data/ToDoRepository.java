package com.cst.androidlab.data;

import com.cst.androidlab.ApplicationController;
import com.cst.androidlab.data.models.ToDoItem;
import com.cst.androidlab.data.tasks.GetAllToDosTask;
import com.cst.androidlab.data.tasks.InsertToDoTask;
import com.cst.androidlab.data.tasks.UpdateToDoTask;

import java.util.List;

public class ToDoRepository {
    public static interface OnSuccesListener {
        void onSuccess();
    }

    public static interface OnGetToDosListerner {
        void onSuccess(List<ToDoItem> items);
    }

    private final ToDoDataBase toDoDataBase;

    public ToDoRepository() {
        toDoDataBase = ApplicationController.getToDoDataBase();
    }

    public void insertToDo(ToDoItem toDoItem, OnSuccesListener listener) {
        new InsertToDoTask(toDoDataBase, listener).execute(toDoItem);
    }

    public void getAllToDo(OnGetToDosListerner listener) {
        new GetAllToDosTask(toDoDataBase, listener).execute();
    }

    public void updateToDo(ToDoItem toDoItem, OnSuccesListener listener) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                new UpdateToDoTask(toDoDataBase, listener).execute(toDoItem);
//            }
//        }, 5000);
        new UpdateToDoTask(toDoDataBase, listener).execute(toDoItem);
    }
}
