package com.example.sridhar.buyit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Logout extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        button = (Button) findViewById(R.id.ba1);
        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);

    }

    public void logout(View view) {
        Intent i = new Intent(Logout.this, MainActivity.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "Welcome to Registrtion page", Toast.LENGTH_SHORT).show();
        editor=sharedPreferences.edit();
        editor.remove("username");
        //editor.remove("password");
        editor.commit();
    }
}