package com.imoon.app.imoonapp.member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public interface MemberService {
    public void join(MemberDTO param);
    public int count();
    public MemberDTO detail(String id);
    public ArrayList<MemberDTO> list();
    public MemberDTO login(MemberDTO param);
    public void update(MemberDTO param);
    public void delete(MemberDTO param);
}