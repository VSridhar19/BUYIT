package com.example.sridhar.buyit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sridhar on 05-03-2018.
 */

class Myadapter extends RecyclerView.Adapter<Myadapter.Viewholder> {

    String[] name,names;
    int[] images;
    Context ct;

    public Myadapter(Recyclerview mainActivity, String[] name, String[] names, int[] images) {
        this.name=name;
        this.ct=mainActivity;
        this.images=images;
        this.names=names;

    }



    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new Viewholder(v);
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
            t2=(TextView)itemView.findViewById(R.id.t12);
            i1=(ImageView)itemView.findViewById(R.id.img11);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    Intent intent=new Intent(ct,Details1.class);
                    intent.putExtra("name",name[position]);
                    intent.putExtra("names",names[position]);
                    intent.putExtra("image",images[position]);
                    ct.startActivity(intent);
                }
            });
        }
    }

}
