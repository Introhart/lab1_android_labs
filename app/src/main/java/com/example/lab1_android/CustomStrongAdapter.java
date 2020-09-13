package com.example.lab1_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomStrongAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HeavyItem> HeavyItems;

    public CustomStrongAdapter(Context context, ArrayList<HeavyItem> HeavyItems){
        this.context = context;
        this.HeavyItems = HeavyItems;
    }

    @Override
    public int getCount() {
        return HeavyItems.size();
    }

    @Override
    public Object getItem(int i) {
        return HeavyItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(context).inflate(
                    R.layout.list_raw, viewGroup, false);
        }

        HeavyItem currentItem = (HeavyItem)getItem(i);

        TextView textViewItemName = (TextView)
                view.findViewById(R.id.text_view_item_name);
        String data = String.valueOf(currentItem.getOp1()) + " " + String.valueOf(currentItem.getOperation()) +
                " " + String.valueOf(currentItem.getOp2()) + " = " + String.valueOf(currentItem.getResult());

        textViewItemName.setText(data);

        return view;
    }


}

//


