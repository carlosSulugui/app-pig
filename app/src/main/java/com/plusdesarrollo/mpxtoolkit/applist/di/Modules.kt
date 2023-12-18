package com.plusdesarrollo.mpxtoolkit.applist.di


import com.plusdesarrollo.mpxtoolkit.applist.core.URL_API
import com.plusdesarrollo.mpxtoolkit.applist.data.api.RemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
@Module
@InstallIn(SingletonComponent::class)

class Modules {

    @Provides
    @Singleton
    @APIUrl
    fun providerAPIUrl():String  = "http://192.168.0.106:3000/api/tasks/"

    @Provides
    @Singleton
    fun providerOkHttpClient(): OkHttpClient =  HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    @Provides
    @Singleton
    fun providerRemoteService(@APIUrl url: String , okHttpClient: OkHttpClient):RemoteService  {
       return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create()

    }
}