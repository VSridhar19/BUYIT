package com.example.sridhar.buyit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sridhar on 16-03-2018.
 */

class Myadapter1 extends RecyclerView.Adapter<Myadapter1.Viewholder> {
    String[] name,names;
    int[] images;
    Context ct;
    public Myadapter1(MainActivity mainActivity, String[] names, String[] name, int[] images) {
        this.name=name;

        this.ct=mainActivity;
        this.images=images;
        this.names=names;

    }

    public Myadapter1(Recyclerview recyclerview, String[] data) {
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.main,parent,false);
        return new Myadapter1.Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
       holder.t1.setText(name[position]);
        holder.t2.setText(names[position]);
        holder.i1.setImageResource(images[position]);
    }



    @Override
    public int getItemCount() {
        return name.length;
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView t1,t2;
        ImageView i1;
        public Viewholder(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.t11);
            i1=(ImageView)itemView.findViewById(R.id.i11);
            t2=(TextView)itemView.findViewById(R.id.t12);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if(position==0){
                        Intent intent=new Intent(ct,Recyclerview.class);
                        intent.putExtra("name",name[position]);
                        intent.putExtra("names",names[position]);
                        intent.putExtra("image",images[position]);
                        ct.startActivity(intent);
                    }
                    if(position==1){
                        Intent intent=new Intent(ct,Shoes.class);
                        intent.putExtra("name",name[position]);
                        intent.putExtra("names",names[position]);
                        intent.putExtra("image",images[position]);
                        ct.startActivity(intent);
                    }
                    if(position==2){
                        Intent intent=new Intent(ct,Drasses.class);
                        intent.putExtra("name",name[position]);
                        intent.putExtra("names",names[position]);
                        intent.putExtra("image",images[position]);
                        ct.startActivity(intent);


                    }
                    if(position==3){
                        Intent intent=new Intent(ct,Phons.class);
                        intent.putExtra("name",name[position]);
                        intent.putExtra("names",names[position]);
                        intent.putExtra("image",images[position]);
                        ct.startActivity(intent);
                    }
                    if(position==4){
                        Intent intent=new Intent(ct,Watches.class);
                        intent.putExtra("name",name[position]);
                        intent.putExtra("names",names[position]);
                        intent.putExtra("image",images[position]);
                        ct.startActivity(intent);
                    }
                    if(position==5) {
                        Intent intent = new Intent(ct, Laptops.class);
                        intent.putExtra("name", name[position]);
                        intent.putExtra("names", names[position]);
                        intent.putExtra("image", images[position]);
                        ct.startActivity(intent);
                    }

                }
            });
        }
    }

}