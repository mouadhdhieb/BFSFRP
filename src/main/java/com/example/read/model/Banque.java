/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tbanque")
public class Banque implements Serializable   {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CodeBnaque;
    private String Libelle;
    private String Adresse;
    
    private List<Agence> agences;

    public Long getId() {
        return id;
    }

    public List<Agence> getAgences() {
        return agences;
    }

    public void setAgences(List<Agence> agences) {
        this.agences = agences;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeBnaque() {
        return CodeBnaque;
    }

    public void setCodeBnaque(String CodeBnaque) {
        this.CodeBnaque = CodeBnaque;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }
    
    
    
    
    
    
    
}
