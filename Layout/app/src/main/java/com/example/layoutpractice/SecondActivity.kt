package com.example.layoutpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun backButtonClicked(view: View) {
        Toast.makeText(this, "Back Button Clicked!", Toast.LENGTH_SHORT).show()
        finish()
    }
}