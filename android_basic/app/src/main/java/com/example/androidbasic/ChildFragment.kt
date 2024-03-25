package com.example.androidbasic

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit

//프레그먼트 상속을 받고 childfragment 영역에 그릴 뷰를 나타내는
//레이아웃 파일도 추가를 해야한다. 레이아웃 아이디 전달
//child프레그먼트 입장에서는 home fragment가 parent이다.
class ChildFragment : Fragment(R.layout.fragment_child) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_next_screen)
        //클릭될때 다음 fragment로 이동
        //child입장에서는 이전에 호스트 프레그먼트가 parent라고 볼 수 있다.
        //child 프레그먼트를 또 다른 호스트 프레그먼트로 만들 생각이 아니라면
        //parent framgent manager를 선택해야한다.

        button.setOnClickListener {
            parentFragmentManager.commit {
                //add(R.id.container_home, NextFragment())
                add<NextFragment>(R.id.container_home)
            }
        }
    }

}