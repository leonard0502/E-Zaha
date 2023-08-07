package com.site.madagascartourisme.helper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.site.madagascartourisme.model.RegionModel;

import java.util.List;

public class RegionAdapter extends ArrayAdapter<RegionModel> {

    public RegionAdapter(Context context, List<RegionModel> regions) {
        super(context, android.R.layout.simple_spinner_item, regions);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView textView = view.findViewById(android.R.id.text1);
        RegionModel region = getItem(position);
        if (region != null) {
            textView.setText(region.getNom());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView textView = view.findViewById(android.R.id.text1);
        RegionModel region = getItem(position);
        if (region != null) {
            textView.setText(region.getNom());
        }
        return view;
    }
}

