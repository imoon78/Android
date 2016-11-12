package com.imoon.app.imoonapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.imoon.app.imoonapp.clac.CalcActivity;
import com.imoon.app.imoonapp.member.JoinActivity;
import com.imoon.app.imoonapp.member.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_calc,bt_join,bt_login;  // ;콜론은 cpu 한번 다니옴

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_calc = (Button) findViewById(R.id.bt_clac);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_login = (Button) findViewById(R.id.bt_login);

        // 클릭 리스너 등록
        bt_calc.setOnClickListener(this);
        bt_join.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_clac:
                Intent intent = new Intent(this.getApplicationContext(), CalcActivity.class);
                this.startActivity(intent);
                break;
            case R.id.bt_join:
                Intent intent2 = new Intent(this.getApplicationContext(), JoinActivity.class);
                this.startActivity(intent2);
                break;
            case R.id.bt_login:
                Intent intent3 = new Intent(this.getApplicationContext(), LoginActivity.class);
                this.startActivity(intent3);
                break;
        }
   }
}