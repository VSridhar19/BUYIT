package com.example.sridhar.buyit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText ui1,ps1;
    TextView t4;

DatabaseRegister db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ui1=(EditText)findViewById(R.id.ui1);
        ps1=(EditText)findViewById(R.id.ps1);

        db=new DatabaseRegister(this);
    }


  /*  public void username(View view) {
        final String Name=ui1.getText().toString();

        final String word=ui1.getText().toString();

        if(Name.length()==0)

        {
            ui1.requestFocus();
            ui1.setError("FIELD CANNOT BE EMPTY");
        }

        else if(!Name.matches("[a-zA-Z ]+"))
        {
            ui1.requestFocus();
            ui1.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }

        else if(word.length()==0)
        {
            ui1.requestFocus();
            ui1.setError("FIELD CANNOT BE EMPTY");
        }
    }

    public void pass(View view) {
        final String Name=ps1.getText().toString();

        final String word=ps1.getText().toString();

        if(Name.length()==0)

        {
            ps1.requestFocus();
            ps1.setError("FIELD CANNOT BE EMPTY");
        }

        else if("[a-zA-Z ]+".matches(Name))
        {
            ps1.requestFocus();
            ps1.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }

        else if(word.length()==0)
        {
            ps1.requestFocus();
            ps1.setError("FIELD CANNOT BE EMPTY");
        }
        else
        {
            Toast.makeText(Login.this,"Validation Successful",Toast.LENGTH_LONG).show();
        }
    }
*/

    public void text(View view) {
        Intent i = new Intent(Login.this, Registration.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "Welcome to Registrtion page", Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {

        String u,p;
        u=ui1.getText().toString();
        p=ps1.getText().toString();
        if(u.length()==0||p.length()==0){

            Toast.makeText(this, "insert", Toast.LENGTH_SHORT).show();
        }
        else if (u.equals("admin")&&p.equals("admin")){
            Intent i=new Intent(Login.this,Admin.class);
            i.putExtra("username",u);
            i.putExtra("password",p);
            startActivity(i);
        }
        else
        {
        db.login(u,p);
    }
    }

    public void check(View view) {
        SharedPreferences sharedPref=getSharedPreferences("Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("username",ui1.getText().toString());
        editor.putString("password",ps1.getText().toString());
        editor.apply();


        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }
}
