package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class counter extends AppCompatActivity {

    Integer interval=1; //카운터 간격은 디폴트값으로 1로 지정함

    //======interval 변수를 함수로 통해 지정하고 읽을 수 있게 만듦
    //매개변수로 정수를 입력받아 interval을 지정하는 함수
    public void setInterval(Integer n)
    {
        interval=n;
    }
    //interval 값을 전달하는 함수
    public Integer getInterval(){
        return interval;
    }

    //============= 레이아웃 생성, 초기화 컴포넌트를 불러옴
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //프로그램 Activity가 생성할 때 실행
        setContentView(R.layout.activity_counter); //화면 디자인을 xml로 정의해놓은 파일을 불러와 지정

        //======초기화, 설정, 증가, 감소 버튼 가져오기

        //초기화 버튼 객체를 참조하여 변수에 저장
        Button cleanButton = (Button) findViewById(R.id.buttonClean);
        //설정 버튼 객체를 참조하여 변수에 저장
        Button settingButton = (Button) findViewById(R.id.buttonsetting);
        //증가 버튼 객체를 참조하여 변수에 저장
        Button upButton = (Button) findViewById(R.id.buttonUp);
        //감소 버튼 객체를 참조하여 변수에 저장
        Button downButton = (Button) findViewById(R.id.buttonDown);

        //======숫자를 보여주는 텍스트 뷰, 사용자로부터 초기값과 간격을 입력받는 에디트 텍스트 가져오기

        //사용자로부터 초기값을 입력받을 텍스트에디트 객체를 참조하여 변수에 저장
        EditText et = (EditText) findViewById(R.id.editText);
        //사용자로부터 카운트 간격을 입력받을 텍스트에디트 객체를 참조하여 변수에 저장
        EditText et_interval = (EditText) findViewById(R.id.editTextnum);
        //카운터가 되는 것을 시각적으로 보여주는 텍스트뷰 객체를 참조하여 변수에 저장
        TextView tv = (TextView) findViewById(R.id.textViewCounter);

        //======초기화 버튼을 눌렀을 때, 익명 클래스를 사용
        cleanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //사용자로 부터 입력받은 값을 가져와서 문자열로 변경 후 변수에 저장한다
                String initNum= et.getText().toString();
                //사용자로부터 받은 값이 빈값이 아니라면
                if(initNum!=""){
                    //사용자로부터 받은 초기값으로 지정해준다
                    tv.setText(initNum);
                }
            }
        });

        //======설정 버튼을 눌렀을 때, 익명클래스 사용
        settingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //사용자로 부터 입력받은 값을 자져와서 문자열로 변경 후 변수에 저장한다
                String interval_Num= et_interval.getText().toString();
                //사용자로부터 받은 값이 빈값이 아니라면
                if(interval_Num!=""){
                    //사용자로부터 받은 초기값으로 지정해준다
                    setInterval(Integer.valueOf(interval_Num));
                }
            }
        });

        //======증가 버튼을 눌렀을 때, 익명클래스 사용
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //현재 카운터 숫자를 가져와서 문자열을 정수형으로 변환한다
                Integer num = Integer.valueOf(tv.getText().toString());
                //증가버튼을 눌러줬으므로 현재 숫자에서 증가해주고
                //텍스트뷰에 증가한 숫자를 문자열로 변환 후에 지정해준다
                num = num + getInterval();
                tv.setText(String.valueOf(num));

            }
        });

        //======감소 버튼을 눌렀을 때, 익명클래스 사용
        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //현재 카운터 숫자를 가져와서 문자열을 정수형으로 변환한다
                Integer num = Integer.valueOf(tv.getText().toString());
                //증가버튼을 눌러줬으므로 현재 숫자에서 감소해주고
                //텍스트뷰에 감소한 숫자를 문자열로 변환 후에 지정해준다
                num = num - getInterval();
                tv.setText(String.valueOf(num));

            }
        });
    }
}