package com.site.madagascartourisme.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;
import com.site.madagascartourisme.R;
import com.site.madagascartourisme.controller.BaseController;
import com.site.madagascartourisme.model.UtilisateurModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextInputEditText mail, mdp;
    BaseController baseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.mail);
        mdp = findViewById(R.id.mdp);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilisateurModel utilisateurModel = new UtilisateurModel(Login.this);
                HashMap<String, String> map = utilisateurModel.getMapLogin();

                baseController = new BaseController();
                Call<JsonObject> call = baseController.getRetofitInterface().executeLogin(map);
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject responseData = response.body();
                            if (responseData != null) {
                                Intent intent = new Intent(getApplicationContext(), Evenement.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login.this, "Response data is null", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Login.this, "Response not successful", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        findViewById(R.id.registerNow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Inscription.class);
                Login.this.startActivity(intent);
                Login.this.finish();
            }
        });
        findViewById(R.id.listEvenement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Evenement.class);
                Login.this.startActivity(intent);
                Login.this.finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), Inscription.class);
        startActivity(intent);
        finish();
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
}