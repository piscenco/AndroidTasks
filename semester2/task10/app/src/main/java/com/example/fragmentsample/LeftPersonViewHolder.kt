package com.example.fragmentsample
import android.view.Gravity
import android.view.View


class LeftPersonViewHolder(
    itemView: View,
    listener: PersonAdapter.Listener?
) : PersonViewHolder(itemView, listener) {
    init {
        textView.gravity = Gravity.START
    }

    override fun bind(flowerEl: FlowerEl) {
        data = flowerEl
        textView.text = flowerEl.name
    }

}