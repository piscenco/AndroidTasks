package com.example.simpleapp

import android.animation.*
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {
    lateinit var card1: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.title = "Notes"
        setContentView(R.layout.activity_main)
        // add listeners
        //example:
        /*
        * rotateButton.setOnClickListener {
            rotate()
        }*/
    }

    fun goToDescr(v: View?) {
        // On clicklistener for 1-st card
        card1 = findViewById(R.id.card1)
        //val animator = ObjectAnimator.ofFloat(v, View.ROTATION, -360f, 0f)
       val animator: Animator = AnimatorInflater.loadAnimator(this, R.animator.animations)
                .apply {
                    setTarget(card1)
                    start()
                }

        //val card_animation: Animation = AnimationUtils.loadAnimation(this, R.animator.animations)


        //animator.duration = 10000
       animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                //rotateButton.isEnabled = false
            }
            override fun onAnimationEnd(animation: Animator?) {
                //rotateButton.isEnabled = true
                GotoCardView()
            }
        })
        animator.start()
        //card1.startAnimation(card_animation)
        //while(animator.isRunning){}
        //overridePendingTransition(R.anim.hold, R.anim.fade_in);

    }
    fun GotoCardView(){
        // this is needed to go to other activity? it is not seen within onAnimationEnd()
        val intent = Intent(this, SubsidiaryActivity::class.java)
        startActivity(intent)
    }
   /* fun startAnimation(){
        val set:AnimatorSet;
        set = (AnimatorSet)(AnimatorInflater.loadAnimator(
                this, R.animator.animations))//works only in java. How to write it in kotlin?
    }*/


}
/*
* W/PropertyValuesHolder: Method setLayout_marginRight() with type float not found on target class class androidx.cardview.widget.CardView
W/PropertyValuesHolder: Method getLayout_marginRight() with type null not found on target class class androidx.cardview.widget.CardView
W/PropertyValuesHolder: Method setBackground() with type float not found on target class class androidx.cardview.widget.CardView
* */
