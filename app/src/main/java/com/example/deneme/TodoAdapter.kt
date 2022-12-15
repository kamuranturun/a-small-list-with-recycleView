package com.example.deneme

import android.content.Context
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class TodoAdapter(val context: Context) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    private val todoList = ArrayList<String>()


    fun bindTodoList(todo: String) {
        todoList.add(todo)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {

            itemView.btnDelete.setOnClickListener(this)


        }

        // burası calısır.
        fun bind(myItem: String) {
            itemView.tv_title.text = myItem
            itemView.btnDelete.tag = myItem
            itemView.btnUpdate.tag =myItem

            itemView.btnUpdate.setOnClickListener{
              Toast.makeText(context,"asdjfasjd",Toast.LENGTH_LONG).show()
                updateAt(adapterPosition)
            }

            itemView.setOnClickListener { }

        }

        private fun updateAt(adapterPosition: Int) {



        }


        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.btnDelete -> {
                    removeAt(adapterPosition)


                }

            }

        }

        private fun removeAt(adapterPosition: Int) {
            todoList.removeAt(adapterPosition)
            notifyItemRemoved(adapterPosition)


            //notifyItemRemoved(position)
            //notifyItemRangeChanged(position, itemCount)
        }
    }

    // İlk burası çalışır.
    // Arraylist'inin uzunluğu kadar sana view holder oluşturur.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("OnCreateee", "onCreateViewHolder")
        val myListItem: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(myListItem)
    }

    // İkinvi burası çalışır
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("OnCreateee", "onBindViewHolder: $position")
        holder.bind(todoList[position])

    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}