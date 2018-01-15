/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read;

import com.example.read.model.prevision;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;



/**
 *
 * @author mouadh
 */
public class StringData {
    public static void main(String[] args) throws Exception {
    BufferedReader br = null;
   prevision   p;
   p = new prevision() ;
        
        try {
            File file = new File("C:/Interface.txt");
          
            FileInputStream fis = new FileInputStream(file);
  
            br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null ) {
               processLine(sCurrentLine);
          
            }
        } finally {
            if (br != null  )
                br.close();
             
        }
    }

    public static void processLine(String line) throws ParseException  {
         prevision   p;
   p = new prevision() ;
    ArrayList<prevision> Tprevision = new ArrayList<>();
        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (line.startsWith("COMPTE")) return;

        String banque = line.substring(0,3);
        String agance  = line.substring(3,7);
        String flux;
        flux = line.substring(9, 13);
        String date_operation = line.substring(14, 25);
          Date date = sourceFormat.parse(date_operation);
        String montant = line.substring(43, 51);
        double value = Double.parseDouble( montant.replace(",",".") );
         String reference = line.substring(52, 65);
          String libele = line.substring(76, line.length());
          p.setBanque(banque);
          p.setAgance(agance);
          p.setFlux(flux);
          p.setDate_opration(date);
          p.setMontant_transaction(value);
          p.setReference(reference);
          p.setLibelle(libele);
          Tprevision.add(p);
          Tprevision.forEach((_item) -> {
          System.out.println(_item.getBanque()+ _item.getReference()+ _item.getFlux());
        }); // System.out.println("banque [" + banque + "]"+ "agance [ "+agance+"]"+ "flux [" + flux +"]"+"  date_operation"+ "["+date +"]"+"  montant"+ "["+value +"]" +"  reference"+ "["+reference +"]" +" libele"+ "["+libele +"]"  );
       

 

  
    }
   
}
