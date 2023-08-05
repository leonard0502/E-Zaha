package com.site.tourismemadagascar.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.site.tourismemadagascar.R;
import com.site.tourismemadagascar.controller.BaseController;
import com.site.tourismemadagascar.model.UtilisateurModel;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    TextInputEditText nom, prenom, date_naissance, numero, mail, mdp, idRegion;
    BaseController baseController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
                UtilisateurModel utilisateurModel = new UtilisateurModel(Register.this);
                HashMap<String, String> map = utilisateurModel.getMapRegister();

                Intent intent = new Intent(getApplicationContext(), ListeEvenement.class);
                startActivity(intent);
                finish();

//                baseController = new BaseController();
//                Call<Void> call = baseController.getRetofitInterface().executeSignUp(map);
//                call.enqueue(new Callback<Void>() {
//                    @Override
//                    public void onResponse(Call<Void> call, Response<Void> response) {
//                        Intent intent = new Intent(getApplicationContext(), Login.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                    @Override
//                    public void onFailure(Call<Void> call, Throwable t) {
//                        Toast.makeText(Register.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });


            }
        });

        findViewById(R.id.loginNow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                Register.this.startActivity(intent);
                Register.this.finish();
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