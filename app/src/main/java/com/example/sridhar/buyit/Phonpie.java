package com.example.sridhar.buyit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Phonpie extends AppCompatActivity {
    Button b;
    EditText e,e1;
    TextView t;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonpie);
        b=findViewById(R.id.b);
        e=findViewById(R.id.e1);
        e1=findViewById(R.id.e2);
        t=findViewById(R.id.t1);
        Intent i1=getIntent();
        s=i1.getStringExtra("price");
        t.setText(s);
       // Intent i1 = getIntent();
       // String s = i1.getStringExtra("price");
       // t.setText(s);

    }
}
