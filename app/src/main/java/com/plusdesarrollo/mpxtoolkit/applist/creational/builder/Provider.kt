package com.plusdesarrollo.mpxtoolkit.applist.creational.builder

import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import javax.inject.Inject

class Provider @Inject constructor(
    private val providerBuilder: ProviderBuilder
) {
    fun createProvider(): ProvidersRemote {
        return providerBuilder.setName("carlso").build()
    }
}
