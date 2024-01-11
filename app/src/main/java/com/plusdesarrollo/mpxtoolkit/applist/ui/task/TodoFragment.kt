package com.plusdesarrollo.mpxtoolkit.applist.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.plusdesarrollo.mpxtoolkit.applist.R
import com.plusdesarrollo.mpxtoolkit.applist.actions.view.ActionButton
import com.plusdesarrollo.mpxtoolkit.applist.data.local.TaskListLocal
import com.plusdesarrollo.mpxtoolkit.applist.databinding.FragmentTodoBinding
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.adapter.TaskAdapter
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel.TaskViewModel
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import com.plusdesarrollo.mpxtoolkit.applist.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            viewModel.getTask()

        }

        lifecycleScope.launchWhenCreated {
            render()
        }

        //como hacer uso del bottom sheet

        binding.btnAdd.setOnClickListener{
            openBottomSheet()
        }
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
                    binding.recyclerView.adapter = adapterTask
                    adapterTask.click= {id ->
                        toast(id)
                    }
                }
            }
        }
    }
    private fun  openBottomSheet(){
        val actionBottom = ActionButton.newInstance()
        actionBottom.show(
            requireActivity().supportFragmentManager, ActionButton.TAG
        )

        actionBottom.event = {
            toast("hola que tal como estas")
        }
    }
}

