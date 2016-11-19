package com.imoon.app.imoonapp.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.imoon.app.imoonapp.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    MemberService service;
    ListView lv_member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        service  = new MemberServiceImpl(this.getApplicationContext());
        ArrayList<MemberDTO> list = service.list();
        Log.d("친구 수",String.valueOf(list.size()));
        lv_member = (ListView) findViewById(R.id.lv_member);
        lv_member.setAdapter(new MemberAdapter(this, list));
        

    }
}
