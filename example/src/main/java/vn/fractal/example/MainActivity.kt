package vn.fractal.example

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import vn.fractal.library.SmartLocation
import vn.fractal.library.location.config.LocationParams

class MainActivity : AppCompatActivity() {
    private val locationPermissionRequestCode = 1

    lateinit var textView: TextView
    lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btn_location)
        textView = findViewById(R.id.text_location)
        button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
            ) {
                // Permission is already granted
                // You can start accessing the fine location here
                getLocation()
            } else {
                // Permission is not granted
                // Request the permission
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    locationPermissionRequestCode
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionRequestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can start accessing the fine location here
                getLocation()
            } else {
                // Permission denied, handle this scenario accordingly
            }
        }
    }

    private fun getLocation() {
        val smartLocation = SmartLocation.with(this@MainActivity)
        smartLocation.location().config(LocationParams.NAVIGATION).oneFix().start {
            textView.text = "Lat: ${it.latitude} - Long: ${it.longitude}"

        }
    }

}