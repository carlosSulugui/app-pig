package com.plusdesarrollo.mpxtoolkit.applist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.plusdesarrollo.mpxtoolkit.applist.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragment_container_view)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.homeFragment, R.id.registerFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.buttonNavigation.setupWithNavController(navController)


    }
}