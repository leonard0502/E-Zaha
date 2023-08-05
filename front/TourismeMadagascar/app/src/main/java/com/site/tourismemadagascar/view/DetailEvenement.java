package com.site.tourismemadagascar.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.site.tourismemadagascar.R;

public class DetailEvenement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_evenement);

        Intent intent = this.getIntent();
        if (intent != null) {
            String nom_site = intent.getStringExtra("nom_site");
            String date_OF = intent.getStringExtra("date_OF");
            int detailImage = intent.getIntExtra("detailImage", R.drawable.baobab);

            TextView nomSiteTextView = findViewById(R.id.nom_site);
            TextView dateOFTextView = findViewById(R.id.date_OF);
            ImageView detailImageView = findViewById(R.id.detailImage);

            nomSiteTextView.setText(nom_site);
            dateOFTextView.setText(date_OF);
            detailImageView.setImageResource(detailImage);

        }

    }
}