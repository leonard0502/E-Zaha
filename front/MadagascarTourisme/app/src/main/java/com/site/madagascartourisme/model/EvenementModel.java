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
import java.util.List;

public class EvenementModel extends BaseModel implements Parcelable {

    String description;
    SiteModel site;
    Date debut,fin;
    List<String> listeImage;

    public EvenementModel() {
    }

    public EvenementModel(JsonObject evenementJson) {
        if (evenementJson.has("_id")) {
            this.set_id(evenementJson.get("_id").getAsString());
        }
        if (evenementJson.has("description")) {
            this.setDescription(evenementJson.get("description").getAsString());
        }
        if (evenementJson.has("debut")) {
            String dateString = evenementJson.get("debut").getAsString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date debutDate = dateFormat.parse(dateString);
                this.setDebut(debutDate);
            } catch (ParseException e) {

            }
        }
        if (evenementJson.has("fin")) {
            String dateString = evenementJson.get("fin").getAsString();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date finDate = dateFormat.parse(dateString);
                this.setFin(finDate);
            } catch (ParseException e) {

            }
        }
        if (evenementJson.has("idSite")) {
            JsonElement siteElement = evenementJson.get("idSite");
            if (siteElement.isJsonObject()) {
                JsonObject siteJson = siteElement.getAsJsonObject();
                SiteModel siteModel = new SiteModel(siteJson);
//                siteModel.afficherSiteDansConsole();
                this.setSite(siteModel);
//                this.getSite().afficherSiteDansConsole();
            }
        }
        if (evenementJson.has("listeImage")) {
            // Parsez la liste d'images et définissez la propriété listeImage
        }
    }

    public void afficherDansConsole() {
        Log.d("EvenementModel", "Description: " + this.getDescription());
        Log.d("EvenementModel", "Début: " + this.getDebut());
        Log.d("EvenementModel", "Fin: " + this.getFin());
        this.getSite().afficherSiteDansConsole();
    }

    protected EvenementModel(Parcel in) {
        description = in.readString();
        listeImage = in.createStringArrayList();
    }

    public static final Creator<EvenementModel> CREATOR = new Creator<EvenementModel>() {
        @Override
        public EvenementModel createFromParcel(Parcel in) {
            return new EvenementModel(in);
        }

        @Override
        public EvenementModel[] newArray(int size) {
            return new EvenementModel[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SiteModel getSite() {
        return site;
    }

    public void setSite(SiteModel site) {
        this.site = site;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public List<String> getListeImage() {
        return listeImage;
    }

    public void setListeImage(List<String> listeImage) {
        this.listeImage = listeImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeStringList(listeImage);
    }
}
