package com.site.tourismemadagascar.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.site.tourismemadagascar.R;
import com.site.tourismemadagascar.controller.BaseController;
import com.site.tourismemadagascar.model.UtilisateurModel;

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

                Log.d("RequestData", map.toString());
                baseController = new BaseController();
                Call<Login> call = baseController.getRetofitInterface().executeLogin(map);
                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {

                    }
                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


        findViewById(R.id.registerNow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                Login.this.startActivity(intent);
                Login.this.finish();
            }
        });

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