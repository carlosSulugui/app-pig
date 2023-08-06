package com.plusdesarrollo.mpxtoolkit.applist.utils

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.glide(url:String){
    Glide.with(this).load(url).into(this)
}