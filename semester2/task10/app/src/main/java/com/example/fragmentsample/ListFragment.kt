package com.example.fragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment(), PersonAdapter.Listener {


	override fun onCreateView(
			inflater: LayoutInflater,
			container: ViewGroup?,
			savedInstanceState: Bundle?): View? {
		super.onCreate(savedInstanceState)
		//setContentView(R.layout.fragment_list) //<- do not work. a fragment
		// R.layout.fragment_list
		/// how to address layout and modify without setContentView? where to store?


		return inflater.inflate(R.layout.fragment_list, container, false)

	}


	override fun onPersonClick(id: Long) {
		//startActivity(PersonDetailActivity.getIntent(this, id)) // open de
		(requireActivity() as DemoActivity).showDetailFragment("ghjkajsjakasd")
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		// view is root
		val recyclerView: RecyclerView = view.findViewById(R.id.flowersRecyclerView)
		recyclerView.layoutManager = LinearLayoutManager(context)
		recyclerView.setHasFixedSize(true)
		recyclerView.recycledViewPool.setMaxRecycledViews(0, 6)

		val adapter = PersonAdapter()
		recyclerView.adapter = adapter
		//PersonRepository.initialize(context)
		adapter.flowerElList = PersonRepository.getPersonList()
		adapter.listener = this

		val items = adapter.getItemCount()
		for(pos in 0 until items) {
			val v = recyclerView.layoutManager!!.findViewByPosition(pos)
			v?.setOnClickListener {
				(requireActivity() as DemoActivity).showDetailFragment("ghjkajsjakasd")
			}
		}
		adapter.notifyDataSetChanged()


		/*view.findViewById<View>(R.id.openDetailButton).setOnClickListener {
			(requireActivity() as DemoActivity).showDetailFragment("ghjkajsjakasd")
		}*/
	}

	companion object {
		const val TAG = "ListFragment"
		fun newInstance(): Fragment {
			return ListFragment()
		}
	}
}