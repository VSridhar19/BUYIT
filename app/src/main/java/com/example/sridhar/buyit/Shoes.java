package com.example.sridhar.buyit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class Shoes extends AppCompatActivity {
    ImageView i1;
    TextView t1,t2,t3;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);
        recyclerview = (RecyclerView) findViewById(R.id.recycle);
        t1=(TextView)findViewById(R.id.tx1);
        i1=(ImageView)findViewById(R.id.im1);
        t2=(TextView)findViewById(R.id.tx2);
        t3=(TextView)findViewById(R.id.tx3);

        int numberOfColumns=2;
        int[] images1;
        String[] name1;
        String[]names1;
        name1 = new String[]{"₹500","₹600","₹700","₹800","₹900","₹300","₹1200","₹500","₹5990","₹500","₹1500","₹500","₹590","₹500",};
        images1=new int[]{R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,R.drawable.s11,R.drawable.s12,R.drawable.s13,R.drawable.s14,};
        names1 = new String[]{"Rodid Men's Solid Casual shoes","DC Shoes For Men","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes","Rodid Men's Solid Casual shoes",};
        //names2=new String[]{"1","1","1","1","1","1","1","1","1","1","1","1","1","1",};// recyclerview.setLayoutManager(new GridLayoutManager(this,numberOfColumns));
        //recyclerview.setAdapter(new AdapterShoes(this,name1,names1,(int[])images1));
        recyclerview.setLayoutManager(new GridLayoutManager(this,numberOfColumns));
        recyclerview.setAdapter(new AdapterShoes(this,name1,names1,(int[])images1));
       //recyclerview.setAdapter(new AdapterShoes(this,name1,names1,(int[])images1));

    }

}