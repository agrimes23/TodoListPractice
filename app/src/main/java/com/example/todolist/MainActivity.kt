package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.databinding.ItemTodoBinding

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    private val vb by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        todoAdapter = TodoAdapter(mutableListOf())

        vb.rvTodoItems.adapter = todoAdapter
        vb.rvTodoItems.layoutManager = LinearLayoutManager(this)

        vb.btnAddTodo.setOnClickListener {
            val todoTitle = vb.etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                vb.etTodoTitle.text.clear()
            }
        }
        vb.btnDeleteDoneTodo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}