package com.plusdesarrollo.mpxtoolkit.applist.ui.home.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.plusdesarrollo.mpxtoolkit.applist.databinding.ItemTaskBinding

class TaskAdapter:RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val binding = ItemTaskBinding.bind(view)

        fun bind() = with(binding) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}