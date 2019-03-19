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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sridhar on 21-04-2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.Myholder> {
    TextView t1,t2;
    DatabaseAdmins db;
    String s,s1;
    Context ct;
    ArrayList<ITEM> items;
    public ItemsAdapter(ItemList itemList, ArrayList<ITEM> list, String s, String s1) {
        this.ct = itemList;
        this.items = list;
        this.s = s;
        this.s1 = s1;



    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        db=new DatabaseAdmins(ct);
        return new Myholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(Myholder holder, final int position) {
        final ITEM item = items.get(position);
        holder.textname.setText(item.getName1());
        holder.textprice.setText(item.getPrice());
        final byte[] itemImages = item.getImages1();
        Bitmap bitmap = BitmapFactory.decodeByteArray(itemImages, 0, itemImages.length);
        holder.imageView.setImageBitmap(bitmap);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (s.equals("admin") && s1.equals("admin")) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                        builder.setTitle("Deleting");
                        builder.setMessage("Delete this item from Admin page??");
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
                                db.deletefromitems(item.getName1());
                                //db.deletefromitems(item.get(position).getName1());
                                ct.startActivity(new Intent(ct, ItemsAdapter.class));

                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }

                }
                catch (Exception e)
                {
                    Intent i=new Intent(ct,Details1.class);
                    Toast.makeText(ct, "hlooo", Toast.LENGTH_SHORT).show();

                    i.putExtra("an",item.getName1());
                    i.putExtra("ai",item.getImages1());
                    i.putExtra("ap",item.getPrice());
                    ct.startActivity(i);
                }


            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView textname, textprice;
        ImageView imageView;
        LinearLayout linearLayout;

        public Myholder(final View itemView) {
            super(itemView);
            textname = (TextView) itemView.findViewById(R.id.t11);
            textprice = (TextView) itemView.findViewById(R.id.t12);
            imageView = (ImageView) itemView.findViewById(R.id.img11);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear);


        }
    }


}