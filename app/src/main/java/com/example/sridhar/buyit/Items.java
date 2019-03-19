package com.example.sridhar.buyit;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Sridhar on 21-04-2018.
 */

public class Items extends AppCompatActivity {
    ArrayList<ITEM> list;
    Adapteritems adapteritems = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        list=new ArrayList<>();
        adapteritems=new Adapteritems(this,R.layout.item,list);
        Cursor cursor = Admin.sqLiteOpenHelper.getData("select * FROM ITEMS");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name1 = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] images1 = cursor.getBlob(3);
            list.add(new ITEM(id,name1, price, images1));
        }
        adapteritems.notifyDataSetChanged();

    }
    }

