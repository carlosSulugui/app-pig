package com.plusdesarrollo.mpxtoolkit.applist.data.local

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.provider.Settings
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.getSystemService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.plusdesarrollo.mpxtoolkit.applist.core.CODES
import com.plusdesarrollo.mpxtoolkit.applist.utils.toast
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class GetLocationImp @Inject constructor(
    @ApplicationContext private val context: Context,
) : GetLocation {

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getLocation(): Location? {
//        var address = ""
//        if (checkedPermission()) {
//
//            if (isLocationEnabled()) {
//                if (ActivityCompat.checkSelfPermission(
//                        context, Manifest.permission.ACCESS_FINE_LOCATION
//                    )
//                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                        context, Manifest.permission.ACCESS_COARSE_LOCATION
//                    )
//                    != PackageManager.PERMISSION_GRANTED
//                ) {
//                    return " "
//                }
//                fusedLocationClient.lastLocation.addOnCompleteListener { task ->
//                    task.result.let { location ->
//                        address = "${location?.latitude} ${location?.longitude}"
//                        Log.d("LOCATION", "getLocation: $address")
//                    }
//                }
//            } else {
//                val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
//                startActivity(context, intent, null)
//            }
//        } else {
//            requestPermissions()
//        }
//
//
//        return address

        val focusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        val isUserLocationPermissionGranted = true
        val locationManager  = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGPSEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)


        if(!isGPSEnabled && !isUserLocationPermissionGranted){
            return null
        }

        return suspendCancellableCoroutine { cont ->
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

            }
            focusedLocationProviderClient.lastLocation.apply {
                if(isComplete) {
                    if (isSuccessful){
                        cont.resume(result){}
                    }else{
                        cont.resume(null){}
                    }

                    return@suspendCancellableCoroutine
                }

                addOnSuccessListener {
                    cont.resume(it){}
                }
                addOnFailureListener{
                    cont.resume(null){}
                }
                addOnCanceledListener { cont.resume(null){} }
            }
        }
    }




private fun checkedPermission(): Boolean {
    return (ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
            ==
            PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED)

}

private fun requestPermissions() {
    ActivityCompat.requestPermissions(
        this.context as Activity,
        arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        ),
        CODES.CODE
    )
}

private fun isLocationEnabled(): Boolean {
    val locationManager: LocationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
        LocationManager.NETWORK_PROVIDER
    )
}

}