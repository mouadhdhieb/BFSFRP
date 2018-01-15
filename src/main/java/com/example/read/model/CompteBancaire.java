/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tcomptebancaire")
public class CompteBancaire implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String Code_Compte ;
    private String libelle;
    private String Adresse ;
    private Long Num_Comp_TN;
    private Long Num_Comp_AFB;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agence_id")
    private Agence agence ;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "devise_id")
    private Devise devise ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode_Compte() {
        return Code_Compte;
    }

    public void setCode_Compte(String Code_Compte) {
        this.Code_Compte = Code_Compte;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public Long getNum_Comp_TN() {
        return Num_Comp_TN;
    }

    public void setNum_Comp_TN(Long Num_Comp_TN) {
        this.Num_Comp_TN = Num_Comp_TN;
    }

    public Long getNum_Comp_AFB() {
        return Num_Comp_AFB;
    }

    public void setNum_Comp_AFB(Long Num_Comp_AFB) {
        this.Num_Comp_AFB = Num_Comp_AFB;
    }

  

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }
    
    
    
}
