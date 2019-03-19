package com.example.sridhar.buyit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class
Phons extends AppCompatActivity {
    ImageView i1;
    TextView t1,t2;
    RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phons);
        recyclerview = (RecyclerView) findViewById(R.id.recycle);
        t1=(TextView)findViewById(R.id.tx1);
        i1=(ImageView)findViewById(R.id.im1);
        t2=(TextView)findViewById(R.id.tx2);

        int numberOfColumns=2;
        int[] images1;
        String[] name1;
        String[]names1;
        name1 = new String[]{"₹500","₹600","₹700","₹800","₹900","₹300","₹1200","₹500","₹5990","₹500","₹1500","₹500","₹590","₹500",};
        images1=new int[]{R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14,};
        names1 = new String[]{"Samsung Galaxy On Nxt (Black, 16 GB)","Samsung Galaxy On Nxt (White, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)","Samsung Galaxy On Nxt (Gold, 16 GB)",};
        recyclerview.setLayoutManager(new GridLayoutManager(this,numberOfColumns));
        recyclerview.setAdapter(new AdapterPhons(this,name1,names1,(int[])images1));
        //recyclerview.setAdapter(new AdapterShoes(this,name1,names1,(int[])images1));
    }
}
