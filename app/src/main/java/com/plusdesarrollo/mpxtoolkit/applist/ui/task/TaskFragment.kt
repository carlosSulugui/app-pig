package com.plusdesarrollo.mpxtoolkit.applist.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.plusdesarrollo.mpxtoolkit.applist.R
import com.plusdesarrollo.mpxtoolkit.applist.data.local.TaskListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.TasksLocal
import com.plusdesarrollo.mpxtoolkit.applist.databinding.FragmentTaskBinding
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.adapter.TaskAdapter
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel.TaskViewModel
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import com.plusdesarrollo.mpxtoolkit.applist.utils.toast

class TaskFragment : Fragment() {
    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TaskViewModel by viewModels()
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    private suspend fun render() {
        viewModel.success.collect{success ->
            when(success){
                is Success.Failure -> {
                    toast(success.error)
                }
                is Success.Loading -> {

                }
                is Success.SuccessFul<*> -> {
                    val adapterTask = TaskAdapter()
                    val list = success.data as TaskListLocal
                    adapterTask.diffUtil(list.tasks)

                }
                else -> {}
            }
        }
    }
}