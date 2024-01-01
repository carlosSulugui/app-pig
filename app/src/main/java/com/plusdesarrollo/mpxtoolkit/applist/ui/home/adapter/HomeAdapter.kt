package com.plusdesarrollo.mpxtoolkit.applist.ui.home.adapter

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arrow.core.right
import com.bumptech.glide.ListPreloader
import com.plusdesarrollo.mpxtoolkit.applist.R
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.databinding.ItemListBinding
import com.plusdesarrollo.mpxtoolkit.applist.utils.DiffUtil
import androidx.recyclerview.widget.DiffUtil as androidxDiffUtil

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var listProvider: List<ProviderLocal> = listOf()
    var click: ((ProviderLocal)-> Unit)? = null

    fun diffUtil(listNew: List<ProviderLocal>) {
        val diffManager = DiffUtil(
            listProvider,
            listNew,
        )

        val result = androidxDiffUtil.calculateDiff(diffManager)
        listProvider = listNew
        result.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(user: ProviderLocal) = with(binding) {
            textName.text = "Nombre: ${user.name}"
            textTelephone.text = "Telefono: ${user.phone}"
            textPrise.text = "QGT ${user.price.toString()}"
            textPeso.text = "Peso Lb:${user.weight}"
            textAddress.text = "${user.address}"

            user.photo?.let {image ->
                val imageBytes = Base64.decode(image , Base64.DEFAULT)
                val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                imgPig.setImageBitmap(decodedImage)
            }

            textName.setOnClickListener {
                click?.invoke(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listProvider[position])
    }

    override fun getItemCount(): Int {
        return listProvider.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateFilter(listPreloader: List<ProviderLocal>){
        this.listProvider = listPreloader
        notifyDataSetChanged()
    }
}