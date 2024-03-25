package com.example.androidbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

//앱컴펫엑티비티를 상속받아야함
//매니페스트에도 등록해줘야한다.

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //this로 fragmentTransaction이 전달되고 있기 때문에 트랜잭션이
        //지원해주는 add나 remove, replace를 사용할 수 있다.
        //확장함수 add를 사용하게 되면 직접적으로 객체를 생성하는 코드를 쓰지 않아도됨
        supportFragmentManager.commit {
            //add(R.id.container, HomeFragment())
            add<HomeFragment>(R.id.container)
        }

        //프레그먼트 연산 요청 -> 프레그먼트의 추가 수정 삭제를 담당한다.
        //val transaction = supportFragmentManager.beginTransaction()
        //transaction.add(R.id.container, HomeFragment())
        //transaction.commit()
    }
}