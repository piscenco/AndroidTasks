package com.example.fragmentsample

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.fragmentsample.db.DatabaseHolder

class App : Application() {
	override fun onCreate() {
		super.onCreate()
		context = this
		databaseHolder = DatabaseHolder(this)
	}

	companion object {
		// Способ получения контекста из любой части приложения
		@SuppressLint("StaticFieldLeak")
		var context: Context? = null
			private set
		@JvmStatic
		var databaseHolder: DatabaseHolder? = null
			private set
	}
}