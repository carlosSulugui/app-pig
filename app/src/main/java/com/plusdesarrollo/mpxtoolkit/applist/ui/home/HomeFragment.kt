package com.plusdesarrollo.mpxtoolkit.applist.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.plusdesarrollo.mpxtoolkit.applist.R
import com.plusdesarrollo.mpxtoolkit.applist.core.BUNDLE
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal
import com.plusdesarrollo.mpxtoolkit.applist.databinding.FragmentHomeBinding
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.adapter.HomeAdapter
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel.ViewModelProvider
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import com.plusdesarrollo.mpxtoolkit.applist.utils.toast
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


        viewModelProvider.getLocation {
            toast("Latitud: ${it.latitude} Longitud: ${it.longitude}")
        }




        lifecycleScope.launchWhenCreated {
            getProviders()

        }
        lifecycleScope.launchWhenCreated {
            viewModelProvider.getProvider()
        }

    }


    private suspend fun getProviders() {
        viewModelProvider.success.collect { res ->
            when (res) {
                is Success.Failure -> {
                    Log.e("errors", res.error)
                }

                is Success.Loading -> {
                    res.isLoading.let { loading ->
                        binding.progressCircular.isVisible = loading
                    }
                }

                is Success.SuccessFul<*> -> {
                    val result = res.data as ProviderListLocal

                    adapter = HomeAdapter()
                    adapter.diffUtil(result.providers)
                    adapter.listProvider = result.providers
                    binding.recycler.adapter = adapter

                    adapter.click = {provider ->
                        val bundle = bundleOf(BUNDLE.PROVIDER to ProviderLocal.toJson(provider))
                        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
                    }
                    Log.d("result", "${result.providers}")


                    binding.searchBar.addTextChangedListener { onchange->
                        val search = result.providers.filter {provider -> provider.name!!.contains(onchange.toString())}
                        adapter.diffUtil(search)
                    }

                }
            }
        }
    }
}


