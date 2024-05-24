package com.example.adapterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {
    private Context context;
    private String[] items;

    public MyCustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    // return the number of items in your data source
    public int getCount() {
        return items.length;
    }

    @Override
    // return s the data item at the given position
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    // the method gets the item id associated with a particular position in the list.
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
    ViewHolder holder;

    if(convertView == null) {
    convertView = LayoutInflater.from(context).inflate(R.layout.my_list_item,parent, false );
    holder = new ViewHolder();
    holder.textView = convertView.findViewById(R.id.customItemList);
    convertView.setTag(holder);
    } else {
        // Reusing the view
        holder = (ViewHolder) convertView.getTag();
    }


    //set the data to the view
    holder.textView.setText(items[i]);

    // binding data to views within the convertView
        return holder.textView; // displays the data at a position in the dataset.
    }

    static class ViewHolder {
        // Holds references to the views within an item layout.
        TextView textView;
    }
}
