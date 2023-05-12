package com.cst.androidlab.data.tasks;

import android.os.AsyncTask;

import com.cst.androidlab.data.ToDoDataBase;
import com.cst.androidlab.data.ToDoRepository;
import com.cst.androidlab.data.models.ToDoItem;

public class UpdateToDoTask extends AsyncTask<ToDoItem,Void,Void> {
    private ToDoDataBase toDoDataBase;
    private ToDoRepository.OnSuccesListener listener;

    public UpdateToDoTask(ToDoDataBase toDoDataBase, ToDoRepository.OnSuccesListener listener){
        this.toDoDataBase = toDoDataBase;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(ToDoItem... toDoItems) {
        toDoDataBase.toDoDAO().update(toDoItems[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onSuccess();
    }
}
