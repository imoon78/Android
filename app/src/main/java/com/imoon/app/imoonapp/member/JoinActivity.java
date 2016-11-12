package com.imoon.app.imoonapp.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.imoon.app.imoonapp.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;
    EditText et_id, et_password, et_name, et_email, et_phone, et_address;
    Button bt_submit, bt_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service  = new MemberServiceImpl(this.getApplicationContext());

        et_id = (EditText) findViewById(R.id.et_id);
        et_password = (EditText) findViewById(R.id.et_password);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_address = (EditText) findViewById(R.id.et_address);

        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_submit:
                MemberDTO param = new MemberDTO();
                param.setId(et_id.getText().toString());
                param.setPwd(et_password.getText().toString());
                param.setName(et_name.getText().toString());
                param.setEmail(et_email.getText().toString());
                param.setPhone(et_phone.getText().toString());
                param.setAddr(et_address.getText().toString());
                service.join(param);
                break;
            case R.id.bt_cancel:
                break;
        }
    }
}
