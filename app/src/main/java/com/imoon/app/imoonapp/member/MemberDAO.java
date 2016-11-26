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
import static com.imoon.app.imoonapp.global.Message.CONTENT;
import static com.imoon.app.imoonapp.global.Message.MESSAGE;
import static com.imoon.app.imoonapp.global.Message.RECEIVER;
import static com.imoon.app.imoonapp.global.Message.SENDER;
import static com.imoon.app.imoonapp.global.Message.WRITE_TIME;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper {

    public MemberDAO(Context context) {
        super(context, "imoon5.db", null, 1);     // param 두번째 Factory값은 null : 시스템꺼 쓰지않고 만들어 씀
        this.getWritableDatabase();                 //DB 만들어짐
        Log.d("DB생성","성공");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //테이블 생성
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE+ "\n" +
                "(\n" +
                ID+ " TEXT PRIMARY KEY,\n" +
                PW + " TEXT,\n" +
                NAME + " TEXT,\n" +
                EMAIL + " TEXT,\n" +
                PHONE + " TEXT,\n" +
                PHOTO + " TEXT,\n" +
                ADDR + " TEXT );");

        db.execSQL(
                String.format("CREATE TABLE IF NOT EXISTS %s(" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT, " +
                        "%s TEXT, " +
                        "%s TEXT, " +
                        "%s TEXT, " +
                        "%s TEXT, CONSTRAINT message_fk FOREIGN KEY(ID) REFERENCES %s(%s));", MESSAGE, SENDER, RECEIVER, WRITE_TIME, CONTENT, ID, TABLE, ID)
        );

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


        db.execSQL(
                String.format("INSERT INTO %s(%s, %s, %s, %s,%s) " +
                        "VALUES('KIM','HONG','2016-11-26 12:05','Hello Hong','imoon1');", MESSAGE, SENDER, RECEIVER, WRITE_TIME, CONTENT,ID)
        );
        db.execSQL(
                String.format("INSERT INTO %s(%s, %s, %s, %s,%s) " +
                        "VALUES('KIM','HONG','2016-11-26 12:34','Thanks Hong','imoon1');", MESSAGE, SENDER, RECEIVER, WRITE_TIME, CONTENT,ID)
        );
        db.execSQL(
                String.format("INSERT INTO %s(%s, %s, %s, %s,%s) " +
                        "VALUES('KIM','HONG','2016-11-26 12:50','Bye Hong','imoon1');", MESSAGE, SENDER, RECEIVER, WRITE_TIME, CONTENT,ID)
        );

        Log.d("테이블생성","성공");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public void insert(MemberDTO param){
        String sql = String.format(
                "INSERT INTO member (id, pw, name, email, phone, photo, addr) " +
                        "VALUES('%s','%s','%s','%s','%s','%s','%s');", param.getId(), param.getPwd(), param.getName(), param.getEmail(), param.getPhone(), param.getAddr());
        Log.d(sql,"[쿼리] insert");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public int selectCount(){
        int count = 0;
        String sql = String.format("SELECT COUNT(*) AS count FROM member;");
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        return count;
    }
    public MemberDTO selectOne(String id){
        MemberDTO temp = null;
        String sql = String.format("SELECT id,pw,name,email,phone,photo,addr FROM member WHERE id ='%s';", id);
        Log.d(sql, "[퀴리] selectOne");
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

    public ArrayList<MemberDTO> findBy(MemberDTO param){
        String sql = String.format("SELECT id,pw,name,email,phone,photo,addr " +
                "FROM member WHERE id = '%s'", param.getId());
        Log.d(sql, "[퀴리] findBy");

        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null){
            Log.d("findBy Result :","EXIST");
            cursor.moveToFirst();
        }
        do{
            MemberDTO dto = new MemberDTO();
            dto.setId(cursor.getString(0));
            dto.setPwd(cursor.getString(1));
            dto.setName(cursor.getString(2));
            dto.setEmail(cursor.getString(3));
            dto.setPhone(cursor.getString(4));
            dto.setAddr(cursor.getString(5));
            list.add(dto);
        }while (cursor.moveToNext());

        return list;
    }

    public ArrayList<MemberDTO> selectList(){
        String sql =  String.format("SELECT id,pw,name,email,phone,photo,addr FROM member;");
        Log.d(sql,"[쿼리] selectList");
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

        String sql = String.format("SELECT pw FROM member WHERE id = '%s';", param.getId());
        Log.d(sql,"[쿼리] login");

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
        Log.d(sql,"[쿼리] update");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
    public void delete(String id){
        String sql = String.format("DELETE FROM member WHERE id='%s';", id);
        Log.d(sql,"[쿼리] delete");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}
