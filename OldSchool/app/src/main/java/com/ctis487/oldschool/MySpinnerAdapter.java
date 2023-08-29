package com.ctis487.oldschool;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MySpinnerAdapter  extends ArrayAdapter<Rapper> {
    private Context context;
    private int layoutResourceId;
    private LayoutInflater inflator;
    private ArrayList<Rapper> spinnerItemValues;

    public MySpinnerAdapter(Context context, int resource,  List values) {
        super(context, resource, values);
        this.context = context;
        this.layoutResourceId = resource;
        spinnerItemValues = (ArrayList<Rapper>) values;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getView(int position, View convertView,  ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position,  View convertView,  ViewGroup parent) {
        inflator =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflator.inflate(layoutResourceId,parent,false);

        ConstraintLayout itemLayout = rowView.findViewById(R.id.itemsLayout);
        TextView rapperSpinnerStageName = rowView.findViewById(R.id.rapperSpinnerStageName);
        ImageView rapperLeftImage = rowView.findViewById(R.id.rapperLeftImage);


        Rapper item = spinnerItemValues.get(position);
        rapperSpinnerStageName.setText(item.getStageName());
        rapperLeftImage.setImageResource(item.getImageId());
        return rowView;
    }
}