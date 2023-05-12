package com.cst.androidlab.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.androidlab.R
import com.cst.androidlab.adapters.ToDosAdapter
import com.cst.androidlab.data.ToDoRepository
import com.cst.androidlab.data.models.ToDoItem
import com.cst.androidlab.models.ToDoItemElement

class LocalDataBaseActivity : AppCompatActivity() {
    private var button: Button? = null
    private var editTextTitle: EditText? = null
    private var editTextDescription: EditText? = null
    private val toDoRepository = ToDoRepository()
    private var progressBar: ProgressBar? = null

    private val todoList by lazy {
        ArrayList<ToDoItemElement>()
    }

    private var todoAdapter: ToDosAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_local_data_base)
        setupViews()
    }

    private fun setupViews() {
        setupRecyclerView()

        button = findViewById(R.id.button_data)
        editTextTitle = findViewById(R.id.editable_title)
        editTextDescription = findViewById(R.id.editable_description)
        button?.setOnClickListener {
            insertToDo()
        }
        findViewById<Button>(R.id.button_get).setOnClickListener {
            getToDos()
        }
        progressBar = findViewById(R.id.pb_loading)
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.rv_todos)
        val layoutManager: LinearLayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        //val layoutManager: GridLayoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, true)
        recyclerView.layoutManager = layoutManager

        todoAdapter = ToDosAdapter(todoList)
        recyclerView.adapter = todoAdapter
    }

    private fun getToDos() {
        progressBar?.visibility = View.VISIBLE
        toDoRepository.getAllToDo { toDoListResult ->
            todoList.clear()
            toDoListResult.forEach { toDoItem ->
                todoList.add(toDoItem.convert())
            }

            todoAdapter?.notifyItemRangeChanged(0, todoList.size)

            progressBar?.visibility = View.GONE
        }
    }

    private fun insertToDo() {
        val title = editTextTitle?.text?.toString() ?: return
        when (title.isEmpty()) {
            true -> {
                editTextTitle?.error = getString(R.string.error_required)
                return
            }

            false -> editTextTitle?.error = null
        }

        val description = editTextDescription?.text?.toString() ?: return
        when (description.isEmpty()) {
            true -> {
                editTextDescription?.error = getString(R.string.error_required)
                return
            }

            false -> editTextDescription?.error = null
        }

        val toDoItem = ToDoItem(
            title,
            description
        )

        toDoRepository.insertToDo(toDoItem) {
            todoList.add(toDoItem.convert())

            todoAdapter?.notifyItemChanged(todoList.size - 1)
//            todoAdapter?.notifyDataSetChanged()

            Toast.makeText(
                this, "Success.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}