package com.example.kotlinworkshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class ToDoAdapter(var toDoList: List<String>) : RecyclerView.Adapter<ToDoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(
            R.layout.item_todo,
            parent,
            false
        )
        return ToDoViewHolder(item)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.text.text = toDoList[position]
    }

    override fun getItemCount() = toDoList.size
}