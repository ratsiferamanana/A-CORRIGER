package org.StudentPortail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entreprise extends User{
    private String nifStat;
    private Date dateCreation;
    private String description;
    private List<Offer> offers;

    public Entreprise(String id, String userName, String phone, String email, String address,Field field,String nifStat,Date dateCreation,String description) {
        super(id, userName, phone, email, address,field);
        this.nifStat = nifStat;
        this.dateCreation = dateCreation;
        this.description = description;
        this.offers = new ArrayList<Offer>();
    }

    public String getNifStat() {
        return nifStat;
    }

    public void setNifStat(String nifStat) {
        this.nifStat = nifStat;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "nifStat='" + nifStat + '\'' +
                ", dateCreation=" + dateCreation +
                ", description='" + description + '\'' +
                ", offers=" + offers +
                '}';
    }
}

