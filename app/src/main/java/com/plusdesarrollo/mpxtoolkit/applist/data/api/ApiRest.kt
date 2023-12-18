package com.plusdesarrollo.mpxtoolkit.applist.data.api

import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProviderListRemote
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiRest {
    private val builder: Retrofit.Builder = Retrofit
        .Builder()
        .baseUrl("http://192.168.0.106:3000/api/tasks/")
        .addConverterFactory(GsonConverterFactory.create())

    interface ApiInterface {
        @GET("task/provider")
        fun getProvides(): Call<ProviderListRemote>

    }
    fun build(): ApiInterface {
        return builder.build().create(ApiInterface::class.java)
    }
}