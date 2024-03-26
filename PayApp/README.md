PayApp
-

1. Home화면 구현
   
a) 하단에 홈과 송금 메뉴버튼 존재
- 송금내역 목록이 생기면 목록을 추가하는 UI구
- 누구에게 보낼지 나타나고 -> 그중 하나를 선택하면 또 다른 화면으로 전환(얼마를 보낼깡)
- navigation-bar 활 : https://m3.material.io/components/navigation-bar/overview
- https://github.com/material-components/material-components-android/blob/master/docs/components/BottomNavigation.md (->menu를 사용해서 항목을 추가한다.)
- 그람 버튼 누를때 파랗게 불들어오는건 우째한댜? -> 새로운 drawable(selector)구현
  (android:state_selected="true" 설정) 메뉴가 선택 안됐을때도 보여줘야한다.
- 모양이 동일하고 색상만 변경하면 되면 걍 itemIconTint 사용하면 된다.
- 기존 테마 때매 내가 설정한 스타일이 안먹음 =>
- 액티비티에 프레그먼트 컨테이너뷰(FragmentContainterView)를 만들고 name으로 class(kt)를 이어줘야한다.
- 상단에 한토페이가 계속 보여지는데 이거는 KT파일에 appbar가 들어있는 fragment파일 아이디를 전달해서 보여준다.
      

b) 버튼을 선택할 때 나머지 영역의 화면 전환
- https://developer.android.com/guide/fragments?hl=ko
- small screen에서 보면 바텀 네비게이션을 액티비티로 나머지를 프레그먼트로 활용하고 있음
![image](https://github.com/pointmina/Android/assets/68779817/566d566a-21bc-42ed-9ddc-0330824f2335)
- 그럼 상단 appbar 프레그먼트에 널것이냐 액티비티에 널것이냣?


        
c) 상단에 payapp이라는 텍스트가 나타남
- app bar(툴바/액션바) 활용 => https://developer.android.com/guide/fragments/appbar?hl=ko
- 참고자료 => https://m3.material.io/components/top-app-bar/overview
