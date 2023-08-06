package com.plusdesarrollo.mpxtoolkit.applist.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels

import androidx.lifecycle.lifecycleScope
import com.plusdesarrollo.mpxtoolkit.applist.R
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.location.Geolocation
import com.plusdesarrollo.mpxtoolkit.applist.data.local.Message
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.databinding.FragmentRegisterBinding
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel.ViewModelProvider
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import com.plusdesarrollo.mpxtoolkit.applist.utils.text
import com.plusdesarrollo.mpxtoolkit.applist.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.util.Base64

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModelPost: ViewModelProvider by viewModels()
    private val CODE = 100
    private var bitmap: Bitmap? = null
    private var imagePhoto: String? = ""

    private val geolocation: Geolocation = Geolocation()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.image.setOnClickListener {
            takePhoto()
        }



        binding.btnRegister.setOnClickListener {
            lifecycleScope.launch {
                postProvider()
            }
        }
    }

    private suspend fun postProvider() {
        val name = binding.editName.text()
        val price = binding.editPrice.text().toInt()
        val location = binding.editLocation.text()
        val weight = binding.editPeso.text().toInt()


        val body = ProvidersRemote(
            name = name,
            isCansel = true,
            price = price,
            weight = weight,
            address = location,
            photo = imagePhoto
        )

        when {
            name.isEmpty() -> error("el nombre es obligagtorio")
            price.toString().isEmpty() -> error("capo obligarorio")
            weight.toString().isEmpty() -> error("capo obligarorio")
            location.isEmpty() -> error("capo obligarorio")
            else -> {
                postData(body)
            }
        }

    }

    suspend fun postData(body: ProvidersRemote) {
        viewModelPost.createProvider(body)

        viewModelPost.success.collect { res ->
            when (res) {
                is Success.Failure -> {
                    activity?.toast(res.error)
                }

                is Success.Loading -> {
                    res.isLoading.let { loading ->
                        {
                            binding.progressCircular.isVisible = loading
                        }
                    }
                }

                is Success.SuccessFul<*> -> {

                    val message = res.data as Message
                    activity?.toast(message.message)

                }
            }
        }
    }

    fun takePhoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(intent, CODE)
        } catch (e: Exception) {
            activity?.toast("Error: ${e.message}")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE && resultCode == RESULT_OK) {
            val Imagebitmap = data?.extras?.get("data") as Bitmap
            binding.image.setImageBitmap(Imagebitmap)
            bitmap = Imagebitmap

//        convert in base64
            val stream = ByteArrayOutputStream()
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val imageBytes = stream.toByteArray()
            val imageString = Base64.getEncoder().encodeToString(imageBytes)
            imagePhoto = imageString.toString()

            Log.d("image", "${imageString.length}")


            Log.d("image", imageString)

//        convert buffer


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}