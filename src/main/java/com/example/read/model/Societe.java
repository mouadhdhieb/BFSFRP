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
@Table(name = "Tsociete")
public class Societe implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String CodeSociete ;
    private  String Libelle;
    private String Adresse ;
    private byte[] Logo;
    private String SiteWeb;
    private String Contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeSociete() {
        return CodeSociete;
    }

    public void setCodeSociete(String CodeSociete) {
        this.CodeSociete = CodeSociete;
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

    public byte[] getLogo() {
        return Logo;
    }

    public void setLogo(byte[] Logo) {
        this.Logo = Logo;
    }

    public String getSiteWeb() {
        return SiteWeb;
    }

    public void setSiteWeb(String SiteWeb) {
        this.SiteWeb = SiteWeb;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }
    
    
}
