package com.imoon.app.imoonapp.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.imoon.app.imoonapp.R;

public class CountActivity extends AppCompatActivity {

    MemberService service; //= new MemberServiceImpl();
    // 필드는 속성을 정의 할 뿐 동작을 실행하지 않는다.
    // OOP는 속성과 기능의 정의를 분할한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        // 맥락없는 설정값은 죽는다. (Context 없는 Property는 죽는다.)
        // Context를 준다
        service  = new MemberServiceImpl(this.getApplicationContext());





    }
}