package com.example.simpleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SubsidiaryActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = "Notes"
        setContentView(R.layout.activity_subsidiary)
    }
}