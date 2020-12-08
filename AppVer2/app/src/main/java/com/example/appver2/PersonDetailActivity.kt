package com.example.appver2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.NetworkOnMainThreadException
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PersonDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)
        val id: Long = intent.getLongExtra(ID_KEY, -1)
        val person = PersonRepository.getPersonById(id)
        val descr_ = PersonRepository.getDescrById(id)
        val textView: TextView = findViewById(R.id.personNameTextView)
        val descrTextView: TextView = findViewById(R.id.flower_dicr_id)
        textView.text = person.name
        descrTextView.text = descr_.name

    }

    companion object {
        private const val ID_KEY = "ID_KEY"
        fun getIntent(context: Context?, id: Long): Intent {
            val intent = Intent(context, PersonDetailActivity::class.java)
            intent.putExtra(ID_KEY, id)
            return intent
        }
    }
}