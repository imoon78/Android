package com.imoon.app.imoonapp.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by 1027 on 2016-11-26.
 */

public class Phone {
    private Context context;
    private Activity activity;      // 연관관계로 구현(네이티브 구현은 이렇게 가는게 맞음)

    public Phone(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    // 다이얼 버튼 나옴
    public void dial(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        context.startActivity(intent);
    }

    //실제 전화
    public void directCall(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE},2);
            return;
        }
        context.startActivity(intent);
    }
}