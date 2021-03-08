
package com.example.fragmentsample
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PersonListActivity : AppCompatActivity(), PersonAdapter.Listener {
	override fun onPersonClick(id: Long) {
		//startActtivity(PersonDetailActivity.getIntent(this, id))
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_person_list)

		val recyclerView: RecyclerView = findViewById(R.id.personRecyclerView)
		recyclerView.layoutManager = LinearLayoutManager(this)
		recyclerView.setHasFixedSize(true)
		recyclerView.recycledViewPool.setMaxRecycledViews(0, 6)

		val adapter = PersonAdapter()
		recyclerView.adapter = adapter
        PersonRepository.initialize(this)
		adapter.personList = PersonRepository.getPersonList()
		adapter.listener = this
	}
}