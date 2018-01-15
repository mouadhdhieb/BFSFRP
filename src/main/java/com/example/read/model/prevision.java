/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Tprevision")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
       // allowGetters = true)
public class prevision  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String banque ;
    private String agance;
    private String flux ;
    
    
    @Column(nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_opration ;
    
            
    private double montant_transaction;
    private String reference;
    private String libelle;
    
    
    @Column(nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_valeur ;
    private String devise ;
    private int nombre ;
    private int id_journal_tresorie;
    private int n_mouvement;
    private int n_site;
    private double commission ;
    private long n_log ;
    
  
 
    private String devise_compte;
    
    private double montant_conte_valeur;
    
  
    private String sens ;
    
    
    private String supression ;

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getAgance() {
        return agance;
    }

    public void setAgance(String agance) {
        this.agance = agance;
    }

    public String getFlux() {
        return flux;
    }

    public void setFlux(String flux) {
        this.flux = flux;
    }

    public Date getDate_opration() {
        return date_opration;
    }

    public void setDate_opration(Date date_opration) {
        this.date_opration = date_opration;
    }

    public double getMontant_transaction() {
        return montant_transaction;
    }

    public void setMontant_transaction(double montant_transaction) {
        this.montant_transaction = montant_transaction;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate_valeur() {
        return date_valeur;
    }

    public void setDate_valeur(Date date_valeur) {
        this.date_valeur = date_valeur;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getId_journal_tresorie() {
        return id_journal_tresorie;
    }

    public void setId_journal_tresorie(int id_journal_tresorie) {
        this.id_journal_tresorie = id_journal_tresorie;
    }

    public int getN_mouvement() {
        return n_mouvement;
    }

    public void setN_mouvement(int n_mouvement) {
        this.n_mouvement = n_mouvement;
    }

    public int getN_site() {
        return n_site;
    }

    public void setN_site(int n_site) {
        this.n_site = n_site;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public long getN_log() {
        return n_log;
    }

    public void setN_log(long n_log) {
        this.n_log = n_log;
    }

   

    public String getDevise_compte() {
        return devise_compte;
    }

    public void setDevise_compte(String devise_compte) {
        this.devise_compte = devise_compte;
    }

    public double getMontant_conte_valeur() {
        return montant_conte_valeur;
    }

    public void setMontant_conte_valeur(double montant_conte_valeur) {
        this.montant_conte_valeur = montant_conte_valeur;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }

    public String getSupression() {
        return supression;
    }

    public void setSupression(String supression) {
        this.supression = supression;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public prevision(String banque, String agance, String flux, Date date_opration, double montant_transaction, String reference, String libelle,Date date_valeur) {
        this.banque = banque;
        this.agance = agance;
        this.flux = flux;
        this.date_opration = date_opration;
        this.montant_transaction = montant_transaction;
        this.reference = reference;
        this.libelle = libelle;
        this.date_valeur=date_valeur;
     
   
        
        
    }

    public prevision() {
    }
    
    
    
    
    
    
    
    
}
