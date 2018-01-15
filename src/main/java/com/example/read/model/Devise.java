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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tdevise")
public class Devise implements Serializable  {
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String CodeDevise ;
    private String libelle;
    private int Nombre_Decimales ;
    
    @OneToOne(mappedBy = "devise", cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY, optional = false)
    private CompteBancaire comptebancaire;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getComptebancaire() {
        return comptebancaire;
    }

    public void setComptebancaire(CompteBancaire comptebancaire) {
        this.comptebancaire = comptebancaire;
    }

    public String getCodeDevise() {
        return CodeDevise;
    }

    public void setCodeDevise(String CodeDevise) {
        this.CodeDevise = CodeDevise;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNombre_Decimales() {
        return Nombre_Decimales;
    }

    public void setNombre_Decimales(int Nombre_Decimales) {
        this.Nombre_Decimales = Nombre_Decimales;
    }
    
    
    
}
