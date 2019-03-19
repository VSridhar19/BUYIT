package com.example.sridhar.buyit;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Sridhar on 20-04-2018.
 */

public class Adapteritems extends BaseAdapter {
    private Context context;
    private  int layout;
    private ArrayList<ITEM> itemLists;
    private int Position;

    public Adapteritems(Context context,int layout,ArrayList<ITEM> itemList){
        this.context =context;
        this.itemLists=itemList;
        this.layout=layout;

    }
    @Override
    public int getCount() {
        return itemLists.size();
    }


    @Override
    public Object getItem(int position) {
        return itemLists.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder{
        ImageView imageView;
        TextView textname;
        TextView textprice;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row=view;
        ViewHolder holder =new ViewHolder();
        if(row==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.textname = (TextView) row.findViewById(R.id.t11);
            holder.textprice = (TextView) row.findViewById(R.id.t12);
            holder.imageView = (ImageView) row.findViewById(R.id.img11);
            row.setTag(holder);
        }
        else {
            holder=(ViewHolder)row.getTag();
        }
        ITEM item =itemLists.get(Position);
        holder.textname.setText(item.getName1());
        holder.textprice.setText(item.getPrice());
        byte[] itemImages=item.getImages1();
        Bitmap bitmap = BitmapFactory.decodeByteArray(itemImages,0,itemImages.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }
}
