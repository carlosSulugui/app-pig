package com.plusdesarrollo.mpxtoolkit.applist.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import com.plusdesarrollo.mpxtoolkit.applist.R
import com.plusdesarrollo.mpxtoolkit.applist.core.BUNDLE
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal
import com.plusdesarrollo.mpxtoolkit.applist.databinding.FragmentDetailsBinding
import java.io.ByteArrayOutputStream


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var provider: ProviderLocal
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { args ->
            args.getString(BUNDLE.PROVIDER)?.let { pro ->
                provider = ProviderLocal.fromJson(pro)
            }

            setupView()
        }

    }





    private fun setupView() {
        provider.apply {
            photo?.let {
                //mejorar la nitides de la imagen con el bitmap


                val imageBytes = Base64.decode(it , Base64.DEFAULT)


                val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                //como hacer aspectration de la imagen
                decodedImage.colorSpace


                binding.imageView.setImageBitmap(decodedImage)
            }
        }
    }
}