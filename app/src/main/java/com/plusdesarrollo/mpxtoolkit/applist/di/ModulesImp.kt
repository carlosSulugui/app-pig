package com.plusdesarrollo.mpxtoolkit.applist.di


import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.CreateProviderServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.CreateProviderRemoteDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetProviderRemoteDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetProviderServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.SearchProviderDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.SearchProviderServerDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module

@InstallIn(SingletonComponent::class)
abstract class ModulesImp {

    @Binds
    abstract fun bindProviderRemoteSource(createProvidesServerDataSource: CreateProviderServerDataSource): CreateProviderRemoteDataSource

    @Binds
    abstract fun bindGetProviderRemoteSource(getProviderRemoteDataSource: GetProviderServerDataSource): GetProviderRemoteDataSource

    @Binds
    abstract fun bindSearchProviderRemoteSource(searchProviderDataSource: SearchProviderServerDataSource): SearchProviderDataSource
}