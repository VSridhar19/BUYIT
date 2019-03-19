package com.example.sridhar.buyit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/** extends RecyclerView.Adapter<AdapterShoes.Viewholder> {
 * Created by Sridhar on 25-03-2018. public AdapterShoes(Shoes mainActivity, String[] name1, String[] names1, int[] images1) {
 */

public class AdapterPhons extends RecyclerView.Adapter<AdapterPhons.Viewholder> {
    String[] name1, names1;
    int[] images1;
    Context ct;
    public AdapterPhons(Phons mainActivity,String[] name1,String[] names1,int[] images1){
        this.name1=name1;
        this.ct=mainActivity;
        this.images1=images1;
        this.names1=names1;
    }

    @Override
    public AdapterPhons.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Viewholder(v);

    }

    @Override
    public void onBindViewHolder(AdapterPhons.Viewholder holder, int position) {

        holder.t1.setText(name1[position]);
        holder.t2.setText(names1[position]);
        holder.i1.setImageResource(images1[position]);


    }

    @Override
    public int getItemCount() {
        return name1.length;
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView t1, t2;
        ImageView i1;
        public Viewholder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.t11);
            t2 = (TextView) itemView.findViewById(R.id.t12);
            i1 = (ImageView) itemView.findViewById(R.id.img11);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(ct, Details1.class);
                    intent.putExtra("name", name1[position]);
                    intent.putExtra("names", names1[position]);
                    intent.putExtra("image", images1[position]);
                    ct.startActivity(intent);
                }
            });
        }
    }

}