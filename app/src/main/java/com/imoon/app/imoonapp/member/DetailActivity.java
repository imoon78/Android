package com.imoon.app.imoonapp.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.imoon.app.imoonapp.R;

public class DetailActivity extends AppCompatActivity {

    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service  = new MemberServiceImpl(this.getApplicationContext());
    }
}
