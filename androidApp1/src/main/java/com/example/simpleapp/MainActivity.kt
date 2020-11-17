package com.example.simpleapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = "Notes"
        setContentView(R.layout.activity_main)
    }
    fun goToDescr(v: View?) {
        val intent = Intent(this, SubsidiaryActivity::class.java)
        startActivity(intent)
    }
}


