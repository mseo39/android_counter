package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //============= 레이아웃 생성, 초기화 컴포넌트를 불러옴
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //프로그램 Activity가 생성할 때 실행
        setContentView(R.layout.activity_main); //화면 디자인을 xml로 정의해놓은 파일을 불러와 지정

        //시작 버튼인 button2 id를 가진 버튼을 찾아 버튼 참조 변수에 저장
        Button startButton1 = (Button) findViewById(R.id.button2);

        //시작 버튼을 눌렀을때
        startButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent는 메시징 객체로, 다른 앱 구성 요소로부터 작업을 요청하는 데 사용할 수 있습니다.
                // 인텐트가 구성 요소 사이의 통신을 촉진
                Intent counter_intent = new Intent(MainActivity.this, counter.class);
                //액티비티를 실행
                startActivity(counter_intent);
            }
        });
    }
}