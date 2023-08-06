package com.site.madagascartourisme.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.site.madagascartourisme.R;
import com.site.madagascartourisme.controller.BaseController;
import com.site.madagascartourisme.model.UtilisateurModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inscription extends AppCompatActivity {

    TextInputEditText nom, prenom, date_naissance, numero, mail, mdp, idRegion;
    BaseController baseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        date_naissance = findViewById(R.id.date_naissance);
        numero = findViewById(R.id.numero);
        mail = findViewById(R.id.mail);
        mdp = findViewById(R.id.mdp);
        idRegion = findViewById(R.id.idRegion);

        findViewById(R.id.btn_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilisateurModel utilisateurModel = new UtilisateurModel(Inscription.this);
                HashMap<String, String> map = utilisateurModel.getMapRegister();

                baseController = new BaseController();
                Call<Void> call = baseController.getRetofitInterface().executeSignUp(map);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        finish();
                    }
                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(Inscription.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        findViewById(R.id.loginNow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                Inscription.this.startActivity(intent);
                Inscription.this.finish();
            }
        });

    }

    public TextInputEditText getNom() {
        return nom;
    }

    public void setNom(TextInputEditText nom) {
        this.nom = nom;
    }

    public TextInputEditText getPrenom() {
        return prenom;
    }

    public void setPrenom(TextInputEditText prenom) {
        this.prenom = prenom;
    }

    public TextInputEditText getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(TextInputEditText date_naissance) {
        this.date_naissance = date_naissance;
    }

    public TextInputEditText getNumero() {
        return numero;
    }

    public void setNumero(TextInputEditText numero) {
        this.numero = numero;
    }

    public TextInputEditText getMail() {
        return mail;
    }

    public void setMail(TextInputEditText mail) {
        this.mail = mail;
    }

    public TextInputEditText getMdp() {
        return mdp;
    }

    public void setMdp(TextInputEditText mdp) {
        this.mdp = mdp;
    }

    public TextInputEditText getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(TextInputEditText idRegion) {
        this.idRegion = idRegion;
    }
}