package com.site.tourismemadagascar.model;

import com.site.tourismemadagascar.view.Login;
import com.site.tourismemadagascar.view.Register;

import java.util.HashMap;

public class UtilisateurModel {
    Register register;
    Login login;
    String nom,prenom,dateDN,numero,idRegion,mail,mdp;

    public UtilisateurModel(Register register) {
        this.setRegister(register);
        this.setNom(getRegister().getNom().getText().toString());
        this.setPrenom(getRegister().getPrenom().getText().toString());
        this.setDateDN(getRegister().getDate_naissance().getText().toString());
        this.setNumero(getRegister().getNumero().getText().toString());
        this.setIdRegion(getRegister().getIdRegion().getText().toString());
        this.setMail(getRegister().getMail().getText().toString());
        this.setMdp(getRegister().getMdp().getText().toString());
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
        map.put("idRegion", getIdRegion());
        map.put("mail", getMail());
        map.put("mdp", getMdp());
        return map;
    }

    public UtilisateurModel(String nom, String prenom, String dateDN, String numero, String idRegion, String mail, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDN = dateDN;
        this.numero = numero;
        this.idRegion = idRegion;
        this.mail = mail;
        this.mdp = mdp;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
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

    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
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
}
