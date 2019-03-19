package com.example.sridhar.buyit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    private RadioGroup radioGroup;
    TextView t1;
    RadioGroup rb;
    String s,ap;
    RadioButton r1, r2, r3, r4, r5;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        button = (Button) findViewById(R.id.b2);
        t1 = (TextView) findViewById(R.id.d1);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        Intent i1 = getIntent();

            s = i1.getStringExtra("price");


            t1.setText(s);


        radioGroup = (RadioGroup) findViewById(R.id.Rg1);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) group.findViewById(R.id.r1);
                checkedId = 1;
                if (null != rb && checkedId > -1) {
                    Toast.makeText(Payment.this, rb.getId(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void buy(View view) {
        if (r1.isChecked()) {
            Intent i1 = new Intent(this, Phonpie.class);
            i1.putExtra("price",s);
            startActivity(i1);
        }
    }
}
