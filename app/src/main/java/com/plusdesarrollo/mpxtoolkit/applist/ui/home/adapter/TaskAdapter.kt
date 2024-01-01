package com.plusdesarrollo.mpxtoolkit.applist.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.plusdesarrollo.mpxtoolkit.applist.R
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.TasksLocal
import com.plusdesarrollo.mpxtoolkit.applist.databinding.ItemTaskBinding
import com.plusdesarrollo.mpxtoolkit.applist.utils.DiffUtil

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    var listTask: List<TasksLocal> = listOf()
    fun diffUtil(listNew: List<TasksLocal>) {
        val diffManager = DiffUtil(
            listTask,
            listNew,
        )

        val result = androidx.recyclerview.widget.DiffUtil.calculateDiff(diffManager)
        listTask = listNew
        result.dispatchUpdatesTo(this)
    }


    var click: ((String) -> Unit)? = null

    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemTaskBinding.bind(view)

        fun bind(tasksLocal: TasksLocal) = with(binding) {
            textView.text = tasksLocal.name
            textAddress.text = tasksLocal.address
            txtDate.text = tasksLocal.created_at

            root.setOnClickListener {
                click?.invoke(tasksLocal.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = listTask.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(listTask[position])
    }
}