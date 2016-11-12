package com.imoon.app.imoonapp.member;

import android.content.Context;

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

        MemberDTO member = new MemberDTO();
        return member;
    }

    @Override
    public void update(MemberDTO param) {

    }

    @Override
    public void delete(MemberDTO param) {

    }
}
