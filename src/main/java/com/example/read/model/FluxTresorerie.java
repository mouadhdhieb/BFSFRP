/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tfluxtresorerie")
public class FluxTresorerie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    
    private String Code_Flux ;
    
    private String Libelle;
    
    public enum Categorie_Flux 
    {
     Depense,
     Recette,
     Decision_depense,
     Decision_ecette,
     Equilibrage_recette,
     Equilibrage_dépense 
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode_Flux() {
        return Code_Flux;
    }

    public void setCode_Flux(String Code_Flux) {
        this.Code_Flux = Code_Flux;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }
    
    
    
}
