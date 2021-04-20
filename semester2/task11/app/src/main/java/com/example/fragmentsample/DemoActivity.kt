package com.example.fragmentsample

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.fragmentsample.DetailFragment.Companion.newInstance

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException;
import androidx.camera.view.CameraController;
import androidx.camera.view.LifecycleCameraController;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;


import android.net.Uri
import android.util.Log
import java.util.concurrent.Executors
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.nio.ByteBuffer
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
typealias LumaListener = (luma: Double) -> Unit


class DemoActivity : AppCompatActivity() {

	private var imageCapture: ImageCapture? = null

	private lateinit var outputDirectory: File
	private lateinit var cameraExecutor: ExecutorService

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_demo)
		if (savedInstanceState == null) {
			supportFragmentManager
				.beginTransaction()
				.replace(R.id.demoMainContainer, ListFragment.newInstance(), ListFragment.TAG)
				.addToBackStack(null)
				.commit()
		}
	}

	fun showDetailFragment(name: String) {
		if (supportFragmentManager.findFragmentByTag(DetailFragment.TAG) != null) {
			// Если на экране уже есть фрагмент с деталями, то надо его убрать перед показом нового
			supportFragmentManager.popBackStack()
		}
		supportFragmentManager
			.beginTransaction()
			.replace(R.id.demoDetailContainer, newInstance(name), DetailFragment.TAG)
			.addToBackStack(null)
			.commit()
	}

	override fun onBackPressed() {
		if (supportFragmentManager.backStackEntryCount == 1) {
			finish()
		} else {
			super.onBackPressed()
		}
	}
/*
	override fun onRequestPermissionsResult(
			requestCode: Int, permissions: Array<String>, grantResults:
			IntArray) {
		if (requestCode == REQUEST_CODE_PERMISSIONS) {
			if (allPermissionsGranted()) {
				startCamera()
			} else {
				Toast.makeText(this,
						"Permissions not granted by the user.",
						Toast.LENGTH_SHORT).show()
				finish()
			}
		}
	}*/

	companion object {
		fun getIntent(context: Context): Intent {
			return Intent(context, DemoActivity::class.java)
		}
	}
}