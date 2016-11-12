package com.imoon.app.imoonapp.member;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberServiceImpl implements MemberService {

    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    @Override
    public void join(MemberDTO param) {
        Log.d("JOIN ID ", param.getId());
        Log.d("JOIN PWD ", param.getPwd());
        Log.d("JOIN NAME ", param.getName());
        Log.d("JOIN EMAIL ", param.getEmail());
        Log.d("JOIN Phone ", param.getPhone());
        Log.d("JOIN Addr ", param.getAddr());


        dao.insert(param);
    }

    @Override
    public int count() {

        int count = 0;
        return count;
    }

    @Override
    public MemberDTO detail(String id) {
        MemberDTO member = new MemberDTO();
        return member;
    }

    @Override
    public ArrayList<MemberDTO> list() {
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }

    @Override
    public MemberDTO login(MemberDTO param) {

        Log.d("JOIN ID ", param.getId());
        Log.d("JOIN PWD ", param.getPwd());

        MemberDTO member = dao.login(param);
        return member;
    }

    @Override
    public void update(MemberDTO param) {

    }

    @Override
    public void delete(MemberDTO param) {

    }
}
