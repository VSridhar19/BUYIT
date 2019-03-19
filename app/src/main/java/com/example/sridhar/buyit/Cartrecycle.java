package com.example.sridhar.buyit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Cartrecycle extends AppCompatActivity {
    RecyclerView recycle;
    DatabaseRegister db;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartrecycle);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        db = new DatabaseRegister(this);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setHasFixedSize(true);
        Adaptercart a = new Adaptercart(this, db);
        recycle.setAdapter(a);
        a.notifyDataSetChanged();

    }

    public void DELETE(View view) {
        db.cleardata();
    }

    public void BUYA(View view) {
        editor = sharedPreferences.edit();
        if (sharedPreferences.getString("username", "").equals("")) {

            Intent i = new Intent(Cartrecycle.this, Login.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "YOUR LOGIN page is ready", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "already login", Toast.LENGTH_SHORT).show();
        }
    }

}
