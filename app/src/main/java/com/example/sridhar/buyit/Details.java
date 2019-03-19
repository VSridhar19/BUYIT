package com.example.sridhar.buyit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
    TextView t1,t2;
    ImageView i1;
    Button b,b1;
    String s,s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t1=(TextView)findViewById(R.id.details1);
        t2=(TextView)findViewById(R.id.details2);
        i1=(ImageView) findViewById(R.id.details01);
        b=(Button)findViewById(R.id.b1);
        b1=(Button)findViewById(R.id.b2);
        Intent i=getIntent();
        String s=i.getStringExtra("name");
       String s1 = i.getStringExtra("names");
        int img=i.getIntExtra("image",0);
        t1.setText(s);
        t2.setText(s1);
        Picasso.with(this).load(img).into(i1);
    }

    public void add(View view) {
        Intent i = new Intent(Details.this, Login.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "First you have to LOGIN", Toast.LENGTH_SHORT).show();
    }

    public void buy(View view) {
        Intent i = new Intent(Details.this, Login.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "First you have to LOGIN", Toast.LENGTH_SHORT).show();
    }
}
