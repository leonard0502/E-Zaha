package com.site.tourismemadagascar.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.site.tourismemadagascar.R;
import com.site.tourismemadagascar.helper.ListAdapter;
import com.site.tourismemadagascar.model.EvenementModel;

import java.util.ArrayList;

public class ListeEvenement extends AppCompatActivity {

    ListAdapter listAdapter;
    ArrayList<EvenementModel> data_list_evenement = new ArrayList<>();
    EvenementModel evenementModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_evenement);

        ListView listViewEvent = findViewById(R.id.listView);

        int[] imageInt = {R.drawable.baobab, R.drawable.coco, R.drawable.plage};
//        int[] nom_site = {R.string.nom, R.string.nom, R.string.nom};
//        int[] time = {R.string.date_naissance, R.string.date_naissance, R.string.date_naissance}

        String[] nom_site = {"Site 1", "Site2", "Site 2"};
        String[] date_OF = {"01 - 02", "04 - 06", "01 - 09"};

        for (int i = 0; i<nom_site.length; i++) {
            EvenementModel event = new EvenementModel();
            event.setIdSite(nom_site[i]);
            event.setDescription(date_OF[i]);
            event.setImageInt(imageInt[i]);
            data_list_evenement.add(event);
        }

        listAdapter = new ListAdapter( ListeEvenement.this, data_list_evenement);
        listViewEvent.setAdapter(listAdapter);
        listViewEvent.setClickable(true);

        listViewEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListeEvenement.this, DetailEvenement.class);
                intent.putExtra("detailImage", imageInt[i]);
                intent.putExtra("nom_site", nom_site[i]);
                intent.putExtra("date_OF", date_OF[i]);
                startActivity(intent);
            }
        });
    }

}