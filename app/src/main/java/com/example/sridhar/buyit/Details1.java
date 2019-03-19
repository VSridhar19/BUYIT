package com.example.sridhar.buyit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

public class Details1 extends AppCompatActivity {
    TextView t1, t2, t3;
    ImageView i1;
    Button b, b1;
    String s, s1, s2, an, ap;
    byte[] ai;
    Bitmap bitmap;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    DatabaseRegister sqld = new DatabaseRegister(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t1 = (TextView) findViewById(R.id.details1);
        t2 = (TextView) findViewById(R.id.details2);
        t3 = (TextView) findViewById(R.id.details3);
        i1 = (ImageView) findViewById(R.id.details01);
        b = (Button) findViewById(R.id.b1);
        b1 = (Button) findViewById(R.id.b2);
        sqld = new DatabaseRegister(this);
        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        Intent i = getIntent();


        try {
            s = i.getStringExtra("name");
            s1 = i.getStringExtra("names");
            s2 = i.getStringExtra("");
            int img = i.getIntExtra("image", 0);
            Picasso.with(this).load(img).into(i1);
            t1.setText(s);
            t2.setText(s1);
            t3.setText(s2);

        } catch (Exception e) {
            an = i.getStringExtra("an");
            ap = i.getStringExtra("ap");
            ai = i.getByteArrayExtra("ai");

            Bitmap bitmap = BitmapFactory.decodeByteArray(ai, 0, ai.length);

            i1.setImageBitmap(bitmap);
            t1.setText(an);
            t2.setText(ap);
            t3.setText(s2);


        }
    }

    public void add(View view) {
        editor = sharedPreferences.edit();
     /*   t1 = (TextView) findViewById(R.id.details1);
        t2 = (TextView) findViewById(R.id.details2);
        t3 = (TextView) findViewById(R.id.details3);
        i1 = (ImageView) findViewById(R.id.details01);*/
        String text = t1.getText().toString();
        bitmap = ((BitmapDrawable) i1.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        long a = sqld.insertdata(text, t2.getText().toString(), byteArray);
        Toast.makeText(this, "row:" + a, Toast.LENGTH_SHORT).show();
        b = (Button) findViewById(R.id.b1);
        b1 = (Button) findViewById(R.id.b2);
        sqld = new DatabaseRegister(this);


        sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);


        Intent i = getIntent();
        s = i.getStringExtra("name");
        s1 = i.getStringExtra("names");
        s2 = i.getStringExtra("");
        int img = i.getIntExtra("image", 0);

        // Picasso.with(this).load(img).into(i1);
        if (
                sharedPreferences.getString("username", "").equals("")

                ) {
            Intent i2 = new Intent(Details1.this, Login.class);
            startActivity(i2);
            Toast.makeText(getApplicationContext(), "YOUR LOGIN page is ready", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "already login", Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(Details1.this, Cartrecycle.class);
            i1.putExtra("price", s);
            i1.putExtra("name", s);
            i1.putExtra("names", s1);
            i1.putExtra("image", img);
            startActivity(i1);
        }
    }

    //String text = b.getText().toString();
    //long a = sqld.insertdata(text);
        /*if (a > 0) {
            Toast.makeText(this, "inserted data successfully", Toast.LENGTH_SHORT).show();
            Intent add = new Intent(Details1.this, Cart.class);
            startActivity(add);

        } else {
            Toast.makeText(this, "Not inserted data", Toast.LENGTH_SHORT).show();
        }
*/

    public void display(View view) {
        sqld.display();
    }


    public void buy(View view) {
        editor = sharedPreferences.edit();
        if (
                sharedPreferences.getString("username", "").equals("")

                ) {
            Intent i = new Intent(Details1.this, Login.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "YOUR LOGIN page is ready", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "already login", Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(Details1.this, Payment.class);
            try{
                if(ap.length()!=0)
                i1.putExtra("price",ap);
                else
                    i1.putExtra("price", s);

            }
            catch (Exception e){
                i1.putExtra("price", s);
            }
            startActivity(i1);
        }
    }
}






