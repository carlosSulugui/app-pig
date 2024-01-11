package com.plusdesarrollo.mpxtoolkit.applist.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.location.Location
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.plusdesarrollo.mpxtoolkit.applist.creational.builder.ProviderBuilder
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.location.Geolocation
import com.plusdesarrollo.mpxtoolkit.applist.data.local.Message
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.databinding.FragmentRegisterBinding
import com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel.ViewModelProvider
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import com.plusdesarrollo.mpxtoolkit.applist.utils.text
import com.plusdesarrollo.mpxtoolkit.applist.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.util.Base64
import javax.inject.Inject

@AndroidEntryPoint
class RegisterFragment(

) :  Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModelPost: ViewModelProvider by viewModels()
    private val CODE = 100
    private var  location: String = ""
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
        viewModelPost.getLocation {
            location = "${it.latitude} ${it.longitude}"
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
        val weight = binding.editPeso.text().toInt()
        val phone = binding.editTelephone.text()


        val provider = ProviderBuilder()
            .setName(name)
            .setPrice(price.toString().toDouble())
            .setWeight(weight)
            .setPhone(phone)
            .setPhoto(imagePhoto)
            .setId("27f0afcb-97d2-11ee-a208-0242ac150002")
            .setStatus("vivo")
            .setAddress(location)
            .build()



        when {
            name.isEmpty() -> error("el nombre es obligagtorio")
            price.toString().isEmpty() -> error("capo obligarorio")
            weight.toString().isEmpty() -> error("capo obligarorio")
            else -> {
                postData(provider)
            }
        }

    }

    suspend fun postData(body: ProvidersRemote) {
        viewModelPost.createProvider(body)

        viewModelPost.success.collect { res ->
            when (res) {
                is Success.Failure -> {
                    toast(res.error)
                    Log.d("error","${ res.error }")
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
                    toast(message.message)

                }
            }
        }
    }

    fun takePhoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(intent, CODE)
        } catch (e: Exception) {
            toast("Error: ${e.message}")
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