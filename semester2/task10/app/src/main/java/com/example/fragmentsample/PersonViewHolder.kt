package com.example.fragmentsample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

abstract class PersonViewHolder(itemView: View, listener: PersonAdapter.Listener?)
	: RecyclerView.ViewHolder(itemView) {
	protected val textView: TextView = itemView.findViewById(R.id.flowerNameTextView)
	protected lateinit var data: FlowerEl

	init {
		itemView.setOnClickListener {
			listener?.onPersonClick(data.id)
		}
	}

	abstract fun bind(flowerEl: FlowerEl)

}