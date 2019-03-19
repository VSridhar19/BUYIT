package com.example.sridhar.buyit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText n1, p1, p2, m1, ph1;
    Button b3;
    private View view;
    DatabaseRegister sqld = new DatabaseRegister(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        n1 = (EditText) findViewById(R.id.n1);
        p1 = (EditText) findViewById(R.id.p1);
        p2 = (EditText) findViewById(R.id.p2);
        m1 = (EditText) findViewById(R.id.m1);
        ph1 = (EditText) findViewById(R.id.ph1);
        b3 = (Button) findViewById(R.id.b3);
        sqld = new DatabaseRegister(this);
    }
        public void username(View view) {
        final String Name=n1.getText().toString();

        final String word=n1.getText().toString();

        if(Name.length()==0)

        {
            n1.requestFocus();
            n1.setError("FIELD CANNOT BE EMPTY");
        }

        else if(!Name.matches("[a-zA-Z ]+"))
        {
            n1.requestFocus();
            n1.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }

        else if(word.length()==0)
        {
            n1.requestFocus();
            n1.setError("FIELD CANNOT BE EMPTY");
        }
    }

    public void pass(View view) {
        final String Name=p1.getText().toString();

        final String word=p1.getText().toString();

        if(Name.length()==0)

        {
            p1.requestFocus();
            p1.setError("FIELD CANNOT BE EMPTY");
        }

        else if("[a-zA-Z ]+".matches(Name))
        {
            p1.requestFocus();
            p1.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }

        else if(word.length()==0)
        {
            p1.requestFocus();
            p1.setError("FIELD CANNOT BE EMPTY");
        }
        else
        {
            Toast.makeText(Registration.this,"Validation Successful",Toast.LENGTH_LONG).show();
        }
    }

    public void Register(View view) {
        String register_id = n1.getText().toString();
        String password = p1.getText().toString();
        String conform_password = p2.getText().toString();
        String email = m1.getText().toString();
        String phonno = ph1.getText().toString();
        if (register_id.length() == 0 || password.length() == 0 || conform_password.length() == 0 || email.length() == 0 || phonno.length() == 0) {
            Toast.makeText(this, "plzz insert values", Toast.LENGTH_SHORT).show();
        } else {
            long a = sqld.insertdata(register_id, password, conform_password, email, phonno);
            if (a > 0) {
                Toast.makeText(this, "inserted data successfully", Toast.LENGTH_SHORT).show();
                Intent Register = new Intent(Registration.this, Login.class);
                startActivity(Register);

            } else {
                Toast.makeText(this, "Not inserted data", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void display(View view) {
        sqld.display();

    }
}
 /*   String u,p;
        u=ui1.getText().toString();
                p=ps1.getText().toString();
                if(u.length()==0||p.length()==0){
                Toast.makeText(this, "insert", Toast.LENGTH_SHORT).show();
                }
                else
                {
                db.login(u,p);
                */



