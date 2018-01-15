/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ttauxmarche")
public class TauxMarche implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String TypeTaux;
    private Date  Date_Initialisation;
    private Double Cours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeTaux() {
        return TypeTaux;
    }

    public void setTypeTaux(String TypeTaux) {
        this.TypeTaux = TypeTaux;
    }

    public Date getDate_Initialisation() {
        return Date_Initialisation;
    }

    public void setDate_Initialisation(Date Date_Initialisation) {
        this.Date_Initialisation = Date_Initialisation;
    }

    public Double getCours() {
        return Cours;
    }

    public void setCours(Double Cours) {
        this.Cours = Cours;
    }
    
    
    
}
