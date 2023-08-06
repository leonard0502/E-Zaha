package com.site.madagascartourisme.controller;

import android.util.Log;

import com.site.madagascartourisme.service.RetofitInterface;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseController {
    Retrofit retrofit;
    RetofitInterface retofitInterface;
    String BASE_URL = "https://back-tourisme.onrender.com/";

    public BaseController() {

        Interceptor requestInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Log.d("RequestURL", request.url().toString());

                // Afficher les headers de la requête
//                Headers headers = request.headers();
//                for (String name : headers.names()) {
//                    Log.d("RequestHeader", name + ": " + headers.get(name));
//                }

                // Afficher le corps de la requête (pour les requêtes POST, PUT, etc.)
                if (request.body() != null) {
                    Buffer buffer = new Buffer();
                    request.body().writeTo(buffer);
                    Log.d("RequestBody", buffer.readUtf8());
                }
                return chain.proceed(request);
            }
        };

        // Créez un client OkHttpClient avec l'intercepteur
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build();

        // Utilisez le client httpClient pour effectuer vos appels réseau
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.retofitInterface = this.retrofit.create(RetofitInterface.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public RetofitInterface getRetofitInterface() {
        return retofitInterface;
    }

    public void setRetofitInterface(RetofitInterface retofitInterface) {
        this.retofitInterface = retofitInterface;
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }
}
