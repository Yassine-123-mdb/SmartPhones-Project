package com.yassine.phones.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
=======
>>>>>>> 4a20a5763b2431a4c780c43afdb4208ae581d607


@Entity
@Table(name = "smartphone")
public class SmartPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Size (min = 4,max = 15)
    private String marque;

    @Column(name = "COULEUR")
    private String couleur;

    @NotNull
    @Min(value = 10)
    @Max(value = 10000)
    private Double prix;

    @Column(name = "RAM")
    private Integer ram;

    @Column(name = "STOCKAGE")
    private Integer stockage;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent

    private Date dateCreation;
    
    @ManyToOne
    private Type type;
    public Type getType() {
    	return type;
    	}
    	public void setType(Type type) {
    	this.type = type;
    	}

    @ManyToOne
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

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
        return "SmartPhone [id=" + id + ", marque=" + marque + ", couleur=" + couleur + ", prix=" + prix + ", ram="
                + ram + ", stockage=" + stockage + ", dateCreation=" + dateCreation + "]";
    }
}
