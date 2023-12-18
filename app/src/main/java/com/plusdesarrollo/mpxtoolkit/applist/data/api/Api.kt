package com.plusdesarrollo.mpxtoolkit.applist.data.api

import com.plusdesarrollo.mpxtoolkit.applist.core.WrapperResponse
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProviderListRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ResponseProvider
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RemoteService {
    @GET("task/provider")
    suspend fun  getProvides():Response<ProviderListRemote>
    @POST("task/provider")
    suspend fun setProvides(@Body provider: ProvidersRemote):Response<ResponseProvider>
    @GET("/searchprovides")
    suspend fun searchProvides(@Path ("name") name: String):WrapperResponse<ProviderListRemote>
}