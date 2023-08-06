package com.site.madagascartourisme.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.ViewModelProvider;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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

public class ListeEvenement extends AppCompatActivity {

    private ProgressBar progressBar;
    private BaseController baseController;
    private Call<JsonObject> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_evenement);

        progressBar = findViewById(R.id.progressBar);

        Intent intent = new Intent(getApplicationContext(), Evenement.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (call != null) {
            call.cancel();
        }
        progressBar.setVisibility(View.GONE);
    }


}
