package com.imoon.app.imoonapp.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static com.imoon.app.imoonapp.global.Member.ADDR;
import static com.imoon.app.imoonapp.global.Member.EMAIL;
import static com.imoon.app.imoonapp.global.Member.ID;
import static com.imoon.app.imoonapp.global.Member.NAME;
import static com.imoon.app.imoonapp.global.Member.PHONE;
import static com.imoon.app.imoonapp.global.Member.PHOTO;
import static com.imoon.app.imoonapp.global.Member.PW;
import static com.imoon.app.imoonapp.global.Member.TABLE;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper {

    public MemberDAO(Context context) {
        super(context, "imoon2.db", null, 1); // param 두번째 Factory값은 null : 시스템꺼 쓰지않고 만들어 씀
        this.getWritableDatabase();     //DB 만들어짐

        Log.d("DB생성","성공");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //테이블 생성
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE+ "\n" +
                "(\n" +
                ID+ " text primary key,\n" +
                PW + " text,\n" +
                NAME + " text,\n" +
                EMAIL + " text,\n" +
                PHONE + " text,\n" +
                PHOTO + " text,\n" +
                ADDR + " text );");


        // 임의값 넣기
        db.execSQL("INSERT INTO " + TABLE + "("+ ID
                +", "+ PW +", "+ NAME +", "+ EMAIL +", " + PHONE +", " + PHOTO + "," + ADDR +")\n"
                + "VALUES('imoon1', '1', 'jsmoon1', 'imoon1@test.com', '010-123-1231', 'default.jpg','서울');");

        db.execSQL("INSERT INTO " + TABLE + "("+ ID
                +", "+ PW +", "+ NAME +", "+ EMAIL +", " + PHONE +", " + PHOTO + "," + ADDR +")\n"
                + "VALUES('imoon2', '1', 'jsmoon2', 'imoon2@test.com', '010-123-1232', 'default.jpg','pusan');");

        db.execSQL("INSERT INTO " + TABLE + "("+ ID
                +", "+ PW +", "+ NAME +", "+ EMAIL +", " + PHONE +", " + PHOTO + "," + ADDR +")\n"
                + "VALUES('imoon3', '1', 'jsmoon3', 'imoon3@test.com', '010-123-1233', 'default.jpg','jeju');");

        db.execSQL("INSERT INTO " + TABLE + "("+ ID
                +", "+ PW +", "+ NAME +", "+ EMAIL +", " + PHONE +", " + PHOTO + "," + ADDR +")\n"
                + "VALUES('imoon4', '1', 'jsmoon4', 'imoon4@test.com', '010-123-1234', 'default.jpg','서울');");

        db.execSQL("INSERT INTO " + TABLE + "("+ ID
                +", "+ PW +", "+ NAME +", "+ EMAIL +", " + PHONE +", " + PHOTO + "," + ADDR +")\n"
                + "VALUES('imoon5', '1', 'jsmoon5', 'imoon5@test.com', '010-123-1235', 'default.jpg','서울');");

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
        MemberDTO temp = null;
        String sql = String.format("SELECT %s,%s,%s,%s,%s,%s,%s FROM %s WHERE %s ='%s';",ID, PW, NAME, EMAIL, PHONE,PHOTO, ADDR, TABLE, ID, id);
        Log.d(sql, "쿼리");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPwd(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setPhoto(cursor.getString(5));
            temp.setAddr(cursor.getString(6));
        }
        return  temp;
    }
    public ArrayList<MemberDTO> selectList(){
        String sql =  "SELECT "+String.format("%s,%s,%s,%s,%s,%s,%s",ID, PW, NAME, EMAIL, PHONE,PHOTO, ADDR)+" FROM member;";
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null){
            Log.d("DAO LIST IS","EXIST");
            cursor.moveToFirst();
        }
        do{
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPwd(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setAddr(cursor.getString(5));
            list.add(temp);
        }while (cursor.moveToNext());

        return  list;
    }
    public MemberDTO login(MemberDTO param){
        Log.d("DAO LOGIN ID ", param.getId());
        Log.d("DAO LOGIN PWD ", param.getPwd());

        String sql = "SELECT "+ PW+
                " FROM " + TABLE+" WHERE id = '"+ param.getId() +"';";
        MemberDTO member = new MemberDTO();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            member.setPwd(cursor.getString(0));
        }

        return  member;
    }
    public void update(MemberDTO param){
        String sql = String.format(
                "UPDATE member " +
                        "SET pw='%s',email='%s',phone='%s',photo='%s',addr='%s' " +
                        "WHERE id = '%s';"
                ,param.getPwd(),param.getEmail(),param.getPhone(),param.getPhoto(),param.getAddr(),param.getId()
        );
        Log.d(sql,"업데이트 쿼리");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
    public void delete(String id){
        String sql = String.format("DELETE FROM %s WHERE id='%s';", TABLE, id);
        Log.d(sql,"삭제 쿼리");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}
