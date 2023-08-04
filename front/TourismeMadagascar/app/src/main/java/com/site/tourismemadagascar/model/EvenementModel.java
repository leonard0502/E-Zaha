package com.site.tourismemadagascar.model;

import java.util.Date;
import java.util.List;

public class EvenementModel extends BaseModel {

    String description;
    SiteModel idSite;
    Date debut,fin;
    List<String> listeImage;

    int imageInt;
    public EvenementModel() {
    }



}
