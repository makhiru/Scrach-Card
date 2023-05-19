package com.example.scrachcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Stack_Adapter extends BaseAdapter {

    ArrayList<Model> arrmodel;
    Context context;

    public Stack_Adapter(ArrayList<Model> arrmodel, Context context) {
        this.arrmodel = arrmodel;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrmodel.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stackitem_layout, parent, false);

        TextView txt = convertView.findViewById(R.id.text);
        ImageView img = convertView.findViewById(R.id.imageview);

        System.out.println(String.valueOf(arrmodel.size()));

        txt.setText(arrmodel.get(position).getSkim());
        img.setImageResource(arrmodel.get(position).getImage());

        return convertView;
    }
}
