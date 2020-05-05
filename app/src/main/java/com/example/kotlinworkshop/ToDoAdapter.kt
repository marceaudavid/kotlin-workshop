package com.example.kotlinworkshop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView


class ToDoAdapter(
    var toDoList: List<ToDo>,
    var toDoActivity: ToDoActivity
) : RecyclerView.Adapter<ToDoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(
            R.layout.item_todo,
            parent,
            false
        )
        return ToDoViewHolder(item)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.text.text = toDoList[position].title
        onClick(holder, toDoList[position], toDoActivity)
    }

    fun setData(newToDoList: List<ToDo>) {
        toDoList = newToDoList
        notifyDataSetChanged()
    }

    override fun getItemCount() = toDoList.size

    private fun onClick(holder: ToDoViewHolder, todo: ToDo, toDoActivity: ToDoActivity) {
        holder.text.setOnClickListener(View.OnClickListener {
            if (toDoActivity.findViewById<FrameLayout>(R.id.fragment_container) === null) {
                val intent = Intent(holder.text.context, DetailActivity::class.java);
                intent.putExtra("id", todo.id)
                intent.putExtra("title", todo.title)
                holder.text.context.startActivity(intent);
            } else {
                val fragmentManager = toDoActivity.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                val fragment = DetailFragment()
                val bundle = Bundle()
                bundle.putInt("id", todo.id)
                bundle.putString("title", todo.title)
                fragment.arguments = bundle
                fragmentTransaction.add(R.id.fragment_container, fragment, "fragment")
                fragmentTransaction.commit()
            }
        })
    }
}