package com.example.sridhar.buyit;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Personal on 11-Mar-18.
 */

public class DatabaseRegister extends SQLiteOpenHelper {
    //    private static String DB_NAME="emagzine";
//    private static String DB_TABLE="register";
//    private static int version=1;
//    Context ct;
    static final private String DB_NAME = "registration";
    static final private String DB_TABLE = "regdata";
    static final private String DB_TABLE1 = "cart";
    static final private int DB_VERSION = 1;
    static final private String DB_TABLE2 = "ITEM";

    SQLiteDatabase mydbs;
    Context ct;
    SQLiteDatabase Writable, Readable;
    private byte[] images;
    public Object deletefromitems;


    public DatabaseRegister(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        ct = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table regdata(register_id TEXT,password TEXT,conform_password TEXT,emailid TEXT,phonno INTEGER);";
        db.execSQL(query);
        db.execSQL("create table cart(name TEXT,names TEXT,image BLOB)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists regdata");
        onCreate(db);
    }

    public long insertdata(String register_id, String password, String conform_password, String emailid, String phonno) {
        ContentValues values = new ContentValues();
        values.put("register_id", register_id);
        values.put("password", password);
        values.put("conform_password", conform_password);
        values.put("emailid", emailid);
        values.put("phonno", phonno);
        Writable = getWritableDatabase();
        return Writable.insert("regdata", null, values);
    }

    public void display() {
        Readable = getReadableDatabase();
        Cursor c = Readable.query("regdata", new String[]{"register_id", "password", "conform_password", "emailid", "phonno"}, null, null, null, null, null);
        while (c.moveToNext()) {
            String register_id = c.getString(0);
            String password = c.getString(1);
            String conform_password = c.getString(2);
            String email = c.getString(3);
            String phonno = c.getString(4);
            Toast.makeText(ct, "\n" + register_id + "\n" + password + "\n" + conform_password + "\n" + email + "\n" + phonno, Toast.LENGTH_SHORT).show();
        }
    }

    public long login(String u, String p) {
        Readable = getReadableDatabase();
        Cursor c = Readable.rawQuery("select password from regdata where register_id='" + u + "';", null);
        while (c.moveToFirst()) {
            String password = c.getString(0);
            if (p.equals(password)) {
                ct.startActivity(new Intent(ct, MainActivity.class));
            } else {
                Toast.makeText(ct, "login failed", Toast.LENGTH_SHORT).show();
            }

            return 0;
        }

        return 0;
    }


    public long insertdata(String names, String name, byte[] images) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("names", names);
        values.put("image",images);
        Writable = getWritableDatabase();
        long added = Writable.insert("cart", null, values);

        if (added > 0) {
            Toast.makeText(ct, "added", Toast.LENGTH_SHORT).show();
            ct.startActivity(new Intent(ct, Cartrecycle.class));


        }
        return 0;
    }

    public String getcartdata() {
        Readable = getReadableDatabase();
        String name = null;
        StringBuilder sb = new StringBuilder();
        Cursor c = Readable.query("cart", new String[]{"name", "names"}, null, null, null, null, null);
        while (c.moveToNext()) {
            sb.append(c.getString(0) + "\n");
            sb.append(c.getString(1) + "\n");
            String names = c.getString(1);

        }
        return sb.toString();
    }


    public long count() {
        if (Writable == null)
            Writable = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(Writable, "cart");

    }


    public List<CARD_ITEM> getnameposition() {
        Readable = getReadableDatabase();
        List<CARD_ITEM> items=new ArrayList<>();
        String quary = "select * from " + DB_TABLE1 + " ORDER BY name ASC ";
        Cursor c = Readable.rawQuery(quary, null);
        while (c.moveToNext()) {
            CARD_ITEM card_item=new CARD_ITEM();
            String name = c.getString(0);
            String price=c.getString(1);
            byte[] img=c.getBlob(2);
            card_item.setImages1(img);
            card_item.setName1(name);
            card_item.setPrice(price);
            items.add(card_item);
        }
        return items;
    }

    public String getpriceposition(int position) {
        String name = null;
        Readable = getReadableDatabase();
        String quary = "select * from " + DB_TABLE1 + " ORDER BY name ASC " + " LIMIT " + position + ",1";
        Cursor c = Readable.rawQuery(quary, null);
        while (c.moveToNext()) {
            name = c.getString(1);

        }
        return name;

    }

    public byte[] getimage(int position) {
        byte[] name = null;
        Readable = getReadableDatabase();
        String quary = "select image from " + DB_TABLE1 + "";
        Cursor c = Readable.rawQuery(quary, null);
        while (c.moveToNext()) {
            name = c.getBlob(2);

        }
        return name;

    }

    public void cleardata() {
        Writable = getReadableDatabase();
        Writable.execSQL("delete from " + DB_TABLE1 + "");
        Toast.makeText(ct, "delete", Toast.LENGTH_SHORT).show();
    }

    public void deletefromcart(String s) {

        Writable=getWritableDatabase();
        Toast.makeText(ct, ""+s, Toast.LENGTH_SHORT).show();
            long l=Writable.delete(DB_TABLE1,"name=?",new String[]{s});
        if(l>0){
            Toast.makeText(ct, "deleted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(ct, "not at", Toast.LENGTH_SHORT).show();
        }

    }


}