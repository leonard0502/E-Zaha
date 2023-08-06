package com.site.madagascartourisme.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.site.madagascartourisme.R;
import com.site.madagascartourisme.controller.BaseController;
import com.site.madagascartourisme.model.EvenementModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailEvenement extends AppCompatActivity {

    LinearLayout eventLinearLayout;
    String idEvenement;
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
        setContentView(R.layout.activity_detail_evenement);

        baseController = new BaseController();

        String idEvenement = getIntent().getStringExtra("idEvenement");
        this.setIdEvenement(idEvenement);

        DetailEvenement.this.set_detail_evenement(idEvenement);
    }

    private void set_detail_evenement(String idEvenement) {
        Call<List<JsonObject>> call = baseController.getRetofitInterface().getEvenementById(idEvenement);
        call.enqueue(new Callback<List<JsonObject>>() {
            @Override
            public void onResponse(Call<List<JsonObject>> call, Response<List<JsonObject>> response) {
                if (response.isSuccessful()) {
                    List<JsonObject> evenementListJson = response.body();
                    JsonObject jsonEvent = evenementListJson.get(0);
                    EvenementModel evenement = new EvenementModel(jsonEvent);

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

                    eventLinearLayout.addView(eventView);
                } else {
                    Toast.makeText(DetailEvenement.this, "Erreur lors du chargement des données", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<JsonObject>> call, Throwable t) {
                Toast.makeText(DetailEvenement.this, "Erreur de réseau", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), Evenement.class);
        startActivity(intent);
        finish();
    }


//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id) {
//            case R.id.notification:
//                // Action à exécuter pour l'option 1
//                return true;
//
//            case R.id.recherche:
//                // Action à exécuter pour l'option 2
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    public String getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(String idEvenement) {
        this.idEvenement = idEvenement;
    }

}