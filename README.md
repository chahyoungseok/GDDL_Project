# FinalReport
<p align="center">
<img width="700px" src="https://user-images.githubusercontent.com/79950095/120919672-c50a3600-c6f5-11eb-9ed7-95359f927284.png">
<br>
<img src="https://img.shields.io/badge/license-mit-green">
<img src="https://img.shields.io/github/issues/hongjin4790/SYE-project">
<img src="https://img.shields.io/badge/tag-v1.0.0-blue">
<br>
<img src="https://img.shields.io/badge/Android Studio-3DDC84?style=flat-square&logo=Android&logoColor=white"/>
<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>
<br>
<img src="https://img.shields.io/badge/Eclipse-2C2255?style=flat-square&logo=Eclipse&logoColor=white"/>
<img src="https://img.shields.io/badge/Tomcat9.0-F8DC75?style=flat-square&logo=Apache-Tomcat&logoColor=black"/>
<br>
<br><br><br><br><br>
 </p>

# Project Name = 갖다드림(bring you)
# Team Member : 김준혁, 김형진, 마건우, 옥석우, 차형석
# Youtube Link(어플 소개 및 구동영상) : https://youtu.be/jB9QAhMm0tQ

___
## 목차

 1. 주제 선정 이유
 2. "갖다드림" 앱 소개
 3. 유사 앱 분석 및 차이점
 4. 파일 다운로드 유의점
 5. 앱 제작 툴 소개
 6. 앱 실행 환경 구축
 7. 각 클래스 기능별 설명
 8. 개발 
 9. 각 클래스 별 코드 
 10. "갖다드림" 어플리케이션 한계점
 11. 결론

___

## 1. 주제 선정 이유

- 교내에서 누군가 대신 해주었으면 하는 심부름이 필요한 상황을 종종 겪게됨
- 기숙사 편의점 폐쇄
- 상명대학교 학생만을 위한 심부름 어플리케이션이 존재하지 않음
- 상명대학교 학생들끼리 서로 도움을 줄수 있겠다는 기대

___

## 2. "갖다드림" 앱 소개

 -  상명대학교 학생들을 위한 심부름 서비스 Appliction이다.
 -  캠퍼스 내 시설 또는 캠퍼스 근방 학생들에게 심부름 서비스를 제공한다.
 -  심부름 시키는 사람은 수행하는 사람에게 일정한 대가 지급하며 어플이 순환한다.
 -  기숙사생이나 자취생들이 많이 사용할 것으로 예상된다.

___

## 3. 유사 앱 분석 및 차이점

![김집사](https://user-images.githubusercontent.com/79950095/120915782-abaabf00-c6e0-11eb-9247-d39d6b39a116.JPG)


##### 어플소개

사용자가 앱에서 심부름을 시키면 회사 소속 직원이 고객에게 서비스를 제공.

##### "갖다드림"과의 차이점

||김집사|갖다드림|
|------|---|---|
|서비스 제공|회사 직원|사용자|
|서비스 범위|전국|상명대학교|

출처 : https://play.google.com/store/apps/details?id=com.mybutler.android
___

## 4. 파일 다운로드 유의점

아래 폴더에서 
    GDDL_MoblieServer, Admin_Notify.zip, GDDL DB File.sql을 따로 빼서 따로따로 사용<br>
    ![folder](https://user-images.githubusercontent.com/29851990/121128207-fefa4a00-c865-11eb-8f72-8ab9de4a1f43.PNG)


___

## 5. 앱 제작 툴 소개

 -  안드로이드 스튜디오 (android studio 4.2.1) https://developer.android.com/studio?gclid=EAIaIQobChMI9InWvMeC8QIVx1VgCh3c0gDYEAAYASAAEgI3PPD_BwE&gclsrc=aw.ds
 -  데이터베이스 (MySQL Workbench 8.0.25) https://dev.mysql.com/downloads/mysql/
 -  서버 (Eclipse IDE 2021-03 , Tomcat 9.0) https://www.eclipse.org/downloads/ https://tomcat.apache.org/download-90.cgi

___

## 6. 앱 실행 환경 구축

1. JSP 개발환경 구축

       (1) Eclipse Java EE 다운로드 https://www.eclipse.org/downloads/packages/ 에서 Eclipse IDE for Enterprise Java and Web Developers 설치
       (2) Eclipse -> New -> Open File -> GDDL_MobileServer
       (3) Tomcat 다운로드 https://shinysblog.tistory.com/5
       (4) GDDL_MobileServer 우클릭 -> Properties -> Java Build Path -> Libaries -> gson과 mysql-connect가 없을때만 Add JARs.. -> GDDL_MobileServer -> WebContent -> WEB-INF -> gson, mysql-connect 둘다 Add && Apply
       (5) GDDL_MobileServer 우클릭 -> Properties -> WebProjectSetting -> Context root : / 입력 -> Apply
       (6) GDDL_MobileServer 우클릭 -> Properties -> Server -> Tomcat9.0 -> Apply
       (7) Eclipse -> Project -> Properties -> Targeted Runtime -> New -> Tomcat9.0 -> Finish -> Apply

2. Mysql 설치환경 구축 

       https://m.blog.naver.com/bjh7007/221829548634 참고
3. Android Studio 실행

       File -> Open -> GajDaDeuLim
       FinalURLIP.java  파일에서 public final static String adress = "My IP";
       AVD의 경우 My IP부분에 10.0.2.2:8080 입력
       개인Device의 경우 My IP부분에 자신의 IP입력
       자신 IP 확인방법 : (win + r) -> cmd -> ipconfig -> Ipv4주소

4. MySQL Workbench 실행

       스키마 생성 (Schema name = gddl)
       "갖다드림" SQL file Query 실행

5. Eclipse 실행

```java
public class FinalDB {
   public final static String dbID = "My DB ID"; //본인의 데이터베이스 아이디입력
   public final static String dbPassword = "My DB Pass"; // 본인의 데이터베이스 패스워드입력
   public final static String dbProject = "gddl"; // "gddl" 입력
}
```
       
       GDDL_MobileServer -> src -> FinalDB.java
       
       My DB ID 부분에 자신의 MySQL ID 입력

       My DB Pass 부분에 자신의 MySQL Password 입력 후
       
       GDDL_MobileServer 패키지 우클릭 -> Run As -> Run on Server
5. 구글맵 API 활성화

      https://console.cloud.google.com/apis/credentials?project=handy-amplifier-311401
       
       위 링크로 들어가 자신의 API Key 를 추가 pakage name = com.example.gajdadeulim

6. 앱 실행
       
       Android Studio 에서 Run
 

7. 문의
       
       질문 사항이 있거나 원활히 진행되지 않는다면 Ecampus 해당분반 "차형석" 학생에게 메시지 보내주시면 감사하겠습니다.
___

## 7. 각 클래스 기능별 설명

|클래스|기능|layout|
|------|---|---|
|AddressActivity.java|구글맵 api를 사용한 위치확인|activity_adress.xml|
|Board_Module.java|게시글관련 데이터들의 클래스화|x|
|Chat_Module.java|채팅관련 데이터들의 클래스화|x|
|Chatting_Fragment.java|채팅방 보기|chatting_fragment.xml|
|ChattingAdapter.java|Chatting_Fragment RecyclerView에 들어갈 어댑터|x|
|ChattingContentData.java|ChattingAdapter 들어갈 컴포넌트 클래스화|x|
|ChattingRecordMoudule.java|채팅기록관련 데이터들의 클래스화|x|
|CustomCareActivity.java|고객센터 Activity|activity_custom_care.xml|
|FinalURLIP.java|서버 ,port주소설정|x|
|GMailSender.java|학번 인증번호 전송관련 라이브러리|x|
|GpsTracker.java|GPS관련 라이브러리|x|
|GuideActivity.java|전체 가이드라인 설정|activity_guide.xml|
|Guide_First.java|가이드라인1|guide_line_first.xml|
|Guide_second.java|가이드라인2|guide_line_second.xml|
|Guide_third.java|가이드라인3|guide_line_third.xml|
|Guide_Fourth.java|가이드라인4|guide_line_fourth.xml|
|Guide_Five.java|가이드라인5|guide_line_five.xml|
|InsetBoardActivity.java|게시판에 글쓰기 화면|activity_insert_board.xml|
|LoginActivity.java|로그인 화면|activity_login.xml|
|MainActivity.java|메인 화면|activity_main.xml|
|MainAdapter.java|MainActivity RecyclerView에 들어갈 어댑터|x|
|MainBoard_Fragment.java|게시판목록보기화면|mainboard_fragment.xml|
|MainData.java|MainAdapter에 들어갈 컴포넌트 클래스화|x|
|MembershipActivity.java|회원가입 화면|activity_membership.xml|
|MenuList_Fragment.java|주문목록 화면|menulist_fragment.xml|
|MyInfo_Fragment.java|내정보 화면|myinfo_fragment.xml|
|MyService.java|양방향 통신을 하기위한 안드로이드 Service|x|
|NoticeAdapter.java|NotifyActivity RecyclerView에 들어갈 어댑터|x|
|NoticeData.java|NoticeAdapter에 들어갈 컴포넌트 클래스화|x|
|Notify_Module.java|공지관련 데이터들의 클래스화|x|
|NotifyActivity.java|공지사항 화면|activity_notify.xml|
|RequestHttpURLConnection.java|단방향통신을 하기위한 라이브러리|x|
|SignatureUtil.java|해시코드로 변환하기위한 라이브러리|x|
|Splash.java|앱 실행시 Splash Animation|splash.xml|
|User_Module.java|유저관련 데이터들의 클래스화|x|

Server
|클래스|기능|
|------|---|
|Board_Module.java|게시물 관련 데이터 클래스화|
|Custom_Module.java|고객센터 문의 관련 데이터 클래스화|
|Chat_Module.java|채팅 메세지 데이터 클래스화|
|Server_Module.java|소켓 프로그래밍(채팅) 데이터 클래스화|
|Notify_Module.java|공지사항 게시물 관련 데이터 클래스화|
|BoardDAO.java|게시물 데이터베이스에 접근 클래스
|ChatDAO.java|채팅 기록 데이터베이스 접근 클래스|
|ChatListDAO.java|채팅 목록 데이터베이스 접근 클래스|
|CustomCareDAO.java|고객센터 문의글 데이터베이스 접근 클래스|
|NotifyDAO.java|공지사항 데이터베이스 접근 클래스|
|userDAO|로그인, 회원가입 등 유저 정보 데이터베이스 접근 클래스|

Servlet
|Servlet|Request|Response|DBUpdate|
|------|---|---|---|
|CallChattingRoomDateServelt.java|서비스 제공자/이용자 ID |채팅 기록|x|
|ChangePWServlet.java|유저ID, 변경할PW|x|새로운PW DB저장||
|CustomReportServlet.java|고객센터 신고 데이터|x|신고글 DB저장|
|EditProgressServlet.java|주문ID,접수ID|x|주문의 진행상태 변경|
|InsertChattingRoomServlet.java|주문ID,접수ID|x|채팅목록DB 유저 추가|
|IsThereIDServlet.java|입력ID|ID중복여부|x|
|LoadOnBoardServlet.java|요청 parameter|모든 주문게시글 데이터|x|
|LoadOwnOrdersServlet.java|유저ID|유저의 주문목록 데이터|x|
|LoginConfirmServlet.java|유저ID, 유저PW|ID,PW 일치여부|x|
|NotifyReceiverServlet.java|공지사항 데이터|x|공지사항 DB저장|
|NotifySenderServlet.java|요청 parameter|공지사항 데이터|x|
|OrderCancelServlet.java|주문고유번호|x|지정된 주문목록DB에서 삭제|
|OrderCompltedServlet.java|주문고유번호|x|주문상태완료로 변경|
|OrdererErranderIDServlet.java|유저ID|채팅상대ID|x|
|PostOnBoardServlet.java|주문게시글 데이터|x|주문목록DB에 주문추가|
|RegisterUserServlet.java|회원가입양식 데이터|x|유저DB에 회원정보추가|
|ShowUserInfoServlet.java|유저ID|유저의 회원정보|x|
|SignatureUtilServlet.java|입력 PW|x|회원정보 입력 전 비밀번호 암호화|
___

## 8. 개발 과정

     Week5.
           김준혁, 옥석우 - 구글맵활용 GPS로 현위치 찾기
           김형진 - 회원가입 및 로그인 서버환경 구축
           마건우 - 초기 데이터베이스 스키마 설계
           차형석 - 회원가입 및 로그인 액티비티 구현
           
     Week6.
           김준혁 - 메인 화면 구축(로그아웃, 회원정보 변경)
           김형진 - 게시글 관련 서블릿
           마건우 - 게시글 등록
           옥석우 - 게시글 새로고침 기능
           차형석 - 게시글 관련된 main adapter 구현
           
     Week7.
           김준혁 - 게시글 펼쳐보기/수락 기능구현
           김형진 - 주문 수락 및 취소,불러오기 서블릿
           마건우 - 주문목록 구현
           옥석우 - 주문 취소 구현
           차형석 - 프래그먼트 구현
           
     Week8.
           김준혁 - 고객센터 신고접수 기능 구현 
           김형진 - 고객센터 신고접수, 공지사항 불러오기/등록하기
           옥석우 - 가이드라인 기능 구현 
           마건우 - 게시글 세부 분류 
           차형석 - 공지사항 추가 및 게시
           
     Week9.
           김준혁 - 스플래쉬스크린 
           김형진 - 채팅관련 서블릿
           마건우 - 주문목록 변경, 메인게시판 정리
           옥석우,차형석 - 채팅 액티비티, 채팅프래그먼트(채팅목록)
           
     Week10.
           김준혁 - 채팅방 레이아웃
           김형진,옥석우 - 비동기 서버 구현을 위한 학습 및 제작진행
           마건우 - 채팅기능에서 필요한 데이터 검토, 채팅 액티비티
           차형석 - 안드로이드 서비스 구현
          
     Week11.
           김준혁, 마건우, 옥석우  - 디자인
           김형진 - Servlet과는 독립적으로 동작하는 서버소켓 및 쓰레드 비동기 구현 중
           차형석 - 서비스 안에 쓰레드 구현
          
     Week12.
           김준혁 - 고객센터 디자인
           김형진 - 비동기 채팅서버 구현 및 비동기 서버와 기존 단방향 통신 서버 병합 작업
           마건우 - 채팅방 어댑터 구현
           옥석우 - 공지사항 툴바 및 내용 디자인
           차형석 - 글쓰기 디자인 및 안드로이드 서비스내 소켓통신 관련 동작 재정의
          
     Week13. 
         김형진
        - LoginActivity 회원가입 버튼 및 margin 관련 디자인 보완
        - MainActivity 의 글쓰기 Button 디자인 / Fragment 관련 UI 수정, fragment button을 삭제하고 bottomNavigationView를 추가

        김준혁
        - LoginActivty 로고 사이즈 조절 및 UI수정
        - MembershipActivty UI 수정 및 성별 선택란 EditText -> RadioButton으로 수정
        - myinfo_fragment UI 수정

        마건우
        -Chattingactivity의 content크기 조절및 위치조정/말풍선크기 조절, 지도와 연결된 네비게이션 버튼 구현
        -말풍선을 wrapcontent로 설정후 min 값을 설정하여 텍스트가 작은상황에서 말풍선의 최소크기값을 설정
        -Adapter에서 말풍선이 send인지 receive인지 구분하기위해 조건에따라 출력되는 채팅 아이템의 layout을 다르게 설정
        -Chattingactivity에서 네비게이션 버튼을 이용하여 구글맵과 연관된 Addressactivity로의 이동을 인텐트으로 구현

        옥석우
        - activity_notice.xml의 전체적인 디자인 수정 (notice 로고를 넣고, 시간 .으로 세분화 및 우측 정렬과 공지사항에 각 number부여 
         공지사항의 제목은 center정렬)
        - activity_custom_care.xml의 전체적인 디자인 수정 (체크 박스를 전체적으로 가운데로 모으고, textcolor는 black으로 통일,
         신고 제목과 신고하려는 상대 아이디를 입력할 수 있도록 수정)

        차형석 
        - 안드로이드, 서버단에 강제 종료시 상황 구현
        - global server를 위해 도메인과 서버연동중
        - ChattingFragment를 없애고 ChattingActivity로 변경
        - 실시간 채팅과 채팅방 대화기록유지, 채팅상대가 없을때 상황등 각각의 채팅상황에 대한 UI, UX 구현

___

## 9. 각 클래스별 코드설명
 - LoginActivity(로그인)
 
 ```java
 public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText IDEditText;
    EditText PWEditText;
    Button LoginConfirmBtn;
    Button MoveMembershipBtn;

    public Toolbar LoginToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginToolbar = findViewById(R.id.LoginToolbar);
        LoginToolbar.setTitle("");
        setSupportActionBar(LoginToolbar);

        IDEditText = findViewById(R.id.IDEditText);
        PWEditText = findViewById(R.id.PWEditText);
        LoginConfirmBtn = findViewById(R.id.LoginConfirmBtn);
        MoveMembershipBtn = findViewById(R.id.MoveMembershipBtn);

        LoginConfirmBtn.setOnClickListener(this);
        MoveMembershipBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LoginConfirmBtn :{
                //서버에 보낼거
                ContentValues values = new ContentValues();
                values.put("userID", IDEditText.getText().toString());
                values.put("userPassword", SignatureUtil.applySHA256(PWEditText.getText().toString()));

                String response = "";
                NetworkTask networkTask = new NetworkTask(resulturl("LoginConfirmServlet"), values);
                try {
                    response = networkTask.execute().get();
                    Log.d("",response);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(response.equals("1")){
                    onStartService();
                    Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                    intent.putExtra("userID",IDEditText.getText().toString());
                    startActivity(intent);
                }
                else{
                    //로그인 실패!
                    Log.d("","login failed");
                }

                break;
            }
            case R.id.MoveMembershipBtn : {
                Intent intent = new Intent(LoginActivity.this,MembershipActivity.class);
                startActivity(intent);
                break;
            }
            default: {
                break;
            }
        }
    }

    public void onStartService(){
        Intent intent = new Intent(this, MyService.class);
        intent.setAction("Access"+IDEditText.getText().toString());
        startService(intent);
    }

    // Service 종료시킬 때, 사용하면 됨
    public void onStopService(){
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    public String resulturl(String url) { //ip 값 바꿔주는 부분
        String resultUrl = "http://"+FinalURLIP.address+"/" + url;
        return resultUrl;
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}
 ```
- MembershipActivity(회원가입)

 ```java
public class MembershipActivity extends AppCompatActivity implements View.OnClickListener {

    private Boolean IDOverlapStatus = false;
    private Boolean StudentIDAuthenticateStatus = false;
    private String localIDStorage = "";
    private String userEmail = "";

    public Toolbar memberToolbar;

    EditText NameMemberText;
    EditText IDMemberText;
    EditText PWMemberText;
    EditText PWConfirmMemberText;
    EditText StudentIDMemberText;
    EditText MajorMemberText;
    EditText EmailAuthenticateEditText;

    User_Module userModule;
    Button MoveLoginBtn;
    Button FinishMemberShipBtn;
    Button OverlapConfirmBtn;
    Button StudentIDAuthenticateBtn;
    Button StudentIDConfirmBtn;
    RadioButton GenderMan,GenderWomen;
    RadioGroup GenderSelect;
    String GenderText = "";



    //이메일 인증관련 변수
    long seed = System.currentTimeMillis();
    Random random = new Random(seed);
    int randomNum = 0;

    String Email = "xodus374@gmail.com";
    String password = "gyhmpooddhfhbvpz";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        memberToolbar = findViewById(R.id.MemberToolbar);
        memberToolbar.setTitle(R.string.defaultToolbar);
        setSupportActionBar(memberToolbar);

        NameMemberText = findViewById(R.id.NameMemberText);
        IDMemberText = findViewById(R.id.IDMemberText);
        PWMemberText = findViewById(R.id.PWMemberText);
        PWConfirmMemberText = findViewById(R.id.PWConfirmMemberText);
        StudentIDMemberText = findViewById(R.id.StudentIDMemberText);
        GenderMan = findViewById(R.id.GenderMan);
        GenderWomen = findViewById(R.id.GenderWomen);
        GenderSelect = findViewById(R.id.GenderSelect);
        MajorMemberText = findViewById(R.id.MajorMemberText);
        EmailAuthenticateEditText = findViewById(R.id.EmailAuthenticateEditText);

        MoveLoginBtn = findViewById(R.id.MoveLoginBtn);
        FinishMemberShipBtn = findViewById(R.id.FinishMemberShipBtn);
        OverlapConfirmBtn = findViewById(R.id.OverlapConfirmBtn);
        StudentIDAuthenticateBtn = findViewById(R.id.StudentIDAuthenticateBtn);
        StudentIDConfirmBtn = findViewById(R.id.StudentIDConfirmBtn);

        MoveLoginBtn.setOnClickListener(this);
        FinishMemberShipBtn.setOnClickListener(this);
        OverlapConfirmBtn.setOnClickListener(this);
        StudentIDAuthenticateBtn.setOnClickListener(this);
        StudentIDConfirmBtn.setOnClickListener(this);
        GenderSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int gender) {
                if(gender == R.id.GenderMan){
                    GenderText = "male";
                } else if (gender == R.id.GenderWomen){
                    GenderText = "female";
                }
            }
        });

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork().build());
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        MajorMemberText.setText("");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent,View view, int position, long id){
                MajorMemberText.setText(""+parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.OverlapConfirmBtn : {

                ContentValues values = new ContentValues();
                values.put("inputID", IDMemberText.getText().toString());

                String response = "";
                NetworkTask networkTask = new NetworkTask(resulturl("IsThereIDServlet"), values);
                try {
                    response = networkTask.execute().get();
                    Log.d("",response);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(response.equals("1")){
                    Toast.makeText(getApplicationContext(),"이미있는 아이디 입니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    IDOverlapStatus = true;
                    Toast.makeText(getApplicationContext(),"중복확인이 되었습니다.",Toast.LENGTH_SHORT).show();
                    localIDStorage = IDMemberText.getText().toString();
                }

                break;
            }
            case R.id.StudentIDAuthenticateBtn : {
                ContentValues values = new ContentValues();
                values.put("InputStudentNumber", StudentIDMemberText.getText().toString());

                String response = "";
                NetworkTask networkTask = new NetworkTask(resulturl("IsThereStudentNumberServlet"), values);
                try {
                    response = networkTask.execute().get();
                    Log.d("",response);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(response.equals("1")){
                    Log.d("", "중복됨");
                    Toast.makeText(getApplicationContext(),"이미 등록된 회원의 학번입니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.d("", "중복안됨");
                    Toast.makeText(getApplicationContext(),StudentIDMemberText.getText().toString() + "@sangmyung.kr 로 인증번호를 발송합니다.",Toast.LENGTH_SHORT).show();
                    randomNum = random.nextInt(10000000);
                    userEmail = StudentIDMemberText.getText().toString() + "@sangmyung.kr";

                    Log.d("",randomNum+"");
                    try {
                        GMailSender gMailSender = new GMailSender(Email, password);
                        gMailSender.sendMail("갖다드림 학번인증키입니다.",String.valueOf(randomNum) , userEmail);//SignatureUtil.applySHA256(String.valueOf(randomNum))
                        Toast.makeText(getApplicationContext(), "해당 이메일로 보낸 인증코드를 아래에 입력해주세요.", Toast.LENGTH_SHORT).show();
                    } catch (SendFailedException e) {
                        Toast.makeText(getApplicationContext(), "이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                    } catch (MessagingException e) {
                        Toast.makeText(getApplicationContext(), "인터넷 연결을 확인해주십시오", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            case R.id.StudentIDConfirmBtn : {
                if(String.valueOf(randomNum).equals(EmailAuthenticateEditText.getText().toString())){
                    Toast.makeText(getApplicationContext(),"인증코드가 맞습니다.",Toast.LENGTH_SHORT).show();
                    StudentIDAuthenticateStatus = true;
                    StudentIDMemberText.setInputType(InputType.TYPE_NULL);
                    EmailAuthenticateEditText.setInputType(InputType.TYPE_NULL);
                    StudentIDAuthenticateBtn.setClickable(false);
                    StudentIDConfirmBtn.setClickable(false);
                }
                else{
                    Toast.makeText(getApplicationContext(),"인증코드가 맞지않습니다.",Toast.LENGTH_SHORT).show();;
                    StudentIDMemberText.setText("");
                    EmailAuthenticateEditText.setText("");
                }
                break;
            }
            case R.id.MoveLoginBtn : {
                Intent intent = new Intent(MembershipActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.FinishMemberShipBtn : {
                if(!PWMemberText.getText().toString().equals(PWConfirmMemberText.getText().toString()) || PWMemberText.getText().equals("")) {
                    PWMemberText.setText("");
                    PWConfirmMemberText.setText("");
                    Toast.makeText(getApplicationContext(),"비밀번호가 없거나 같지않습니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(NameMemberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"이름을 입력해주세요.",Toast.LENGTH_SHORT).show();;
                        NameMemberText.requestFocus();
                    }
                    else if(IDMemberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"아이디를 입력해주세요.",Toast.LENGTH_SHORT).show();;
                        IDMemberText.requestFocus();
                    }
                    else if(!IDOverlapStatus){
                        Toast.makeText(getApplicationContext(),"아이디 중복확인을 해주세요.",Toast.LENGTH_SHORT).show();
                    }
                    else if(!localIDStorage.equals(IDMemberText.getText().toString())){
                        Toast.makeText(getApplicationContext(),"중복확인한 아이디로 입력해주세요.",Toast.LENGTH_SHORT).show();
                        IDMemberText.setText("");
                        IDMemberText.requestFocus();
                    }
                    else if(PWMemberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show();;
                        PWMemberText.requestFocus();
                    }
                    else if(PWConfirmMemberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"비밀번호확인을 입력해주세요.",Toast.LENGTH_SHORT).show();;
                        PWConfirmMemberText.requestFocus();
                    }
                    else if(!StudentIDAuthenticateStatus){
                        Toast.makeText(getApplicationContext(),"학교인증을 받아주세요",Toast.LENGTH_SHORT).show();;
                    }
                    else if(GenderText.equals("")){
                        Toast.makeText(getApplicationContext(),"성별을 선택해주세요.",Toast.LENGTH_SHORT).show();;
                    }
                    else if(MajorMemberText.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"학과를 입력해주세요.",Toast.LENGTH_SHORT).show();;
                        MajorMemberText.requestFocus();
                    }
                    else{
                        ContentValues values = new ContentValues();
                        values.put("Regi_id", IDMemberText.getText().toString());
                        values.put("Regi_pass",  SignatureUtil.applySHA256(PWMemberText.getText().toString()));
                        values.put("Regi_name", NameMemberText.getText().toString());
                        values.put("Regi_major", MajorMemberText.getText().toString());
                        values.put("Regi_school_number", StudentIDMemberText.getText().toString());
                        values.put("Regi_gender", GenderText);

                        NetworkTask networkTask = new NetworkTask(resulturl("RegisterUserServlet"), values);
                        networkTask.execute();

                        Intent intent = new Intent(MembershipActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
            }
//            case R.id.FindMajorBtn: {
//
//            }

            default: {
                break;
            }
        }
    }
    public String resulturl(String url) { //ip 값 바꿔주는 부분
        String resultUrl = "http://"+FinalURLIP.address+"/" + url;
        return resultUrl;
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}
 ```
- MainBoard_Fragment(메인)

 ```java
public class MainBoard_Fragment extends Fragment {

    public Button BoardInBtn;
    public View view;
    public Toolbar mainToolbar;
    public ArrayList<Board_Module> boardsArray = new ArrayList<Board_Module>();;
    public Board_Module boards;
    public String[] JsonList = new String[50];;

    private ArrayList<MainData> dataList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mainboard_fragment, container, false);
        setHasOptionsMenu(true);

        swipeLayout = view.findViewById(R.id.swipe_container);
        mainToolbar = view.findViewById(R.id.mainToolbar);
        mainToolbar.setTitle(R.string.mainToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mainToolbar);

        recyclerView = view.findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    

        dataList = new ArrayList<>();
        mainAdapter = new MainAdapter(dataList);
        recyclerView.setAdapter(mainAdapter);
        getBoard();
        for(int i=dataList.size()-1;i>=0;i--){
            if(!dataList.get(i).getErrandProgress().equals("@@Waiting") || dataList.get(i).getOrderID().equals(MainActivity.userID)){
                dataList.remove(i);
            }
        }
        mainAdapter.notifyDataSetChanged();

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataList.clear();
                getBoard();
                for(int i=dataList.size()-1;i>=0;i--){
                    if(!dataList.get(i).getErrandProgress().equals("@@Waiting")|| dataList.get(i).getOrderID().equals(MainActivity.userID)){
                        dataList.remove(i);
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        swipeLayout.setRefreshing(false);
                    }
                }, 1000);
                mainAdapter.notifyDataSetChanged();
            }
        });

        BoardInBtn = view.findViewById(R.id.BoardInBtn);
        BoardInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , InsertBoardActivity.class);
                intent.putExtra("userID",MainActivity.userID);
                startActivity(intent);
            }
        });

        return view;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.menu,menu);
    }

    // 우리 어플은 오전 7시에 시작해서 오후 10시에 끝나는 특성상 날짜를 기제 할 필요가 없음.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.timeSort:{
                dataList.clear();
                getBoard();
                for(int i=dataList.size()-1;i>=0;i--){
                    if(!dataList.get(i).getErrandProgress().equals("@@Waiting") || dataList.get(i).getOrderID().equals(MainActivity.userID)){
                        dataList.remove(i);
                    }
                }
                for(int i=0;i<dataList.size();i++){
                    for(int j=0;j<dataList.size();j++){
                        if(Integer.parseInt(dataList.get(i).getErrandTime()) > Integer.parseInt(dataList.get(j).getErrandTime())){
                            Collections.swap(dataList,i,j);
                        }
                    }
                }
                mainAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "시간순 클릭됨", Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.priceSort: {
                dataList.clear();
                getBoard();
                for(int i=dataList.size()-1;i>=0;i--){
                    if(!dataList.get(i).getErrandProgress().equals("@@Waiting") || dataList.get(i).getOrderID().equals(MainActivity.userID)){
                        dataList.remove(i);
                    }
                }
                for(int i=0;i<dataList.size();i++){
                    for(int j=0;j<dataList.size();j++){
                        if(Integer.parseInt(dataList.get(i).getErrandPrice().replace("원","")) > Integer.parseInt(dataList.get(j).getErrandPrice().replace("원",""))){
                            Collections.swap(dataList,i,j);
                        }
                    }
                }
                mainAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "가격순 클릭됨", Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.logout: {
                Intent intentSerivce = new Intent(getContext(), MyService.class);
                intentSerivce.setAction("/quit");
                getContext().startService(intentSerivce);

                Intent intent = new Intent(this.getActivity() , LoginActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.Notify : {
                Intent intent = new Intent(this.getActivity() , NotifyActivity.class);
                intent.putExtra("userID",MainActivity.userID);
                startActivity(intent);
                return true;
            }
            case R.id.Guide :{
                Intent intent = new Intent(this.getActivity() , GuideActivity.class);
                intent.putExtra("userID",MainActivity.userID);
                startActivity(intent);
                return true;
            }

            case R.id.CustomCare :{
                Intent intent = new Intent(this.getActivity() , CustomCareActivity.class);
                intent.putExtra("userID",MainActivity.userID);
                startActivity(intent);
                return true;
            }
            default:{
                return true;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().invalidateOptionsMenu();
    }

    public void getBoard(){
        //boardsArray 및 JsonList 초기화
        boardsArray.clear();
        for(int i =0;i<JsonList.length;i++){
            JsonList[i] = null;
        }

        //서버에서 데이터 받아오는곳
        ContentValues values = new ContentValues();
        String response = "";
        NetworkTask networkTask = new NetworkTask(resulturl("LoadBoardServlet"), values);
        try {
            response = networkTask.execute().get();
            Log.d("",response);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //데이터 세분화 및 추가
        try{
            response=response.substring(1,response.length()-1);
            JsonList = response.split("\\},", 50);
            for(int i =0;i<JsonList.length-1;i++){
                JsonList[i] += "}";
                Log.d("결과값? : ",JsonList[i]);
            }

            for(int i =0;i<JsonList.length;i++){
                boards = new Board_Module();
                JSONObject jsonObject = new JSONObject(JsonList[i]);
                boards.setO_number(jsonObject.getInt("o_number"));
                boards.setOrders(jsonObject.getString("orders"));
                boards.setTitle(jsonObject.getString("title"));
                boards.setText(jsonObject.getString("text"));
                boards.setLatitude(jsonObject.getDouble("latitude"));
                boards.setLongitude(jsonObject.getDouble("longitude"));
                boards.setDetail_address(jsonObject.getString("detail_address"));
                boards.setPrice(jsonObject.getInt("price"));
                boards.setO_time(jsonObject.getString("o_time").substring(8));
                boards.setProgress(jsonObject.getString("progress"));
                if(jsonObject.getString("progress").equals("@@Waiting")){
                    boards.setErrand("");
                }
                else {
                    boards.setErrand(jsonObject.getString("errand"));
                }
                boardsArray.add(boards);
            }

            for(int i=0; i<boardsArray.size();i++){
                MainData mainData = new MainData(R.drawable.human,boardsArray.get(i).getOrders(),boardsArray.get(i).getErrand(),boardsArray.get(i).getO_time(),boardsArray.get(i).getText(),String.valueOf(boardsArray.get(i).getPrice()),boardsArray.get(i).getProgress(),boardsArray.get(i).getTitle(),boardsArray.get(i).getO_number());
                dataList.add(mainData);
            }

        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String resulturl(String url) { //ip 값 바꿔주는 부분
        String resultUrl = "http://"+FinalURLIP.address+"/" + url;
        return resultUrl;
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}
 ```
 
 -MenuList_Fragment(메뉴리스트)
 
 ```java
 public class MenuList_Fragment extends Fragment {

    public View view;
    public Toolbar mainToolbar;
    public ArrayList<Board_Module> boardsArray = new ArrayList<Board_Module>();

    public Board_Module boards;
    public String[] JsonList = new String[50];
    //public Button Completed_btn;

    private ArrayList<MainData> dataList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menulist_fragment, container, false);
        setHasOptionsMenu(true);

        mainToolbar = view.findViewById(R.id.mainToolbar);
        mainToolbar.setTitle(R.string.mainToolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mainToolbar);

        recyclerView = view.findViewById(R.id.rv_menulist);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        dataList = new ArrayList<>();
        mainAdapter = new MainAdapter(dataList);
        recyclerView.setAdapter(mainAdapter);
        getBoard();
        for(int i=dataList.size()-1;i>=0;i--){
            if(!dataList.get(i).getErrandProgress().equals("@@Completed") || !dataList.get(i).getOrderID().equals(MainActivity.userID)){
                dataList.remove(i);
            }
        }
        mainAdapter.notifyDataSetChanged();

        return view;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menulist_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.waiting: {
                dataList.clear();
                getBoard();
                for(int i=dataList.size()-1;i>=0;i--){
                    if(!dataList.get(i).getErrandProgress().equals("@@Waiting")||!dataList.get(i).getOrderID().equals(MainActivity.userID)){
                        dataList.remove(i);
                    }
                }
                mainAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "대기중인 주문", Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.ongoing: {
                dataList.clear();
                getBoard();
                for(int i=dataList.size()-1;i>=0;i--){
                    if(!dataList.get(i).getErrandProgress().equals("@@Ongoing") || !dataList.get(i).getOrderID().equals(MainActivity.userID)){
                        dataList.remove(i);
                    }
                }
                mainAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "진행중인 주문", Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.accept: {
                dataList.clear();
                getBoard();
                for(int i=dataList.size()-1;i>=0;i--){
                    if(!dataList.get(i).getErrandProgress().equals("@@Ongoing") || !dataList.get(i).getErrandID().equals(MainActivity.userID)){
                        dataList.remove(i);// 상태 - 온고잉 남는유저는 자기빼고 다남아
                    }
                }
                mainAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "수락한 주문", Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.completed: {
                dataList.clear();
                getBoard();
                for(int i=dataList.size()-1;i>=0;i--){
                    if(!dataList.get(i).getErrandProgress().equals("@@Completed") || !(dataList.get(i).getOrderID().equals(MainActivity.userID) || dataList.get(i).getErrandID().equals(MainActivity.userID))){
                        dataList.remove(i);
                    }
                }
                mainAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "완료된 주문", Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.logout: {
                Intent intent = new Intent(this.getActivity(), LoginActivity.class);
                startActivity(intent);
                return true;
            }
            default: {
                return true;
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().invalidateOptionsMenu();
    }



    public void getBoard(){
        //boardsArray 및 JsonList 초기화
        boardsArray.clear();
        for(int i =0;i<JsonList.length;i++){
            JsonList[i] = null;
        }

        boardsArray.clear();
        for(int i =0;i<JsonList.length;i++){
            JsonList[i] = null;
        }

        //서버에서 데이터 받아오는곳
        ContentValues values = new ContentValues();
        String response = "";
        NetworkTask networkTask = new NetworkTask(resulturl("LoadBoardServlet"), values);
        try {
            response = networkTask.execute().get();
            Log.d("",response);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //데이터 세분화 및 추가
        try{
            response=response.substring(1,response.length()-1);

            JsonList = response.split("\\},", 50);
            for(int i =0;i<JsonList.length-1;i++){
                JsonList[i] += "}";
                Log.d("결과값? : ",JsonList[i]);
            }

            for(int i =0;i<JsonList.length;i++){
                boards = new Board_Module();
                JSONObject jsonObject = new JSONObject(JsonList[i]);
                boards.setO_number(jsonObject.getInt("o_number"));
                boards.setOrders(jsonObject.getString("orders"));
                boards.setTitle(jsonObject.getString("title"));
                boards.setText(jsonObject.getString("text"));
                boards.setLatitude(jsonObject.getDouble("latitude"));
                boards.setLongitude(jsonObject.getDouble("longitude"));
                boards.setDetail_address(jsonObject.getString("detail_address"));
                boards.setPrice(jsonObject.getInt("price"));
                boards.setO_time(jsonObject.getString("o_time").substring(8));
                boards.setProgress(jsonObject.getString("progress"));
                if(jsonObject.getString("progress").equals("@@Waiting")){
                    boards.setErrand("");
                }
                else {
                    boards.setErrand(jsonObject.getString("errand"));
                }
                boardsArray.add(boards);
            }

            for(int i=0; i<boardsArray.size();i++){
                MainData mainData = new MainData(R.drawable.human,boardsArray.get(i).getOrders(),boardsArray.get(i).getErrand(),boardsArray.get(i).getO_time(),boardsArray.get(i).getText(),String.valueOf(boardsArray.get(i).getPrice()),boardsArray.get(i).getProgress(),boardsArray.get(i).getTitle(),boardsArray.get(i).getO_number());
                dataList.add(mainData);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String resulturl(String url) { //ip 값 바꿔주는 부분
        String resultUrl = "http://"+FinalURLIP.address+"/" + url;
        return resultUrl;
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}
 ```
 -Chatting_Fragment(채팅)
```java
public class Chatting_Fragment extends Fragment implements View.OnClickListener, View.OnTouchListener{

    public SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    public ChattingRecordModule chatRecordModule;

    public String time="";
    public String hour="";
    public String minute="";
    public String second="";

    public String userID;
    public String otherID;
    public String orderID;
    public String errandID;
    public int num;

    public Toolbar chatToolbar;
    public Button btn_send;
    public EditText et_chat;

    public float oldXvalue, tmp_x;
    public float oldYvalue, tmp_y;

    public View view;
    public ImageView btn_nav;
    public ArrayList<ChattingRecordModule> chatArray = new ArrayList<ChattingRecordModule>();
    public Chat_Module chat;
    public String[] JsonList = new String[50];;

    private ArrayList<ChattingContentData> dataList;
    private ChattingAdapter chattingAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ContentValues values = new ContentValues();
        String response = "";
        values.put("InputIDForChat",MainActivity.userID);
        NetworkTask networkTask = new NetworkTask(resulturl("OrdererErranderID"), values);
        try {
            response = networkTask.execute().get();
            Log.d("ㅡㅡ", response);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(response.contains("orderID")){
            userID = MainActivity.userID;
            try {
                JSONObject jsonObject = new JSONObject(response);
                num = jsonObject.getInt("increase_num");
                orderID = jsonObject.getString("orderID");
                errandID = jsonObject.getString("errandID");
                Log.d("orderID",orderID);
                Log.d("errandID",errandID);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            view = inflater.inflate(R.layout.chatting_fragment, container, false);
            setHasOptionsMenu(true);

            chatToolbar = view.findViewById(R.id.cttoolbar);
            if (userID.equals(orderID)) {
                chatToolbar.setTitle(errandID + " Chatting");
            } else {
                chatToolbar.setTitle(orderID + " Chatting");
            }
            ((AppCompatActivity) getActivity()).setSupportActionBar(chatToolbar);

            btn_nav = view.findViewById(R.id.btn_nav);
            btn_nav.setOnClickListener(this);
            //btn_nav.setOnTouchListener((View.OnTouchListener) this);

            btn_send = view.findViewById(R.id.btn_send);
            et_chat = view.findViewById(R.id.Et_chat);

            recyclerView = view.findViewById(R.id.chat_rv);
            linearLayoutManager = new LinearLayoutManager(view.getContext());
            recyclerView.setLayoutManager(linearLayoutManager);

            dataList = new ArrayList<>();
            chattingAdapter = new ChattingAdapter(dataList);
            recyclerView.setAdapter(chattingAdapter);

            if(userID.equals(errandID)){
                otherID = orderID;
                Log.d("data","주인장");
            }
            else {
                otherID = errandID;
                Log.d("data","손놈");
            }

            getChattingRecord();
            chattingAdapter.notifyDataSetChanged();

            btn_send.setOnClickListener(this);
        }
        else{
            view = inflater.inflate(R.layout.notchatting, container, false);
            setHasOptionsMenu(true);
        }


        return view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int parentWidth = ((ViewGroup) v.getParent()).getWidth();    // 부모 View 의 Width
        int parentHeight = ((ViewGroup) v.getParent()).getHeight();    // 부모 View 의 Height

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                oldXvalue = event.getX();
                oldYvalue = event.getY();
                tmp_x = event.getX();
                tmp_y = event.getY();
            }
            case MotionEvent.ACTION_MOVE: {
                v.setX(v.getX() + (event.getX()) - (v.getWidth() / 2));
                v.setY(v.getY() + (event.getY()) - (v.getHeight() / 2));
            }
            case MotionEvent.ACTION_UP: {
                if (tmp_x == event.getX() || tmp_y == event.getY()) {
                    return false;
                } else {
                    if (v.getX() < 0) {
                        v.setX(0);
                    } else if ((v.getX() + v.getWidth()) > parentWidth) {
                        v.setX(parentWidth - v.getWidth());
                    }

                    if (v.getY() < 0) {
                        v.setY(0);
                    } else if ((v.getY() + v.getHeight()) > parentHeight) {
                        v.setY(parentHeight - v.getHeight());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_send : {
                Intent intent = new Intent(getContext(), MyService.class);
                intent.setAction("Send@" + userID + "@" + otherID + "@" + et_chat.getText().toString());
                getContext().startService(intent);
                break;
            }
            case R.id.btn_nav: {
                Intent intent = new Intent(getContext(), AddressActivity.class);
                intent.putExtra("errandID",errandID);
                startActivity(intent);
                break;
            }
        }
        et_chat.setText("");
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = intent.getStringExtra("message");
            liveGetMsg(msg);
            chattingAdapter.notifyDataSetChanged();
        }
    };

    public void liveGetMsg(String msg){
        String[] msgDiv = msg.split("@");
        String time = String.valueOf(format.format(System.currentTimeMillis()));
        String currentTime = time.substring(8);
        String hour = time.substring(0,2);
        String minute = time.substring(2,4);
        String second = time.substring(4,6);
        ChattingContentData chatData = new ChattingContentData(R.drawable.human, 1, msgDiv[0], msgDiv[1],hour + ":" + minute + ":" + second);
        dataList.add(chatData);
    }

    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mMessageReceiver, new IntentFilter("custom-event-name"));
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mMessageReceiver);
    }


    public void getChattingRecord() {
        //boardsArray 및 JsonList 초기화
        chatArray.clear();
        for (int i = 0; i < JsonList.length; i++) {
            JsonList[i] = null;
        }
        //서버에서 데이터 받아오는곳
        ContentValues values = new ContentValues();
        values.put("userID",userID);
        values.put("otherID",otherID);
        String response = "";
        NetworkTask networkTask = new NetworkTask(resulturl("CallChattingRoomDataServlet"), values);
        try {
            response = networkTask.execute().get();
            Log.d("",response);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(response.contains("senderID")){
            //데이터 세분화 및 추가
            try {
                response = response.substring(1, response.length() - 1);
                JsonList = response.split("\\},", 50);
                for (int i = 0; i < JsonList.length - 1; i++) {
                    JsonList[i] += "}";
                    Log.d("결과값? : ", JsonList[i]);
                }

                for (int i = 0; i < JsonList.length; i++) {
                    chatRecordModule = new ChattingRecordModule();
                    JSONObject jsonObject = new JSONObject(JsonList[i]);
                    chatRecordModule.setNum(jsonObject.getInt("num"));
                    chatRecordModule.setSenderID(jsonObject.getString("senderID"));
                    time = jsonObject.getString("c_time").substring(8);
                    hour = time.substring(0,2);
                    minute = time.substring(2,4);
                    second = time.substring(4,6);
                    chatRecordModule.setC_time(hour + ":" + minute + ":" + second);
                    chatRecordModule.setMsg(jsonObject.getString("Msg"));
                    chatArray.add(chatRecordModule);
                }

                for (int i = 0; i < chatArray.size(); i++) {
                    ChattingContentData chatData = new ChattingContentData(R.drawable.human, chatArray.get(i).getNum(), chatArray.get(i).getSenderID(), chatArray.get(i).getMsg(),chatArray.get(i).getC_time());
                    dataList.add(chatData);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String resulturl(String url) { //ip 값 바꿔주는 부분
        String resultUrl = "http://"+FinalURLIP.address+"/" + url;
        return resultUrl;
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}
```

 - Myinfo_Fragment(내정보수정)

```java
public class MyInfo_Fragment extends Fragment implements View.OnClickListener {

    public Toolbar modifytoolbar;

    EditText ModifyPWText;
    EditText ModifyPWConfirmText;
    TextView ModifyIDText,ModifyNameText,ModifyMajorText,ModifyS_NumText,ModifyGenderText;
    String userID;
    Button ModifyButton;
    public View view;
    public MyInfo_Fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.myinfo_fragment, container, false);

        modifytoolbar = view.findViewById(R.id.ModifyToolbar);
        modifytoolbar.setTitle(R.string.defaultToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(modifytoolbar);

        ModifyPWText = view.findViewById(R.id.ModifyPWText);
        ModifyPWConfirmText = view.findViewById(R.id.ModifyPWConfirmText);
        ModifyButton = view.findViewById(R.id.ModifyButton);

        ModifyIDText = view.findViewById(R.id.ModifyIDText);
        ModifyNameText = view.findViewById(R.id.ModifyNameText);
        ModifyMajorText = view.findViewById(R.id.ModifyMajorText);
        ModifyS_NumText = view.findViewById(R.id.ModifyS_NumText);
        ModifyGenderText = view.findViewById(R.id.ModifyGenderText);
        ModifyButton.setOnClickListener(this);


        ContentValues values = new ContentValues();
        values.put("AccessInfoByID", MainActivity.userID);

        String response = "";
        NetworkTask networkTask = new NetworkTask(resulturl("ShowUserInfoServlet"), values);

        try {
            response = networkTask.execute().get();
            JSONObject jsonObject = new JSONObject(response);

            ModifyIDText.setText(jsonObject.getString("userId"));
            ModifyNameText.setText(jsonObject.getString("userName"));
            ModifyS_NumText.setText(jsonObject.getString("userSchoolNumber"));
            ModifyGenderText.setText(jsonObject.getString("userGender"));
            ModifyMajorText.setText(jsonObject.getString("userMajor"));

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ModifyButton : {
                if(!ModifyPWText.getText().toString().equals(ModifyPWConfirmText.getText().toString()) || ModifyPWText.getText().equals("")) {
                    ModifyPWText.setText("");
                    ModifyPWConfirmText.setText("");
                    Toast.makeText(getContext(),"비밀번호가 없거나 같지않습니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(ModifyPWText.getText().toString().equals("")){
                        Toast.makeText(getContext(),"비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show();;
                        ModifyPWText.requestFocus();
                    }
                    else if(ModifyPWConfirmText.getText().toString().equals("")){
                        Toast.makeText(getContext(),"비밀번호확인을 입력해주세요.",Toast.LENGTH_SHORT).show();;
                        ModifyPWConfirmText.requestFocus();
                    }
                    else{
                        ContentValues values = new ContentValues();
                        values.put("IdentificationID", MainActivity.userID);
                        values.put("AfterPass", SignatureUtil.applySHA256(ModifyPWText.getText().toString()));
                        NetworkTask networkTask = new NetworkTask(resulturl("ChangePWServlet"), values);
                        networkTask.execute();
                        Intent intentSerivce = new Intent(getContext(), MyService.class);
                        intentSerivce.setAction("/quit");
                        getContext().startService(intentSerivce);
                        Intent intent = new Intent(this.getActivity() , LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(),"변경된 비밀번호로 다시 로그인 해주세요",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            default:{
                break;
            }

        }
    }
    public String resulturl(String url) { //ip 값 바꿔주는 부분 이거있어야 서버 쌉가능
        String resultUrl = "http://"+FinalURLIP.address+"/" + url;
        return resultUrl;
    }
    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}
```

- GuideActivity(가이드라인)
```public class GuideActivity extends AppCompatActivity {
    public static String userID;
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        userID = getIntent().getStringExtra("userID");

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(vpPager);

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 5;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Guide_First.newInstance(0, "Page # 1");
                case 1:
                    return Guide_second.newInstance(1, "Page # 2");
                case 2:
                    return Guide_third.newInstance(2, "Page # 3");
                case 3:
                    return Guide_Fourth.newInstance(3, "Page # 4");
                case 4:
                    return Guide_Five.newInstance(4, "Page # 5");
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
}
```

- NoticeActivity(공지사항)

```java
public class NotifyActivity extends AppCompatActivity {

    public Notify_Module notify;
    public ArrayList<Notify_Module> notiArray = new ArrayList<>();
    public String[] JsonList = new String[50];;
    public String userID = "";
    public ArrayList<NoticeData> dataList;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private NoticeAdapter noticeAdapter;
    private Toolbar notiToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        notiToolbar = findViewById(R.id.notiToolbar);
        notiToolbar.setTitle(R.string.mainToolbar);
        setSupportActionBar(notiToolbar);

        userID = getIntent().getStringExtra("userID");
        dataList = new ArrayList<NoticeData>();

        recyclerView = findViewById(R.id.noti_rv);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        noticeAdapter = new NoticeAdapter(dataList);
        recyclerView.setAdapter(noticeAdapter);
        getBoard();
        noticeAdapter.notifyDataSetChanged();
    }

    public void getBoard(){
        //boardsArray 및 JsonList 초기화
        notiArray.clear();
        for(int i =0;i<JsonList.length;i++){
            JsonList[i] = null;
        }

        //서버에서 데이터 받아오는곳
        ContentValues values = new ContentValues();
        String response = "";
        NetworkTask networkTask = new NetworkTask(resulturl("NotifySenderServlet"), values);
        try {
            response = networkTask.execute().get();
            Log.d("",response);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //데이터 세분화 및 추가
        try{
            response=response.substring(1,response.length()-1);
            JsonList = response.split("\\},", 50);
            for(int i =0;i<JsonList.length-1;i++){
                JsonList[i] += "}";
            }

            for(int i =0;i<JsonList.length;i++){
                notify = new Notify_Module();
                JSONObject jsonObject = new JSONObject(JsonList[i]);
                notify.setNum(jsonObject.getString("num"));
                notify.setTitle(jsonObject.getString("title"));
                notify.setContent(jsonObject.getString("content"));
                notify.setTime(jsonObject.getString("time"));
                notiArray.add(notify);
            }
            for(Notify_Module noti : notiArray){
                Log.d("f",noti.getNum()+noti.getTitle()+noti.getContent()+noti.getTime());
                NoticeData noticeData = new NoticeData(noti.getNum(),noti.getTitle(),noti.getContent(),noti.getTime());
                dataList.add(noticeData);
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.noticemenu,menu);
        return true;
    }

    // 우리 어플은 오전 7시에 시작해서 오후 10시에 끝나는 특성상 날짜를 기제 할 필요가 없음.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh : {
                dataList.clear();
                getBoard();
                noticeAdapter.notifyDataSetChanged();
                return true;
            }
            default:{
                return true;
            }
        }
    }

    public String resulturl(String url) { //ip 값 바꿔주는 부분
        String resultUrl = "http://"+FinalURLIP.address+"/" + url;
        return resultUrl;
    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}
```

- InsertBoardActivity(게시글 등록)

```java
public class InsertBoardActivity extends AppCompatActivity {

    private GpsTracker gpsTracker;
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    EditText TitleText;
    EditText AddressText;
    EditText PriceText;
    EditText ContentText;

    Toolbar ConfirmToolbar;
    String userID;
    String latitude;
    String longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_board);

        ConfirmToolbar = findViewById(R.id.confirmToolbar);
        ConfirmToolbar.setTitle(R.string.defaultToolbar);
        setSupportActionBar(ConfirmToolbar);

        TitleText = findViewById(R.id.TitleText);
        AddressText = findViewById(R.id.AddressText);
        PriceText = findViewById(R.id.PriceText);
        ContentText = findViewById(R.id.ConTentText);

        userID =getIntent().getStringExtra("userID");

        if (checkLocationServicesStatus()) {
            checkRunTimePermission();
        } else {
            showDialogForLocationServiceSetting();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.boardinsertmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.BoardConfirm: {
                if (TitleText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "제목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    TitleText.requestFocus();
                } else if (PriceText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "가격을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    PriceText.requestFocus();
                } else if (ContentText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "내용을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    ContentText.requestFocus();
                } else {
                    gpsTracker = new GpsTracker(InsertBoardActivity.this);
                    double latitude = gpsTracker.getLatitude();
                    double longitude = gpsTracker.getLongitude();

                    ContentValues values = new ContentValues();
                    values.put("Post_orders", userID);
                    values.put("Post_title", TitleText.getText().toString());
                    values.put("Post_address", AddressText.getText().toString());
                    values.put("Post_price", PriceText.getText().toString());
                    values.put("Post_text", ContentText.getText().toString());
                    values.put("Post_latitude", String.valueOf(latitude));
                    values.put("Post_longitude", String.valueOf(longitude));
                    values.put("Post_progress","@@Waiting");
                    Log.d("위도",String.valueOf(latitude));
                    Log.d("경도",String.valueOf(longitude));

                    NetworkTask networkTask = new NetworkTask(resulturl("PostOnBoardServlet"), values);
                    networkTask.execute();

                    Intent intent = new Intent(InsertBoardActivity.this, MainActivity.class);
                    intent.putExtra("userID",MainActivity.userID);
                    startActivity(intent);
                }

                //정보들을 서버에 전달하고 메인 엑티비티로 이동하는 기능
                //정보를 서버에 전달할때 gps를 이용해서 위도,경도도 같이 전달
                return true;
            }
            default: {
                return true;
            }
        }
    }

    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {
        if (permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면

            boolean check_result = true;


            // 모든 퍼미션을 허용했는지 체크합니다.

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }


            if (check_result) {

                //위치 값을 가져올 수 있음
                ;
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])) {
                    Toast.makeText(InsertBoardActivity.this, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(InsertBoardActivity.this, "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ", Toast.LENGTH_LONG).show();

                }
            }

        }
    }

    void checkRunTimePermission() {

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(InsertBoardActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(InsertBoardActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION);


        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(InsertBoardActivity.this, REQUIRED_PERMISSIONS[0])) {
                Toast.makeText(InsertBoardActivity.this, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(InsertBoardActivity.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);


            } else {
                ActivityCompat.requestPermissions(InsertBoardActivity.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }

        }

    }


    //여기부터는 GPS 활성화를 위한 메소드들
    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(InsertBoardActivity.this);
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정을 수정하실래요?");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case GPS_ENABLE_REQUEST_CODE:

                //사용자가 GPS 활성 시켰는지 검사
                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {

                        Log.d("@@@", "onActivityResult : GPS 활성화 되있음");
                        checkRunTimePermission();
                        return;
                    }
                }

                break;
        }
    }

    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    public String resulturl(String url) { //ip 값 바꿔주는 부분
        String resultUrl = "http://"+FinalURLIP.address+"/" + url;
        return resultUrl;
    }
    public class NetworkTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        NetworkTask(String url, ContentValues values){
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progress bar를 보여주는 등등의 행위
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result; // 결과가 여기에 담깁니다. 아래 onPostExecute()의 파라미터로 전달됩니다.
        }

        @Override
        protected void onPostExecute(String result) {
            // 통신이 완료되면 호출됩니다.
            // 결과에 따른 UI 수정 등은 여기서 합니다.
            //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}

```
___
## 10. "갖다드림" 어플리케이션 한계점

- 코로나19 바이러스로 인한 비대면수업 = 학교주변 인원 감소
- 방학기간 학교주변 인원 감소에 따른 사용자 감소
- 전문업체가 아닌 사용자끼리 서비스를 제공하는 형태이므로 Service Quality 상이할 가능성有

___

## 11. 결론

- "갖다드림" 은 캠퍼스를 중심으로 학생간 심부름 서비스 플랫폼을 제공하는 어플이다.
- 고용된 직원으로 서비스를 제공하는 것이 아니라, 학생 간 서비스를 주고 받는다는 점에서 기존의 심부름 어플과 차별성을 두고 있다. 또한 같은 학교의 재학생이 서비스를 제공한다는 점에서 서비스의 신뢰도를 보장할 수 있다. 또한 배달 개념의 서비스가아닌 심부름 개념이기에 물건 배달 외에 서비스를 제공할 수 있다.
- 캠퍼스 내 학생 및 기숙사/인근 거주 학생을 중심으로 운영되므로 , 방학이나 전염병 유행 상황 시 서비스가 원활하게 운영되지 않을 수 있다. 또한 서비스에 대한 신뢰도가 사용자의 매너에 의존한다는 점에서 한계점을 가진다. 
- Android 안드로이드에서 HttpUrlConnection을 이용해 Servlet과 단방향 통신으로 하고, service 기능을 이용해 socket과 양방향 통신을 하며, 백엔드로 Servlet과 socket이 JDBC를 통해 Database에 접근 및 관리한다.
___
