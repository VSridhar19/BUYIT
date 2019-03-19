package com.example.sridhar.buyit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sridhar on 18-04-2018.
 */

public class Adaptercart extends RecyclerView.Adapter<Adaptercart.Viewholder> {
    Context ct;
DatabaseRegister bd;
    String[] name,names;
    int[] images;

    public Adaptercart(Context mainActivity,DatabaseRegister db) {
        this.ct = mainActivity;
        this.bd=db;
        this.images=images;
        this.names=names;
        this.name=name;

    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, final int position) {

        final List<CARD_ITEM> card_item=bd.getnameposition();
        holder.t1.setText(card_item.get(position).getName1());
        holder.t2.setText(card_item.get(position).getPrice());
        byte[] itemImages=card_item.get(position).getImages1();
        Bitmap bitmap = BitmapFactory.decodeByteArray(itemImages,0,itemImages.length);
        holder.img1.setImageBitmap(bitmap);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(ct);
                builder.setTitle("Deleting");
                builder.setMessage("Delete this item from cart?");
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }
                );
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        bd.deletefromcart(card_item.get(position).getName1());
                        ct.startActivity(new Intent(ct,Cartrecycle.class));

                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (int)bd.count() ;
    }


   public class Viewholder extends RecyclerView.ViewHolder {
        Button b1, b2;
        TextView t1, t2;
        ImageView img1;
        Context ct;
        LinearLayout linearLayout;

        public Viewholder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.t11);
            t2 = (TextView) itemView.findViewById(R.id.t12);
            img1 = (ImageView) itemView.findViewById(R.id.img11);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.linear);

        }
    }

}