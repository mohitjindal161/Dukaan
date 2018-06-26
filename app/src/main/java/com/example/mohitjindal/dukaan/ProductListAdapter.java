package com.example.mohitjindal.dukaan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<ProductItem> {

    private final Context context;
    private final ArrayList<ProductItem> productsArrayList;

    public ProductListAdapter(Context context, ArrayList<ProductItem> productsArrayList) {
        super(context, R.layout.product_item, productsArrayList);
        this.context = context;
        this.productsArrayList = productsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
// 2. Get rowView from inflater
        View rowView = null;
        rowView = inflater.inflate(R.layout.product_item, parent, false);
        // 3. Get icon,title & counter views from the rowView
        ImageView imgView = (ImageView) rowView.findViewById(R.id.product_icon);
        TextView titleView = (TextView) rowView.findViewById(R.id.product_title);
        TextView descView = (TextView) rowView.findViewById(R.id.product_desc);
        TextView priceView = (TextView) rowView.findViewById(R.id.product_price);
        TextView quantityView = (TextView) rowView.findViewById(R.id.quantityNumber);


        imgView.setImageResource(productsArrayList.get(position).getIcon());
        titleView.setText(productsArrayList.get(position).getTitle());
        descView.setText(productsArrayList.get(position).getDescription());
        priceView.setText(productsArrayList.get(position).getPrice());
        //quantityView.setText(productsArrayList.get(position).getQuantity());

        return rowView;
    }
}
