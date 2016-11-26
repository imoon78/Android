package com.imoon.app.imoonapp.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.imoon.app.imoonapp.R;
import com.imoon.app.imoonapp.util.MapsActivity;
import com.imoon.app.imoonapp.util.Phone;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;
    ImageView iv_photo;
    TextView tv_name, tv_id, tv_email,tv_phone,tv_address, tv_pw;
    Button bt_call,bt_message,bt_movie,bt_update,bt_list,bt_map;
    String id;
    Phone phone;
    MemberDTO member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service  = new MemberServiceImpl(this.getApplicationContext());

        iv_photo = (ImageView) findViewById(R.id.iv_photo);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_address = (TextView) findViewById(R.id.tv_address);
        tv_pw = (TextView) findViewById(R.id.tv_password);

        id = this.getIntent().getExtras().getString("id");
        member = service.detail(id);
        if(member != null){
            tv_name.setText(member.getName());
            tv_id.setText(member.getId());
            tv_email.setText(member.getEmail());
            tv_phone.setText(member.getPhone());
            tv_address.setText(member.getAddr());
            tv_pw.setText(member.getPwd());
        }else{
            Log.d("아이디가 존재","하지않음");
        }

        bt_call = (Button) findViewById(R.id.bt_call);
        bt_message = (Button) findViewById(R.id.bt_message);
        bt_movie = (Button) findViewById(R.id.bt_movie);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_list = (Button) findViewById(R.id.bt_list);
        bt_map = (Button) findViewById(R.id.bt_map);
        bt_call.setOnClickListener(this);
        bt_message.setOnClickListener(this);
        bt_movie.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_list.setOnClickListener(this);
        bt_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt_call:
                Log.d("전화번호출력:","OK");
                phone = new Phone(this, this);
                phone.directCall(member.getPhone());
                break;
            case R.id.bt_message:break;
            case R.id.bt_movie:break;
            case R.id.bt_update:
                intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.bt_list:
                startActivity(new Intent(DetailActivity.this, UpdateActivity.class));
                break;
            case R.id.bt_map:
                Log.d("구글맵 클릭", "OK");
                intent = new Intent(DetailActivity.this, MapsActivity.class);
                // 원래 주소 -> 위경로로 바꿔져야 함. (시청역 : 37.5665893,126.9785535)
                String pos = member.getAddr();
                // 주소를 위경로로 변경 로직 들어 가야함
                pos = "37.5665893,126.9785535";
                intent.putExtra("pos", pos);
                startActivity(intent);
                break;
        }
    }
}
