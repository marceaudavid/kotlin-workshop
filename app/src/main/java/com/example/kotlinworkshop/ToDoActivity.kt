package com.example.kotlinworkshop

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ToDoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var input: EditText
    private lateinit var button: Button

    private var db: ToDoDatabase? = null
    private var toDoList: List<ToDo>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        input = findViewById<EditText>(R.id.todo_input)
        button = findViewById<Button>(R.id.add_todo)

        db = ToDoDatabase.getDatabase(this)
        toDoList =  db?.toDoDao()?.getAll()

        viewManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewAdapter = toDoList?.let { ToDoAdapter(it, this) }!!

        recyclerView = findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        button.setOnClickListener(View.OnClickListener {
            var title = input.text.toString()
            input.text.clear();
            var todo = ToDo(title = title)
            db?.toDoDao()?.insert(todo)
            var newToDoList = db?.toDoDao()?.getAll()
            if (newToDoList != null) {
                (viewAdapter as ToDoAdapter).setData(newToDoList)
            }
        })
    }
}
