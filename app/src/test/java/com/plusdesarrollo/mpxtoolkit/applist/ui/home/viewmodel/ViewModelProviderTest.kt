package com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.plusdesarrollo.mpxtoolkit.applist.core.Result
import com.plusdesarrollo.mpxtoolkit.applist.data.api.RemoteService
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetProviderServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.repository.GetProviderRepository
import com.plusdesarrollo.mpxtoolkit.applist.usecase.GetProvides
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import javax.inject.Inject

class ViewModelProviderTest  {

}