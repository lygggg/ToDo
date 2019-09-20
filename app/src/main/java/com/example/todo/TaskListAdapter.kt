package com.example.todo

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*

class TaskListAdapter : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    var items : MutableList<TaskItem> = mutableListOf() //컬렉션 동적 리스트0

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        Log.d("onBindViewholder", ""+position)
        holder.tvTaskTitle.text = items[position].title

    }

    fun addItem(item: TaskItem) {
        items.add(item)
        notifyDataSetChanged()
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTaskTitle: TextView = itemView?.tv_task_name
    }

}


