package com.example.fragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment(){


	override fun onCreateView(
			inflater: LayoutInflater,
			container: ViewGroup?,
			savedInstanceState: Bundle?): View? {
		super.onCreate(savedInstanceState)
		return inflater.inflate(R.layout.fragment_list, container, false)

	}




	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		// view is root
		view.findViewById<View>(R.id.card1).setOnClickListener {
			(requireActivity() as DemoActivity).showDetailFragment(resources.getString(R.string.iris_text))
		}

		view.findViewById<View>(R.id.card2).setOnClickListener {
			(requireActivity() as DemoActivity).showDetailFragment(resources.getString(R.string.rose_text))
		}

	}

	companion object {
		const val TAG = "ListFragment"
		fun newInstance(): Fragment {
			return ListFragment()
		}
	}
}