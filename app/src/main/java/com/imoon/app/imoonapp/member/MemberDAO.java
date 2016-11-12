package com.imoon.app.imoonapp.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO {

    public MemberDAO(Context context) {

    }

    public void insert(MemberDTO param){

    }
    public int selectCount(){
        int count = 0;
        return count;
    }
    public MemberDTO selectOne(String id){
        MemberDTO member = new MemberDTO();
        return  member;
    }
    public ArrayList<MemberDTO> selectList(){
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        return  list;
    }
    public MemberDTO login(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return  member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }
}
