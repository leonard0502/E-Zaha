package com.site.tourismemadagascar.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.site.tourismemadagascar.R;
import com.site.tourismemadagascar.model.EvenementModel;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<EvenementModel> {

    public ListAdapter(@NonNull Context context, ArrayList<EvenementModel> list_evenement) {
        super(context, R.layout.activity_list_evenement, list_evenement);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        EvenementModel evenementModel = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_evenement, parent, false);
        }
        ImageView detailImage = view.findViewById(R.id.detailImage);
        TextView nom_site = view.findViewById(R.id.nom_site);
        TextView date_OF = view.findViewById(R.id.date_OF);

        detailImage.setImageResource(evenementModel.getImageInt());
        nom_site.setText(evenementModel.getIdSite());
        date_OF.setText(evenementModel.getDescription());

        return view;
    }
}
