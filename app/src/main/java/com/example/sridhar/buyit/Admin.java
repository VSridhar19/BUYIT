package com.example.sridhar.buyit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

//import Mainfest.permissions.READ_EXTERAL_STORAGE;

public class Admin extends AppCompatActivity {
    private static final int REQUEST_CODE_GALLERY = 999;
    EditText e1, e2;
    Button b1, b2, b3;
    ImageView im1;
    TextView t1, t2, t3;
    String s, s1, s2;
    public static DatabaseAdmins sqLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Intent i=getIntent();
        s=i.getStringExtra("username");
        s1=i.getStringExtra("password");
        init();
        sqLiteOpenHelper = new DatabaseAdmins(this);
        //sqLiteOpenHelper.queryData("CREATE TEBLE IF NOT EXISTS ITEM(Id INTEGER PRIMARY KEY AUTOINCREMENT,id VARCHAR,name1 VARCHAR, price VARCHAR,images1 BLOG)");
        b1.setOnClickListener(new OnClickListener() {
            public PackageInfo Mainfest;

            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        Admin.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );


            }
        });
        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                   long a= sqLiteOpenHelper.insertData(
                            e1.getText().toString().trim(),
                            e2.getText().toString().trim(),
                            im1ToByte(im1));
                    Toast.makeText(Admin.this, a+" row inserted", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    e.printStackTrace();
                }

                Toast.makeText(Admin.this, "added succesfully", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
                im1.setImageResource(R.mipmap.ic_launcher);

            }
        });
        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Admin.this,ItemList.class);
                intent.putExtra("username",s);
                intent.putExtra("password",s1);
                startActivity(intent);
            }
        });

    }

    private byte[] im1ToByte(ImageView imageView) {
        Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] ByteArray= stream.toByteArray();
        return ByteArray;
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (grantResults.length > 0 && grantResults[0] == getPackageManager().PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE_GALLERY);
        } else {
            Toast.makeText(getApplicationContext(), "you have the permitions ", Toast.LENGTH_SHORT).show();
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                im1.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init() {
        e1 = (EditText) findViewById(R.id.names1);
        e2 = (EditText) findViewById(R.id.prices1);
        b1 = (Button) findViewById(R.id.b14);
        b2 = (Button) findViewById(R.id.b15);
        b3 = (Button) findViewById(R.id.b16);
        im1 = (ImageView) findViewById(R.id.ig1);

    }
}

