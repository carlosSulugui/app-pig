package com.plusdesarrollo.mpxtoolkit.applist.data.local

import android.location.Location

interface GetLocation {
   suspend fun getLocation(): Location?


}