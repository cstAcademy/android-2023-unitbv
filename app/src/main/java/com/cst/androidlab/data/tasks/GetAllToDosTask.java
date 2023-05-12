package com.cst.androidlab.data.tasks;

import android.os.AsyncTask;

import com.cst.androidlab.data.ToDoDataBase;
import com.cst.androidlab.data.ToDoRepository;
import com.cst.androidlab.data.models.ToDoItem;

import java.util.List;

public class GetAllToDosTask extends AsyncTask<Void,Void,List<ToDoItem>> {
    private ToDoDataBase toDoDataBase;
    private ToDoRepository.OnGetToDosListerner listener;

    public GetAllToDosTask(ToDoDataBase toDoDataBase, ToDoRepository.OnGetToDosListerner listener){
        this.toDoDataBase = toDoDataBase;
        this.listener = listener;
    }

    @Override
    protected List<ToDoItem> doInBackground(Void... voids) {
        return toDoDataBase.toDoDAO().getAll();
    }

    @Override
    protected void onPostExecute(List<ToDoItem> items) {
        super.onPostExecute(items);
        listener.onSuccess(items);
    }
}
