/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tagence")
public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "banque_id")
    private Banque banque;
    
     @OneToMany(mappedBy ="agence")
    private List<CompteBancaire> comptes ;
    private String  Code_Agence ;
    private String libelle ;
    private String ville_Cp;
    private String Adresse;
    private String Nom_interlocuteur ;

    public Long getId() {
        return id;
    }

    public String getVille_Cp() {
        return ville_Cp;
    }

    public void setVille_Cp(String ville_Cp) {
        this.ville_Cp = ville_Cp;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteBancaire> comptes) {
        this.comptes = comptes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public String getCode_Agence() {
        return Code_Agence;
    }

    public void setCode_Agence(String Code_Agence) {
        this.Code_Agence = Code_Agence;
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

    public String getNom_interlocuteur() {
        return Nom_interlocuteur;
    }

    public void setNom_interlocuteur(String Nom_interlocuteur) {
        this.Nom_interlocuteur = Nom_interlocuteur;
    }
    
    
}
