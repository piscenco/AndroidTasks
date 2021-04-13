package com.example.fragmentsample

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentsample.db.Flower
import com.example.fragmentsample.db.FlowerRepository
import java.net.URI.create
import java.util.*
import com.example.fragmentsample.App.Companion.databaseHolder

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		findViewById<View>(R.id.demoButton).setOnClickListener {
			startActivity(DemoActivity.getIntent(this@MainActivity))
		}
	}




}