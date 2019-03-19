package com.example.sridhar.buyit;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemList extends AppCompatActivity {
    ArrayList<ITEM> list;
    String s,s1;
    TextView t1,t2;
    RecyclerView recyclerview;
    DatabaseAdmins databaseAdmins;
    ItemsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list1);
        recyclerview=(RecyclerView) findViewById(R.id.recycle);
        recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        list=new ArrayList<>();
        databaseAdmins=new DatabaseAdmins(this);
        Intent i1 = getIntent();
        s = i1.getStringExtra("username");
        s1=i1.getStringExtra("password");
        Cursor cursor = databaseAdmins.getData("select * FROM ITEM");
        Toast.makeText(this, ""+cursor.getCount(), Toast.LENGTH_SHORT).show();
        while (cursor.moveToNext()) {
            ITEM item=new ITEM();
            int id = cursor.getInt(0);
            String name1 = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] images1 = cursor.getBlob(3);
            Toast.makeText(this, ""+id+"\n"+name1+"\n"+price+"\n"+images1.toString(), Toast.LENGTH_SHORT).show();
            item.setId(id);
            item.setName1(name1);
            item.setPrice(price);
            item.setImages1(images1);
            list.add(item);


        }
        adapter=new ItemsAdapter(this,list,s,s1);
        recyclerview.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }
}
