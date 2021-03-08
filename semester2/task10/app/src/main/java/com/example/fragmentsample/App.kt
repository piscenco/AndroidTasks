package com.example.fragmentsample

import android.app.Application

class App : Application() {
	override fun onCreate() {
		super.onCreate()
		PersonRepository.initialize(this)
	}
}