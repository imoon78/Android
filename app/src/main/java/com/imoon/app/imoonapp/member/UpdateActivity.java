package com.imoon.app.imoonapp.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.imoon.app.imoonapp.R;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;
    TextView tv_name, tv_id;
    EditText et_email,et_phone,et_address, et_pw;
    Button bt_confirm, bt_cancel;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        service  = new MemberServiceImpl(this.getApplicationContext());

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_id = (TextView) findViewById(R.id.tv_id);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_address = (EditText) findViewById(R.id.et_address);
        et_pw = (EditText) findViewById(R.id.et_password);
        id = this.getIntent().getExtras().getString("id");

        bt_confirm = (Button) findViewById(R.id.bt_confirm);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_confirm.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

        MemberDTO member = service.detail(id);
        if(member != null){
            tv_name.setText(member.getName());
            tv_id.setText(member.getId());
            et_email.setText(member.getEmail());
            et_phone.setText(member.getPhone());
            et_address.setText(member.getAddr());
            et_pw.setText(member.getPwd());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_confirm:
                service = new MemberServiceImpl(this.getApplicationContext());
                MemberDTO member = new MemberDTO();
                member.setId(tv_id.getText().toString());
                member.setEmail(et_email.getText().toString());
                member.setPwd(et_pw.getText().toString());
                member.setAddr(et_address.getText().toString());
                member.setPhone(et_phone.getText().toString());
                service.update(member);
                Intent intent = new Intent(UpdateActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
                break;
            case R.id.bt_cancel:

                break;
        }
    }
}
