package com.plusdesarrollo.mpxtoolkit.applist.utils

import androidx.recyclerview.widget.DiffUtil

class DiffUtil<T>(
    private val listOld:List<T> = listOf(),
    private val listNew:List<T> = listOf()

) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = listOld.size

    override fun getNewListSize(): Int = listNew.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return listOld[oldItemPosition] == listNew[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return listOld[oldItemPosition] == listNew[newItemPosition]
    }

}