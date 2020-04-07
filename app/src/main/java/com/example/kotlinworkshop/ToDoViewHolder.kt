package com.example.kotlinworkshop

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class ToDoViewHolder(item: View): RecyclerView.ViewHolder(item) {
    val text: TextView = item.todo
}