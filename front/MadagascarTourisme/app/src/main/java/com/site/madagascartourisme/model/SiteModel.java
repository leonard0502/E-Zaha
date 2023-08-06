package com.site.madagascartourisme.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SiteModel extends BaseModel implements Parcelable {

    String nom,description,activite;
    RegionModel region;
    Date ouvert,fermer;

    public SiteModel(JsonObject siteJson) {
        if (siteJson.has("_id")) {
            this.set_id(siteJson.get("_id").getAsString());
        }
        if (siteJson.has("nom")) {
            this.setNom(siteJson.get("nom").getAsString());
        }
        if (siteJson.has("description")) {
            this.setDescription(siteJson.get("description").getAsString());
        }
        if (siteJson.has("activite")) {
            this.setActivite(siteJson.get("activite").getAsString());
        }
        if (siteJson.has("idRegion")) {
            JsonElement regionElement = siteJson.get("idRegion");
            if (regionElement.isJsonObject()) {
                JsonObject regionJson = regionElement.getAsJsonObject();
                RegionModel regionModel = new RegionModel(regionJson);
                this.setRegion(regionModel);
            }
        }
        if (siteJson.has("ouvert")) {
            String dateString = siteJson.get("ouvert").getAsString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date ouvertDate = dateFormat.parse(dateString);
                this.setOuvert(ouvertDate);
            } catch (ParseException e) {

            }
        }
        if (siteJson.has("fermer")) {
            String dateString = siteJson.get("fermer").getAsString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fermerDate = dateFormat.parse(dateString);
                this.setFermer(fermerDate);
            } catch (ParseException e) {

            }
        }
    }

    public void afficherSiteDansConsole() {
        Log.d("SiteModel", "Nom: " + this.getNom());
        Log.d("SiteModel", "Description: " + this.getDescription());
        Log.d("SiteModel", "Activité: " + this.getActivite());
//        Log.d("SiteModel", "Région: " + this.getRegion().getNom());
        Log.d("SiteModel", "Ouvert: " + this.getOuvert().toString());
        Log.d("SiteModel", "Fermé: " + this.getFermer().toString());
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public Date getOuvert() {
        return ouvert;
    }

    public void setOuvert(Date ouvert) {
        this.ouvert = ouvert;
    }

    public Date getFermer() {
        return fermer;
    }

    public void setFermer(Date fermer) {
        this.fermer = fermer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

    }
}
