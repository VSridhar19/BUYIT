package com.example.sridhar.buyit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class Laptops extends AppCompatActivity {
    ImageView i1;
    TextView t1, t2;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptops);
        recyclerview = (RecyclerView) findViewById(R.id.recycle);
        t1 = (TextView) findViewById(R.id.tx1);
        i1 = (ImageView) findViewById(R.id.im1);
        t2 = (TextView) findViewById(R.id.tx2);

        int numberOfColumns = 2;
        int[] images1;
        String[] name1;
        String[] names1;
        name1 = new String[]{"₹50000", "₹60000", "₹57000", "₹48800", "₹93000", "₹56300", "₹61200", "₹44500", "₹56990", "₹45500", "₹61500", "₹56500", "₹49590", "₹57600",};
        images1 = new int[]{R.drawable.ll1, R.drawable.ll2, R.drawable.ll3, R.drawable.ll4, R.drawable.ll5, R.drawable.ll6, R.drawable.ll7, R.drawable.ll8, R.drawable.ll1, R.drawable.ll2, R.drawable.ll6, R.drawable.ll3, R.drawable.ll4, R.drawable.ll8,};
        names1 = new String[]{"HP laptop", "Black brand new lenova laptop", "Red laptop ", "Brand new Dell black laptop", "BRand new Mac", "Red coloured Dell laptop", "Hp laptop", "Full Black laptop", "Dell laptop", "Lenovo Black", "Red Dell", "Multicoloured laptop", "Dell brand new", "full black hp laptop", "LENOVO new version laptop", "Dell laptop", "", "HP new", "DELL brand new"};
        // recyclerview.setLayoutManager(new GridLayoutManager(this,numberOfColumns));
        //recyclerview.setAdapter(new AdapterShoes(this,name1,names1,(int[])images1));
        recyclerview.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerview.setAdapter(new AdapterLaptops(this, name1, names1, (int[]) images1));
        //recyclerview.setAdapter(new AdapterShoes(this,name1,names1,(int[])images1));

    }

}
