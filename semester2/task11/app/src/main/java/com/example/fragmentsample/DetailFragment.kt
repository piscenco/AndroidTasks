package com.example.fragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_detail, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val textView = view.findViewById<TextView>(R.id.detailTextView)
		val imageView = view.findViewById<ImageView>(R.id.detailed_img)
		val flower_name = requireArguments().getString(FLOWER_TYPE)
		if(flower_name=="iris") {
			textView.text = resources.getString(R.string.iris_text)
			imageView.setImageResource(R.drawable.iris1)
		}
		if(flower_name=="rose") {
			textView.text = resources.getString(R.string.rose_text)
			imageView.setImageResource(R.drawable.rose)
		}

		/*
		when (flower_name) {
			"iris" -> imageView.setImageResource(R.drawable.iris1)
			"rose" -> imageView.setImageResource(R.drawable.rose)
		}*/

	}

	companion object {
		const val TAG = "DetailFragment"
		private const val NAME_KEY = "NAME_KEY"
		private const val FLOWER_TYPE = "FLOWER_TYPE"
		fun newInstance(flower_name: String): Fragment {
			val fragment: Fragment = DetailFragment()
			val arguments = Bundle()
			arguments.putString(FLOWER_TYPE, flower_name)
			fragment.arguments = arguments
			return fragment
		}
	}
}