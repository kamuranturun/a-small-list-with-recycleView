package com.example.deneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var todoAdapter: TodoAdapter
    private lateinit var todoRecycler: RecyclerView
    private lateinit var save: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        save = findViewById(R.id.btn_enter)

        todoRecycler = findViewById(R.id.todo_recycler)

        prepareTodoRecyclerAdapter()

        save.setOnClickListener(this)
    }

    private fun prepareTodoRecyclerAdapter() {
        todoAdapter = TodoAdapter(this)
        todoRecycler.layoutManager = LinearLayoutManager(this)
        todoRecycler.adapter = todoAdapter
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_enter -> {
                todoAdapter.bindTodoList(et_item.text.toString())
                et_item.text.clear()
            }


        }
    }
}