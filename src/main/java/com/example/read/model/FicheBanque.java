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
@Table(name = "Treleve")

public class FicheBanque implements Serializable  {
    
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private long id;
       
   
       private String cbanque ;
        
     
       private  String banque1;
       private String Zone1 ;
       private double montantm;
       private String z3;
       private String agence ;
       private String coded ;
       private String nbrd ;
       private String zr ;
       private String ncmpt ;
       private String opi;
       private String zr1 ;
       private String codg;
       
    @Column(nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
  
       private Date dateis;
    
       private String zr2;
       
       private String codd;
       
     @Column(nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    
       private Date dateval;
     
       private String libile;
       private String codeoi ;
       
  @Column(nullable = true, updatable = true)
  @Temporal(TemporalType.TIMESTAMP)
  
       private Date dateco;
  
       private double montant;
       private String zr3;
       private String numE;
       private String indiceE;
       private String indiceInd;
       private double montantMouv;
       private String zoneref;

    public FicheBanque(long id, String cbanque, String banque1, String Zone1, double montantm, String z3, String agence, String coded, String nbrd, String zr, String ncmpt, String opi, String zr1, String codg, Date dateis, String zr2, String codd, Date dateval, String libile, String codeoi, Date dateco, double montant, String zr3, String numE, String indiceE, String indiceInd, double montantMouv, String zoneref) {
        this.id = id;
        this.cbanque = cbanque;
        this.banque1 = banque1;
        this.Zone1 = Zone1;
        this.montantm = montantm;
        this.z3 = z3;
        this.agence = agence;
        this.coded = coded;
        this.nbrd = nbrd;
        this.zr = zr;
        this.ncmpt = ncmpt;
        this.opi = opi;
        this.zr1 = zr1;
        this.codg = codg;
        this.dateis = dateis;
        this.zr2 = zr2;
        this.codd = codd;
        this.dateval = dateval;
        this.libile = libile;
        this.codeoi = codeoi;
        this.dateco = dateco;
        this.montant = montant;
        this.zr3 = zr3;
        this.numE = numE;
        this.indiceE = indiceE;
        this.indiceInd = indiceInd;
        this.montantMouv = montantMouv;
        this.zoneref = zoneref;
    }
       
       
       public FicheBanque(){
           
       }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCbanque() {
        return cbanque;
    }

    public void setCbanque(String cbanque) {
        this.cbanque = cbanque;
    }

    public String getBanque1() {
        return banque1;
    }

    public void setBanque1(String banque1) {
        this.banque1 = banque1;
    }

    public String getZone1() {
        return Zone1;
    }

    public void setZone1(String Zone) {
        this.Zone1 = Zone;
    }

    public double getMontantm() {
        return montantm;
    }

    public void setMontantm(double montantm) {
        this.montantm = montantm;
    }

    public String getZ3() {
        return z3;
    }

    public void setZ3(String z3) {
        this.z3 = z3;
    }

    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public String getCoded() {
        return coded;
    }

    public void setCoded(String coded) {
        this.coded = coded;
    }

    public String getNbrd() {
        return nbrd;
    }

    public void setNbrd(String nbrd) {
        this.nbrd = nbrd;
    }

    public String getZr() {
        return zr;
    }

    public void setZr(String zr) {
        this.zr = zr;
    }

    public String getNcmpt() {
        return ncmpt;
    }

    public void setNcmpt(String ncmpt) {
        this.ncmpt = ncmpt;
    }

    public String getOpi() {
        return opi;
    }

    public void setOpi(String opi) {
        this.opi = opi;
    }

    public String getZr1() {
        return zr1;
    }

    public void setZr1(String zr1) {
        this.zr1 = zr1;
    }

    public String getCodg() {
        return codg;
    }

    public void setCodg(String codg) {
        this.codg = codg;
    }

    public Date getDateis() {
        return dateis;
    }

    public void setDateis(Date dateis) {
        this.dateis = dateis;
    }

    public String getZr2() {
        return zr2;
    }

    public void setZr2(String zr2) {
        this.zr2 = zr2;
    }

    public String getCodd() {
        return codd;
    }

    public void setCodd(String codd) {
        this.codd = codd;
    }

    public Date getDateval() {
        return dateval;
    }

    public void setDateval(Date dateval) {
        this.dateval = dateval;
    }

    public String getLibile() {
        return libile;
    }

    public void setLibile(String libile) {
        this.libile = libile;
    }

    public String getCodeoi() {
        return codeoi;
    }

    public void setCodeoi(String codeoi) {
        this.codeoi = codeoi;
    }

    public Date getDateco() {
        return dateco;
    }

    public void setDateco(Date dateco) {
        this.dateco = dateco;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getZr3() {
        return zr3;
    }

    public void setZr3(String zr3) {
        this.zr3 = zr3;
    }

    public String getNumE() {
        return numE;
    }

    public void setNumE(String numE) {
        this.numE = numE;
    }

    public String getIndiceE() {
        return indiceE;
    }

    public void setIndiceE(String indiceE) {
        this.indiceE = indiceE;
    }

    public String getIndiceInd() {
        return indiceInd;
    }

    public void setIndiceInd(String indiceInd) {
        this.indiceInd = indiceInd;
    }

    public double getMontantMouv() {
        return montantMouv;
    }

    public void setMontantMouv(double montantMouv) {
        this.montantMouv = montantMouv;
    }

    public String getZoneref() {
        return zoneref;
    }

    public void setZoneref(String zoneref) {
        this.zoneref = zoneref;
    }

    @Override
    public String toString() {
        return "FicheBanque{" + "id=" + id + ", cbanque=" + cbanque + ", banque1=" + banque1 + ", Zone1=" + Zone1 + ", montantm=" + montantm + ", z3=" + z3 + ", agence=" + agence + ", coded=" + coded + ", nbrd=" + nbrd + ", zr=" + zr + ", ncmpt=" + ncmpt + ", opi=" + opi + ", zr1=" + zr1 + ", codg=" + codg + ", dateis=" + dateis + ", zr2=" + zr2 + ", codd=" + codd + ", dateval=" + dateval + ", libile=" + libile + ", codeoi=" + codeoi + ", dateco=" + dateco + ", montant=" + montant + ", zr3=" + zr3 + ", numE=" + numE + ", indiceE=" + indiceE + ", indiceInd=" + indiceInd + ", montantMouv=" + montantMouv + ", zoneref=" + zoneref + '}';
    }
    
    
    

    
}
