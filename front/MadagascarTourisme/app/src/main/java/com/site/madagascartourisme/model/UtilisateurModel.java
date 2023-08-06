package com.site.madagascartourisme.model;

import android.util.Log;

import com.google.gson.JsonObject;
import com.site.madagascartourisme.view.Inscription;
import com.site.madagascartourisme.view.Login;

import java.util.HashMap;

public class UtilisateurModel extends BaseModel {
    Inscription register;
    Login login;
    String nom,prenom,dateDN,numero,mail,mdp, idRegionStr;
    RegionModel region;
    HashMap<String, String> mapUtilisateur;
    JsonObject jsonUtilisateur;
    public UtilisateurModel(Inscription register) {
        this.setRegister(register);
        this.setNom(getRegister().getNom().getText().toString());
        this.setPrenom(getRegister().getPrenom().getText().toString());
        this.setDateDN(getRegister().getDate_naissance().getText().toString());
        this.setNumero(getRegister().getNumero().getText().toString());
        this.setIdRegionStr(getRegister().getIdRegion().getText().toString());
        this.setMail(getRegister().getMail().getText().toString());
        this.setMdp(getRegister().getMdp().getText().toString());
    }

    public UtilisateurModel(HashMap<String, String> mapUtilisateur) {
        this.setNom(mapUtilisateur.get("nom"));
        this.setPrenom(mapUtilisateur.get("prenom"));
        this.setDateDN(mapUtilisateur.get("dateDN"));
        this.setNumero(mapUtilisateur.get("numero"));
        this.setIdRegionStr(mapUtilisateur.get("idRegion"));
        this.setMail(mapUtilisateur.get("mail"));
        this.setMdp(mapUtilisateur.get("mdp"));
        this.mapUtilisateur = mapUtilisateur;
    }

    public UtilisateurModel(JsonObject jsonUtilisateur) {
        if (jsonUtilisateur.has("utilisateur")) {
            JsonObject utilisateurObject = jsonUtilisateur.getAsJsonObject("utilisateur");
            if (utilisateurObject.has("nom")) {
                this.setNom(utilisateurObject.get("nom").getAsString());
            }
            if (utilisateurObject.has("prenom")) {
                this.setPrenom(utilisateurObject.get("prenom").getAsString());
            }
            if (utilisateurObject.has("dateDN")) {
                this.setDateDN(utilisateurObject.get("dateDN").getAsString());
            }
            if (utilisateurObject.has("numero")) {
                this.setNumero(utilisateurObject.get("numero").getAsString());
            }
            if (utilisateurObject.has("idRegion")) {
                JsonObject idRegionObject = utilisateurObject.getAsJsonObject("idRegion");
                RegionModel region = new RegionModel(idRegionObject);
                this.setRegion(region);
                this.setIdRegionStr(getRegion().get_id());
            }
            if (utilisateurObject.has("mail")) {
                this.setMail(utilisateurObject.get("mail").getAsString());
            }
            if (utilisateurObject.has("mdp")) {
                this.setMdp(utilisateurObject.get("mdp").getAsString());
            }
            this.jsonUtilisateur = jsonUtilisateur;
        }
    }




    public UtilisateurModel(Login login) {
        this.setLogin(login);
        this.setMail(getLogin().getMail().getText().toString());
        this.setMdp(getLogin().getMdp().getText().toString());
    }



    public HashMap<String, String> getMapLogin() {
        HashMap<String, String> map = new HashMap<>();
        map.put("mail", getMail());
        map.put("mdp", getMdp());
        return map;
    }

    public HashMap<String, String> getMapRegister() {
        HashMap<String, String> map = new HashMap<>();
        map.put("nom", getNom());
        map.put("prenom", getPrenom());
        map.put("dateDN", getDateDN());
        map.put("numero", getNumero());
        map.put("idRegion", getIdRegionStr());
        map.put("mail", getMail());
        map.put("mdp", getMdp());
        return map;
    }

    public void afficherInformations() {
        Log.d("UtilisateurModel", "Nom: " + getNom());
        Log.d("UtilisateurModel", "Prénom: " + getPrenom());
        Log.d("UtilisateurModel", "Date de naissance: " + getDateDN());
        Log.d("UtilisateurModel", "Numéro: " + getNumero());
//        Log.d("UtilisateurModel", "ID Région: " + getRegion().getNom());
        Log.d("UtilisateurModel", "E-mail: " + getMail());
        Log.d("UtilisateurModel", "Mot de passe: " + getMdp());
    }

    public JsonObject getJsonUtilisateur() {
        return jsonUtilisateur;
    }

    public void setJsonUtilisateur(JsonObject jsonUtilisateur) {
        this.jsonUtilisateur = jsonUtilisateur;
    }

    public HashMap<String, String> getMapUtilisateur() {
        return mapUtilisateur;
    }

    public void setMapUtilisateur(HashMap<String, String> mapUtilisateur) {
        this.mapUtilisateur = mapUtilisateur;
    }

    public Inscription getRegister() {
        return register;
    }

    public void setRegister(Inscription register) {
        this.register = register;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateDN() {
        return dateDN;
    }

    public void setDateDN(String dateDN) {
        this.dateDN = dateDN;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getIdRegionStr() {
        return idRegionStr;
    }

    public void setIdRegionStr(String idRegionStr) {
        this.idRegionStr = idRegionStr;
    }


}
