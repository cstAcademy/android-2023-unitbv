package com.cst.androidlab.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cst.androidlab.data.dao.ToDoDAO;
import com.cst.androidlab.data.models.ToDoItem;

@Database(entities = {ToDoItem.class},version = 1)
public abstract class ToDoDataBase extends RoomDatabase {

    public abstract ToDoDAO toDoDAO();

//    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE ToDoItem ADD COLUMN description TEXT");
//        }
//    };
}
