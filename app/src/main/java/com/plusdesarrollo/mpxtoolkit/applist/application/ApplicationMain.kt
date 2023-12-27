package com.plusdesarrollo.mpxtoolkit.applist.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext


@HiltAndroidApp
class ApplicationMain:Application(

) {
    lateinit var appComponent: ApplicationContext

    override fun onCreate() {
        super.onCreate()

        appComponent = ApplicationContext()

    }
}