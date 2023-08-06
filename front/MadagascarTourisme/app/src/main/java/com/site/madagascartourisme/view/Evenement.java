package com.site.madagascartourisme.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.site.madagascartourisme.R;
import com.site.madagascartourisme.controller.BaseController;
import com.site.madagascartourisme.model.EvenementModel;
import com.site.madagascartourisme.model.EventViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Evenement extends AppCompatActivity {

    LinearLayout eventLinearLayout;
    BaseController baseController;

    @Override
    protected void onStart() {
        super.onStart();
        eventLinearLayout = findViewById(R.id.eventLinearLayout);
        eventLinearLayout.removeAllViews();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);

        baseController = new BaseController();

        loadDataFromWebService();
    }

    private void loadDataFromWebService() {
        Call<List<JsonObject>> call = baseController.getRetofitInterface().getEvenement();
        call.enqueue(new Callback<List<JsonObject>>() {
            @Override
            public void onResponse(Call<List<JsonObject>> call, Response<List<JsonObject>> response) {
                if (response.isSuccessful()) {

                    List<JsonObject> evenementListJson = response.body();
                    for (JsonObject evenementJson : evenementListJson) {

                        EvenementModel evenement = new EvenementModel(evenementJson);

                        View eventView = getLayoutInflater().inflate(R.layout.activity_evenement, null);

                        TextView description_evenementTextView = eventView.findViewById(R.id.description_evenement);
                        description_evenementTextView.setText(evenement.getDescription());

                        TextView nomTextView = eventView.findViewById(R.id.nom);
                        nomTextView.setText(evenement.getSite().getNom());

                        TextView date_OFTextView = eventView.findViewById(R.id.date_OF);
                        date_OFTextView.setText(evenement.getDebut().toString() + " - " + evenement.getFin().toString());

                        TextView description_siteTextView = eventView.findViewById(R.id.description_site);
                        description_siteTextView.setText(evenement.getSite().getDescription());

                        TextView activiteTextView = eventView.findViewById(R.id.activite);
                        activiteTextView.setText(evenement.getSite().getActivite());

                        CardView eventCardView = eventView.findViewById(R.id.eventCardView);

                        eventCardView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(Evenement.this, DetailEvenement.class);
                                intent.putExtra("idEvenement", evenement.get_id());
                                startActivity(intent);
                            }
                        });

                        eventLinearLayout.addView(eventView);

                    }

                } else {
                    Toast.makeText(Evenement.this, "Erreur lors du chargement des données", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<JsonObject>> call, Throwable t) {
                Toast.makeText(Evenement.this, "Erreur de réseau", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();
    }
}