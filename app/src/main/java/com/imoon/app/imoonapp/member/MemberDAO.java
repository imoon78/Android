package com.imoon.app.imoonapp.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.imoon.app.imoonapp.global.Member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper {

    public MemberDAO(Context context) {
        super(context, "imoon.db", null, 1); // param 두번째 Factory값은 null : 시스템꺼 쓰지않고 만들어 씀
        this.getWritableDatabase();     //DB 만들어짐

        Log.d("DB생성","성공");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //테이블 생성
        db.execSQL("CREATE TABLE IF NOT EXISTS " +Member.TABLE+ "\n" +
                "(\n" +
                Member.ID+ " text primary key,\n" +
                Member.PW + " text,\n" +
                Member.NAME + " text,\n" +
                Member.EMAIL + " text,\n" +
                Member.PHONE + " text,\n" +
                Member.PHOTO + " text,\n" +
                Member.ADDR + " text );");


        // 임의값 넣기
        db.execSQL("INSERT INTO " + Member.TABLE + "("+ Member.ID
                +", "+ Member.PW +", "+ Member.NAME +", "+ Member.EMAIL +", " + Member.PHONE +", " + Member.PHOTO + "," + Member.ADDR +")\n"
                + "VALUES('imoon', '1', 'jsmoon', 'imoon@test.com', '010-123-1234', 'default.jpg','서울');");

        Log.d("테이블생성","성공");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public void insert(MemberDTO param){

        Log.d("DAO JOIN ID ", param.getId());
        Log.d("DAO JOIN PWD ", param.getPwd());
        Log.d("DAO JOIN NAME ", param.getName());
        Log.d("DAO JOIN EMAIL ", param.getEmail());
        Log.d("DAO JOIN Phone ", param.getPhone());
        Log.d("DAO JOIN Addr ", param.getAddr());

        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
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
        Log.d("DAO LOGIN ID ", param.getId());
        Log.d("DAO LOGIN PWD ", param.getPwd());

        String sql = "SELECT "+Member.PW+
                " FROM " + Member.TABLE+" WHERE id = '"+ param.getId() +"';";
        MemberDTO member = new MemberDTO();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            member.setPwd(cursor.getString(0));
        }
        Log.d("PW",member.getPwd());
        return  member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }
}
