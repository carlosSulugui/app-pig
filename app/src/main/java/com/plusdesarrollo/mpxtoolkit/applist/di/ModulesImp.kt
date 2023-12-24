package com.plusdesarrollo.mpxtoolkit.applist.di


import com.plusdesarrollo.mpxtoolkit.applist.creational.builder.BuilderInterface
import com.plusdesarrollo.mpxtoolkit.applist.creational.builder.ProviderBuilder
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.CreateProviderServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.CreateProviderRemoteDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.CreateTaskRemoteDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.CreateTaskServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetProviderRemoteDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetProviderServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetTaskRemoterDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetTaskServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.SearchProviderDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.SearchProviderServerDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.experimental.ExperimentalTypeInference

@Module

@InstallIn(SingletonComponent::class)
abstract class ModulesImp {

    @Binds
    abstract fun bindProviderRemoteSource(createProvidesServerDataSource: CreateProviderServerDataSource): CreateProviderRemoteDataSource

    @Binds
    abstract fun bindGetProviderRemoteSource(getProviderRemoteDataSource: GetProviderServerDataSource): GetProviderRemoteDataSource

    @Binds
    abstract fun bindSearchProviderRemoteSource(searchProviderDataSource: SearchProviderServerDataSource): SearchProviderDataSource


    @Binds
    abstract fun bindGetProviderServerDataSource(getTaskServerDataSource: GetTaskServerDataSource): GetTaskRemoterDataSource

    @Binds
    abstract fun bindCreateTaskServerDataSource(createTaskServerDataSource: CreateTaskServerDataSource): CreateTaskRemoteDataSource
    @Binds
    abstract fun bindBuilderInterface(providerBuilder: ProviderBuilder): BuilderInterface


}