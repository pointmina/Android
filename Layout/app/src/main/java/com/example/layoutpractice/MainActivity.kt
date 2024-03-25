package com.example.layoutpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.content.Intent
//메인 화면
class MainActivity : AppCompatActivity() {

    //뷰가 생성되었을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //그릴 xml 뷰 파일을 연결 시켜준다. 즉 설정한다.
        setContentView(R.layout.activity_main)


        // 'info' 버튼을 불러온다
        val infoButton = findViewById<Button>(R.id.info)

        // 'info' 버튼에 클릭 이벤트 리스너를 설정한다
        infoButton.setOnClickListener {
            // 클릭되었을 때 실행할 동작을 정의한다
            Toast.makeText(this, "Information Button Clicked!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)

            startActivity(intent)
        }



    }


}