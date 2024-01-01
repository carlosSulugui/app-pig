package com.plusdesarrollo.mpxtoolkit.applist.utils

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.toast(message:String){
    Toast.makeText( requireContext() , message, Toast.LENGTH_SHORT).show()
}

fun EditText.text(): String = text.toString()