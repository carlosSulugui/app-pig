package com.plusdesarrollo.mpxtoolkit.applist.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProviderListRemote
import com.plusdesarrollo.mpxtoolkit.applist.databinding.FragmentHomeBinding
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.adapter.HomeAdapter
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel.ViewModelProvider
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: HomeAdapter

    private val viewModelProvider: ViewModelProvider by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModelProvider.getProvider()
        lifecycleScope.launchWhenCreated {
            getProviders()
        }

    }


   private suspend fun getProviders() {
        viewModelProvider.success.collect { res ->
            when (res) {
                is Success.Failure -> {
                    Log.e("errors", res.error)
                }

                is Success.Loading -> {
                    res.isLoading.let {loading->
                        binding.progressCircular.isVisible = loading
                    }
                }
                is Success.SuccessFul<*> -> {
                    val result = res.data as ProviderListLocal
                    adapter = HomeAdapter()
                    adapter.diffUtil(result.providers)
                    adapter.listProvider = result.providers
                    binding.recycler.adapter = adapter


                }
            }
        }
    }
}


