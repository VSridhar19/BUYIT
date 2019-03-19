package com.example.sridhar.buyit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class Watches extends AppCompatActivity {
    ImageView i1;
    TextView t1,t2;
    RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watches);
        recyclerview = (RecyclerView) findViewById(R.id.recycle);
        t1=(TextView)findViewById(R.id.tx1);
        i1=(ImageView)findViewById(R.id.im1);
        t2=(TextView)findViewById(R.id.tx2);

        int numberOfColumns=2;
        int[] images1;
        String[] name1;
        String[]names1;
        name1 = new String[]{"₹500","₹600","₹700","₹800","₹900","₹300","₹1200","₹500","₹5990","₹500","₹1500","₹500","₹590","₹500",};
        images1=new int[]{R.drawable.z1,R.drawable.z2,R.drawable.z3,R.drawable.z4,R.drawable.z5,R.drawable.z6,R.drawable.z7,R.drawable.z8,R.drawable.z9,R.drawable.z10,R.drawable.z11,R.drawable.z12,R.drawable.z13,R.drawable.z14,};
        names1 = new String[]{"Rodid Men's Solid Casual", "orange TShirt","DC Sneakers For Men","FTC FASHIONS boys Festive & Party Ware","Rodid Men's Solid Casual", "orange TShirt","DC Sneakers For Men","FTC FASHIONS boys Festive & Party Ware","Rodid Men's Solid Casual", "orange TShirt","DC Sneakers For Men","FTC FASHIONS boys Festive & Party Ware","Rodid Men's Solid Casual", "orange TShirt","DC Sneakers For Men","FTC FASHIONS boys Festive & Party Ware","Rodid Men's Solid Casual", "orange TShirt","DC Sneakers For Men"};
        // recyclerview.setLayoutManager(new GridLayoutManager(this,numberOfColumns));
        //recyclerview.setAdapter(new AdapterShoes(this,name1,names1,(int[])images1));
        recyclerview.setLayoutManager(new GridLayoutManager(this,numberOfColumns));
        recyclerview.setAdapter(new AdapterWatches(this,name1,names1,(int[])images1));
        //recyclerview.setAdapter(new AdapterShoes(this,name1,names1,(int[])images1));

    }

}