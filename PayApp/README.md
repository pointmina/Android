PayApp
-

Home화면 구현
-

<br>
    
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
- navhost..?
- 
      
<br>

b) 버튼을 선택할 때 나머지 영역의 화면 전환
- https://developer.android.com/guide/fragments?hl=ko
- small screen에서 보면 바텀 네비게이션을 액티비티로 나머지를 프레그먼트로 활용하고 있음
- ![image](https://github.com/pointmina/Android/assets/68779817/566d566a-21bc-42ed-9ddc-0330824f2335)
- 그럼 상단 appbar 프레그먼트에 널것이냐 액티비티에 널것이냣?
- 네비게이션 라이브러리 : https://developer.android.com/guide/navigation?hl=ko#kts
- ㄴ> 화면 이동 설계, 화면 전환 설계하기, fragmentManager -> 커밋젭알;
- 네비게이션바 + 네비게이션 라이브러리 결합! => https://developer.android.com/guide/navigation/integrations/ui
- 뷰바인딩 => https://developer.android.com/topic/libraries/view-binding?hl=ko
- 프레그먼트 바인딩은 쨰끔 다름
```
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    //호출될 때마다 현재에 저장되어 있는 값이 반환된다.
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    //뷰에 다시 접근할 수 없도록 알려줌
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
  ```


<br>

c) 상단에 payapp이라는 텍스트가 나타남
- app bar(툴바/액션바) 활용 => https://developer.android.com/guide/fragments/appbar?hl=ko
- 참고자료 => https://m3.material.io/components/top-app-bar/overview


d) 결제수단 화면
- 곡선 모양 corner radius : root shape
- alt를 누르면 피그마에서 자세한 수치를 볼 수 있음
- 결제 수단 아무곳을 누르면 결제 수단 등록을 할 수 있는 화면 구
-  네이게이션 라이브러리에서 데스티네이션 간의 이동을 정의하는 방법 : Safe Args : https://developer.android.com/guide/navigation/use-graph/safe-args?hl=ko
-  ㄴ> estination을 연결하게 되면 네비게이션 그래프에서 actio이라는 태그를 사용해가지고 화면 이동과 관련된 정보를 선언하고 있었는데 이 기능을 클래스가 제공해주는 기능으로 변환됨

송금 계좌 목록
-

a) 반복적으로 나타나는 레이아웃
- 화면 가득 채우기
- 하면을 벗어나는 영역까지 데이터가 그려져야함
- 스크롤 가능해야(item.xml에서 layout의 height를 wrap_content로 해보쟝!)
- 리사이클러
- 모서리 둥글게 => shapeableImageView(shapeAppearance)
- 리사이클러뷰에 나타날 데이터 관리하는 클래스 -> 어뎁터
- 어뎁터 = 리사이클 뷰에 나타날 데이터를 관리하는 클래스 역할 
- 


c)
