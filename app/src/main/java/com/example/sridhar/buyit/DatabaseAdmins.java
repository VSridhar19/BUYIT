package com.example.sridhar.buyit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

/**
 * Created by Sridhar on 19-04-2018.
 */

public class DatabaseAdmins extends SQLiteOpenHelper {
    public static Object insertData;
    private String name1;
    private String price;
    static final private String DB_TABLE1 = "cart";
    public Object deletefromitems;
    private byte[] image1;
    SQLiteOpenHelper sql;
    Context ct;
    private SQLiteDatabase Writable;

    public DatabaseAdmins(Context context) {
        super(context, "admindata", null, 1);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name1, byte[] image1, String price) {
        this.name1 = name1;
        this.price = price;
        this.image1 = image1;
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO ITEM VALUES(NULL,? ,? ,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name1);
        statement.bindString(2, price);
        statement.bindBlob(3, image1);
        statement.executeInsert();
    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE ITEM(Id INTEGER PRIMARY KEY AUTOINCREMENT,name1 TEXT NOT NULL, price TEXT NOT NULL,images1 BLOG)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ITEM");
        onCreate(sqLiteDatabase);
    }

    public  long insertData(String trim, String trim1, byte[] bytes) {
        ContentValues values=new ContentValues();
        values.put("name1",trim);
        values.put("price",trim1);
        values.put("images1",bytes);
        long a=getWritableDatabase().insert("ITEM",null,values);
        return a;
    }
    public void deletefromitems(String s) {

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



    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}
