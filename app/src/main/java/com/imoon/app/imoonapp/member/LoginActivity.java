package com.imoon.app.imoonapp.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imoon.app.imoonapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    MemberService service;
    EditText et_id, et_password;
    Button bt_login, bt_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        service = new MemberServiceImpl(this.getApplicationContext());
        et_id = (EditText) findViewById(R.id.et_id);
        et_password = (EditText) findViewById(R.id.et_password);

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                MemberDTO param = new MemberDTO();
                String id = et_id.getText().toString();
                param.setId(id);

                param.setPwd(et_password.getText().toString());
                if(service.login(param)){
                    Toast.makeText(LoginActivity.this,"로그인성공", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("id", id);
                    this.startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"로그인실패", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_join:
                this.startActivity(new Intent(LoginActivity.this, JoinActivity.class));
                break;
        }
    }
}