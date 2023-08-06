package com.site.madagascartourisme.model;


import com.google.gson.JsonObject;

public class RegionModel extends BaseModel {

    private String nom;

    public RegionModel(JsonObject regionJson) {
        if (regionJson.has("_id")) {
            this.set_id(regionJson.get("_id").getAsString());
        }
        if (regionJson.has("nom")) {
            this.setNom(regionJson.get("nom").getAsString());
        }
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
