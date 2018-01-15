/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.controller;

import com.example.read.model.FicheBanque;
import com.example.read.model.prevision;
import com.example.read.services.BanqueService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suissi
 */
@RestController

@RequestMapping("/bfs")
public class BanqueController {
    @Autowired
    BanqueService banqueservice;
    
    
    @RequestMapping(value="/getal", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public List<FicheBanque> getall(){ 
   return banqueservice.getall();
    }
    
    @RequestMapping(value="/addd", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
public String addFileLines(String line) throws FileNotFoundException, UnsupportedEncodingException, IOException, ParseException {
        
     FicheBanque f;
    
        BufferedReader br = null;
        BufferedReader br1 = null;
        try {
            
           File file1 = new File("C:/banque.txt");
            System.out.println("gggggggggggggggggggg");
            FileInputStream fis1 = new FileInputStream(file1);
           
             br1 = new BufferedReader(new InputStreamReader(fis1, "UTF-8"));
            
            while ((line = br1.readLine())!= null ) {
                 DateFormat sourceFormat = new SimpleDateFormat("ddmmyy");
      CustomDateEditor editor = new CustomDateEditor(sourceFormat, true);
      f = new FicheBanque() ;

      

String s="" ;

        String cbanque = line.substring(1, 2);
        String banque1 = line.substring(3,7);
    String Zone ;
        String agence ;
        String coded ;
        String nbrd ;
        String zr ;
        String ncmpt ;
        String zr1 ;
        String dateis;
        String zr2;
        String dateval;
        String libile;
        String montant;
        String zr3;
        String numE;
        String indiceE;
        String indiceInd;
        String montantMouv;
        String zoneref;
      
    
           if(cbanque.equals("1")){
      s = "initial";
         Zone = line.substring(7,11);
         agence = line.substring(11,16);
         coded = line.substring(16,19);
         nbrd = line.substring(19,20);
         zr = line.substring(20,21);
         ncmpt = line.substring(21,32);
         zr1 = line.substring(32,34);
         dateis = line.substring(34,40);
        Date date = sourceFormat.parse(dateis);
         zr2 = line.substring(40,90);
         montant= line.substring(90,103);
         double value = Double.parseDouble(montant);
           String mf = line.substring(104,105);
         String sgn;
           if (mf.matches("[A-I?]")||(mf.equals("{"))){
           
           sgn="-";
           }
           else{
           sgn="+";
           }
           f.setBanque1(banque1);
           f.setCbanque(cbanque);
             f.setZone1(Zone);
         f.setAgence(agence);
          f.setCoded(coded);
         f.setNbrd (nbrd );
         f.setZr(zr);
         f.setNcmpt(ncmpt);
        f.setZr1(zr1);
         f.setDateis(date);
         f.setDateval  (date );
         f.setZr2(zr2);
        f.setMontantm(value); 
        f.setCodd(s);
       
          
           
           
           
          
        System.out.println("code enregistrement [" + cbanque+"]" +s + "   Code banque [" + banque1+"]" + "   Zone réservée [" + Zone+"]"+ "   code agence [" + agence+"]"+ "   code devise [" + coded+"]"+ "   Nomre decimal [" + nbrd+"]" + "   Zone réservée [" + zr+"]"+ "   num compte [" + ncmpt+"]"+ "   Zone réservée [" + zr1+"]" + "   Date de l ancien solde [" + date+"]"+ "   Zone réservée [" + zr2+"]"+ "   montant [" + montant+sgn +"]");
       
           }
        else if(cbanque.equals("7"))
         {
        s = "final";
           Zone = line.substring(7,11);
         agence = line.substring(11,16);
         coded = line.substring(16,19);
         nbrd = line.substring(19,20);
         zr = line.substring(20,21);
         ncmpt = line.substring(21,32);
         zr1 = line.substring(32,34);
         dateis = line.substring(34,40);
          Date date3 = sourceFormat.parse(dateis);
         zr2 = line.substring(40,90);
         montant= line.substring(90,103);
         double value = Double.parseDouble(montant);
         String mf = line.substring(104,105);
         String sgn;
         sgn="??";
           if (mf.matches("[A-I?]")||(mf.equals("{"))){
           
           sgn="+";
           }
           else if  (mf.matches("[J-W?]")||(mf.equals("}")))  {
           sgn="+";
           }
           f.setCodd(s);
           f.setBanque1(banque1);
                f.setZone1(Zone);
         f.setAgence(agence);
          f.setCoded(coded);
         f.setNbrd (nbrd );
         f.setZr(zr);
         f.setNcmpt(ncmpt);
        f.setZr1(zr1);
         f.setDateis(date3);
       f.setCbanque(cbanque);
         f.setZr2(zr2);
        f.setMontantm(value);   
      
          System.out.println("code enregistrement [" + cbanque+"]" +s + "   Code banque [" + banque1+"]" + "   Zone réservée [" + Zone+"]"+ "   code agence [" + agence+"]"+ "   code devise [" + coded+"]"+ "   Nomre decimal [" + nbrd+"]" + "   Zone réservée [" + zr+"]"+ "   num compte [" + ncmpt+"]"+ "   Zone réservée [" + zr1+"]" + "   Date de l ancien solde [" + date3+"]"+ "   Zone réservée [" + zr2+"]"+ "   montant [" + montant+sgn+"]" );
   
         }
        
        else if (cbanque.equals("4"))
        
         {
        s = "mouvement"; 
          String opi = line.substring(7,11);
          String codg = line.substring(11,16);
         String codd = line.substring(16,19);
         nbrd = line.substring(19,20);
         zr = line.substring(20,21);
         ncmpt = line.substring(21,32);
         String codeoi = line.substring(32,34);
         String dateco = line.substring(34,40);
         Date date2 = sourceFormat.parse(dateco);
         zr2 = line.substring(40,42);
         dateval= line.substring(42,48);
         Date date1 = sourceFormat.parse(dateval);
         libile = line.substring(48,79);
         zr3 = line.substring(79,81);
         numE = line.substring(81,88);
         indiceE= line.substring(88,89);
         indiceInd= line.substring(89,90);
       String montantm= line.substring(90,103);
       double value = Double.parseDouble(montantm);
         String z3 = line.substring(104,117);
      String mf = line.substring(104,105);
      
         String sgn;
           if (mf.matches("[A-I?]")||(mf.equals("{"))){
           
           sgn="-";
           }
           else{
           sgn="-";
           }
           f.setCodd(s);
           f.setBanque1(banque1);
           f.setCbanque(cbanque);
           f.setLibile(libile);
           f.setIndiceInd(indiceInd);
           f.setIndiceE(indiceE);
           f.setNumE(numE);
           f.setZr3(zr3);
           
            f.setOpi(opi);
         f.setAgence(codg);
          f.setCoded(codd);
         f.setNbrd (nbrd );
         f.setZr(zr);
         f.setNcmpt(ncmpt);
        f.setZr1(codeoi);
         f.setDateis(date2);
         f.setDateval  (date1);
         f.setZr2(zr2);
        f.setMontantm(value);  
        System.out.println(f);
       
          System.out.println("code enregistrement [" + cbanque+"]" +s + "   Code banque [" + banque1+"]" + "   Code opération interne [" + opi+"]"+ "   Code guichet  [" + codg+"]"+ "   code devise [" + codd+"]"+ "   Nomre decimal [" + nbrd+"]" + "   Zone réservée [" + zr+"]"+ "   num compte [" + ncmpt+"]"+ "   Code opération interbancaire [" + codeoi+"]" + "   Date de comptabilisation [" + date2+"]"+ "   Zone réservée [" + zr2+"]"+ "   Date de valeur [" +date1 +"]"+ "   libile [" +libile +"]"+ "   Zone reserver [" +zr3 +"]"+ "   Numéro d'écriture [" +numE +"]"+ "   Indice d'exonération [" +indiceE +"]"+ "   Indice d'indisponibilité [" +indiceInd +"]"+ "   montant [" + montantm+sgn+ "]"  +" Zone réference [" + z3+"]" );
         
         }
      
            banqueservice.save(f);    
        
     }
       
            
            

        } finally {
            

    System.out.println("**");
      return "ok";
        
        }      
}
}
