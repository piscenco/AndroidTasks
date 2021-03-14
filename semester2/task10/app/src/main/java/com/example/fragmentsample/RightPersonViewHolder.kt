package com.example.fragmentsample

import android.view.View

class RightPersonViewHolder(
	itemView: View,
	listener: PersonAdapter.Listener?
) : PersonViewHolder(itemView, listener) {
	init {
		//textView.gravity = Gravity.END
	}

	override fun bind(flowerEl: FlowerEl) {
		data = flowerEl
		textView.text = flowerEl.name
	}

}