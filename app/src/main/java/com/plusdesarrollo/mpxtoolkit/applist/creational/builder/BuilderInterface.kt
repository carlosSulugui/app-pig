package com.plusdesarrollo.mpxtoolkit.applist.creational.builder

import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote

//esta funcion sirve para la creacion de clases complljas paso a paso
interface BuilderInterface {
    fun setName(name:String):BuilderInterface
    fun setPhone(phone:String?) :BuilderInterface
    fun setId(task_id:String?):BuilderInterface
    fun setPrice(price:Double?):BuilderInterface
    fun setWeight(weight:Int?) :BuilderInterface
    fun setStatus(status:String?) :BuilderInterface
    fun setPhoto(photo:String? ):BuilderInterface
    fun setAddress (address:String?):BuilderInterface
    fun build():ProvidersRemote

}