package com.example.androidbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_confirm)
        button.setOnClickListener{
            //버튼을 누르면 second로 이동 this는 mainActivity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("mina", "온스타트")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mina", "온리쥼")
    }

    override fun onPause() {
        super.onPause()
        Log.d("mina", "온포즈")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mina", "온스탑")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mina", "온디스트로이")
    }

}
