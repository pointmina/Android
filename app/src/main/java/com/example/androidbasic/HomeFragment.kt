package com.example.androidbasic

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit

//fragment 생성하는 방법으로 프레그먼트 생성자의 레이아웃 아이디를 전달
//R.layout.fragment_home
class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"HomeFragment - onCreate() called")
    }


    // 뷰를 생성할 수 있는 함수 반환 타입은 view이다. 함수가 호출되었을 때
    // 뷰를 생성하는 코드를 작성하고 반환해야한다.
    override fun onCreateView(
        //레이아웃에 선언했던 뷰들을 객체로 만들어서 실제로 화면에 나타나는 과정을
        //레이아웃 인플레이트라고 부름
        //프레그먼터는 단독 x 항상 호스트 액티비티가 있어야한다. 액티비티에 추가되는 ui이다.
        //그래서 우리가 프레그 먼트에 뷰들을 생성할 때 이 페어런트 뷰에 컨테이너가 필요해진다.
        //attachToRoot : 계층구조들을 이루는 뷰들 중에서도 맨 위에 있는거 ㅇㅇ
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"HomeFragment - onCreateView() called")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    //프레그먼트 뷰가 생성된 뒤 호출되는 함수
    //컨테이너 뷰에 fragment를 추가하려고 함
    //컨테이너 위에 추가할 프레그먼트를 만들어야함
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"HomeFragment - onViewCreated() called")

        //홈프레그먼트를 호스트 프레그먼트로서 활용하려고 프레그먼트 컨테이너 뷰를 추가한 상태
        // 현재 프레그먼트 컨테이너 뷰는 호스트 액티비티에 하나 있고 호스트 프레그먼트에서도 하나 있는 상태
        //호스트 프레그먼트에 하위 프레그먼트를 추가하기 위한 작업을 하는 것이기 때문에
        //패런트가 아닌 차일드 프레그먼트 매니저에게 프레그먼트 추가 요청을 하는 것


        //프레그먼트 추가 요청을 하는 것이니 add함수 호출
        //컨테이너뷰 아이디를 전달해야한다.
        //추가할 fragment객체 전달 -> childFragment

        childFragmentManager.commit {
            //add(R.id.container_home, ChildFragment())
            add<ChildFragment>(R.id.container_home)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"HomeFragment - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"HomeFragment - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"HomeFragment - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"HomeFragment - onStop() called")
    }

    //뷰가 죽는거랑 프레그먼트가 죽는거랑 따로
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"HomeFragment - onDestroyView() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"HomeFragment - onDestroy() called")
    }


}