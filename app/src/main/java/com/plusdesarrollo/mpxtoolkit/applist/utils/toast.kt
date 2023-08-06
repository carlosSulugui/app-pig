package com.plusdesarrollo.mpxtoolkit.applist.utils

import android.content.Context
import android.widget.EditText
import android.widget.Toast


fun Context.toast(message:String){
    Toast.makeText(this , message, Toast.LENGTH_SHORT).show()
}

fun EditText.text(): String = text.toString()