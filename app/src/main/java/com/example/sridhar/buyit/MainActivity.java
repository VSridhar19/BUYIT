package com.example.sridhar.buyit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.design.internal.NavigationMenu;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.sridhar.buyit.R.string.navigation_drawer_close;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView) findViewById(R.id.recycle);
        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        Object string;
        drawerLayout = (DrawerLayout) findViewById(R.id.d1);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int numberOfColumns = 2;
        int[] images;
        String[] name;
        String[] names;

        name = new String[]{"₹1300", "₹3100", "₹900", "₹13000", "₹3000", "₹3900"};
        images = new int[]{R.drawable.z4, R.drawable.s11, R.drawable.d1, R.drawable.c10, R.drawable.l6, R.drawable.l1};
        names = new String[]{"Rodid Men's Solid Casual orange TShirt", "DC Sneakers For Men", "FTC FASHIONS girls Festive & Party Ware", "Samsung Galaxy On Nxt (Gold, 16 GB)  (3 GB RAM", "FASHIONS Watches", "HP Laptop"};

        recyclerview.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerview.setAdapter(new Myadapter1(this, name, names, (int[]) images));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void login(MenuItem item) {
      editor = sharedPreferences.edit();
        if (sharedPreferences.getString("username", "").equals("")) {

            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "YOUR LOGIN page is ready", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "already login", Toast.LENGTH_SHORT).show();
        }
    }


    public void home(MenuItem item) {
        Intent i = new Intent(MainActivity.this, Login.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "YOUR LOGIN page is ready", Toast.LENGTH_SHORT).show();

    }

    public void log(MenuItem item) {
        Intent i = new Intent(MainActivity.this, MainActivity.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "Welcome to Registrtion page", Toast.LENGTH_SHORT).show();
        editor = sharedPreferences.edit();
        editor.remove("username");
        //editor.remove("password");
        editor.commit();
    }



    public void cart(MenuItem item) {
        Intent i = new Intent(MainActivity.this, Cartrecycle.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "YOUR ", Toast.LENGTH_SHORT).show();
    }



    public void items(MenuItem item) {
        Intent i = new Intent(MainActivity.this, ItemList.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "YOUR ", Toast.LENGTH_SHORT).show();

    }
}




