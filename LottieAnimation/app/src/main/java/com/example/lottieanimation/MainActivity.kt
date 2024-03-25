package com.example.lottieanimation

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.lottieanimation.R
import com.example.lottieanimation.R.id.animation_view



class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var liked = false
        val animationView: LottieAnimationView = findViewById(animation_view)

        animationView.setOnClickListener {

            if (liked == false) {
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(1000)
                animator.addUpdateListener {
                    val progress = it.animatedValue as Float
                    animationView.progress = progress
                }
                animator.start()
                liked = true
            } else {
                val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(500)
                animator.addUpdateListener {
                    val progress = it.animatedValue as Float
                    animationView.progress = progress
                }
                animator.start()
                liked = false
            }
        }
    }
}

