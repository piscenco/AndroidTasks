package com.example.fragmentsample

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmentsample.db.Flower
import com.example.fragmentsample.db.FlowerRepository
import java.util.*
import com.example.fragmentsample.App.Companion.databaseHolder

import com.squareup.picasso.Picasso;

class DetailFragment : Fragment(), View.OnClickListener {
	private lateinit var textView: TextView
	private lateinit var flowerRepository: FlowerRepository

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_detail, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		var textView = view.findViewById<TextView>(R.id.detailTextView)
		val imageView = view.findViewById<ImageView>(R.id.detailed_img)
		val flower_name = requireArguments().getString(FLOWER_TYPE)
		if(flower_name=="iris") {
			textView.text = resources.getString(R.string.iris_text)
			imageView.setImageResource(R.drawable.iris1)
		}
		if(flower_name=="rose") {
			textView.text = resources.getString(R.string.rose_text)
			//
			//imageView.setImageResource(R.drawable.rose)
			// "https://img1.akspic.com/image/94611-kitten-american_shorthair-cat-whiskers-munchkin_cat-2560x1440.jpg"
			// "https://www.thephotoargus.com/wp-content/uploads/2020/02/rosepic15.jpg"
			Picasso
					.get()
					.load("https://img1.akspic.com/image/94611-kitten-american_shorthair-cat-whiskers-munchkin_cat-2560x1440.jpg")
					.fit()
					.centerCrop()
					.into(imageView);
		}
		textView = view.findViewById(R.id.textView)
		view.findViewById<View>(R.id.createButton).setOnClickListener(this)
		view.findViewById<View>(R.id.loadButton).setOnClickListener(this)
		flowerRepository = FlowerRepository(databaseHolder ?: return)

	}

	override fun onClick(v: View) {
		val id = v.id
		if (id == R.id.createButton) {
			onCreateButtonClick()
		} else if (id == R.id.loadButton) {
			onLoadButtonClick()
		}
	}

	private fun onCreateButtonClick() {
		object : AsyncTask<Void?, Void?, Void?>() {
			override fun doInBackground(vararg voids: Void?): Void? {
				val flower = Flower()
				flower.name = UUID.randomUUID().toString()
				flowerRepository.addEl(flower)
				return null
			}
		}.execute()
	}


	private fun onLoadButtonClick() {
		object : AsyncTask<Void?, Void?, String>() {
			override fun doInBackground(vararg voids: Void?): String {
				return flowerRepository.loadAll().toString()
			}

			override fun onPostExecute(s: String) {
				super.onPostExecute(s)
				textView.text = s
			}
		}.execute()
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