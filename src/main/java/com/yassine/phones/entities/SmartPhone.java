package com.yassine.phones.entities;


import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class SmartPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MARQUE")
    private String marque;

    @Column(name = "COULEUR")
    private String couleur;

    @Column(name = "PRIX")
    private Double prix;

    @Column(name = "RAM")
    private Integer ram;

    @Column(name = "STOCKAGE")
    private Integer stockage;

    @Column(name = "DATE_CREATION")
    private Date dateCreation;

    public SmartPhone() {
        super();
    }

    public SmartPhone(String marque, String couleur, Double prix, Integer ram, Integer stockage, Date dateCreation) {
        super();
        this.marque = marque;
        this.couleur = couleur;
        this.prix = prix;
        this.ram = ram;
        this.stockage = stockage;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStockage() {
        return stockage;
    }

    public void setStockage(Integer stockage) {
        this.stockage = stockage;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "SmartPhone [id=" + id + ", marque=" + marque + ", couleur=" + couleur + ", prix=" + prix + ", ram=" + ram
                + ", stockage=" + stockage + ", dateCreation=" + dateCreation + "]";
    }
}
