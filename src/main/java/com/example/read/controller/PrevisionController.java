package com.example.read.controller;

import static com.example.read.ReadApplication.UPLOAD_SIZE;
import static com.example.read.StringData.processLine;
import com.example.read.model.Structure;
import com.example.read.model.prevision;
import com.example.read.repository.PrevisionRepository;
import com.example.read.services.PrevisionService;
import com.example.read.services.PrevisionServiceImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.HttpMethod.POST;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/bfs")
@CrossOrigin(origins = "http://localhost:4200")
public class PrevisionController {

    @Autowired
    PrevisionService previsionService;
    private static String Full_path;

//variable assistant structure
    private static boolean gobligatoirc;
    private static boolean gindusc;
    private static Integer gposition_debutc;
    private static Integer glongueurc;
//agence
    private static boolean gobligatoirag;
    private static boolean gindusag;
    private static Integer gposition_debutag;
    private static Integer glongueurag;

//flux
    private static boolean gobligatoirf;
    private static boolean gindusf;
    private static Integer gposition_debutf;
    private static Integer glongueurf;
//date operation
    private static boolean gobligatoird;
    private static boolean gindusd;
    private static Integer gposition_debutd;
    private static Integer glongueurd;
//code budgitaire
    private static boolean gobligatoircb;
    private static boolean ginduscb;
    private static Integer gposition_debutcb;
    private static Integer glongueurcb;
//montant transaction
    private static boolean gobligatoirm;
    private static boolean gindusm;
    private static Integer gposition_debutm;
    private static Integer glongueurm;
//libelle 
    private static boolean gobligatoirl;
    private static boolean gindusl;
    private static Integer gposition_debutl;
    private static Integer glongueurl;
//reference
    private static boolean gobligatoirr;
    private static boolean gindusr;
    private static Integer gposition_debutr;
    private static Integer glongueurr;

    //date valeur
    private static boolean gobligatoirdv;
    private static boolean gindusdv;
    private static Integer gposition_debutdv;
    private static Integer glongueurdv;
    //devise
    private static boolean gobligatoirdev;
    private static boolean gindusdev;
    private static Integer gposition_debutdev;
    private static Integer glongueurdev;
    //num mouvement
    private static boolean gobligatoirnmouv;
    private static boolean gindusnmouv;
    private static Integer gposition_debutnmouv;
    private static Integer glongueurnmouv;
    //num site
    private static boolean gobligatoirnsit;
    private static boolean gindusnsit;
    private static Integer gposition_debutnsit;
    private static Integer glongueurnsit;
    //commission
    private static boolean gobligatoircommi;
    private static boolean ginduscommi;
    private static Integer gposition_debutcommi;
    private static Integer glongueurcommi;
    //devise compte
    private static boolean gobligatoirdevc;
    private static boolean gindusdevc;
    private static Integer gposition_debutdevc;
    private static Integer glongueurdevc;
    //montant contre valeur
    private static boolean gobligatoirmdcv;
    private static boolean gindusmcv;
    private static Integer gposition_debutmcv;
    private static Integer glongueurmcv;

    private static boolean gobligatoirsens;
    private static boolean gindussens;
    private static Integer gposition_debutsens;
    private static Integer glongueursens;

    private static String UPLOAD_FOLDER = "E:\\";

    @RequestMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<prevision> getAll() {
        return previsionService.getall();
    }

    @RequestMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String addFileLines(String line) throws FileNotFoundException, UnsupportedEncodingException, IOException, ParseException {

        BufferedReader br = null;

        try {
            File file = new File(Full_path);

            FileInputStream fis = new FileInputStream(file);

            br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

            while ((line = br.readLine()) != null) {

                prevision p;
                p = new prevision();
                DateFormat sourceFormat = new SimpleDateFormat("dd/mm/yyyy");
                System.out.println("**");

                String banque = line.substring(0, 3);
                String agance = line.substring(3, 7);
                String flux;
                flux = line.substring(7, 15);
                String date_operation = line.substring(13, 25);
                Date date = sourceFormat.parse(date_operation);
                String montant = line.substring(43, 51);
                double value = Double.parseDouble(montant.replace(",", "."));
                String reference = line.substring(52, 65);
                String libele = line.substring(76, line.length());

                p.setBanque(banque);
                p.setAgance(agance);
                p.setFlux(flux);
                p.setDate_opration(date);
                p.setMontant_transaction(value);
                p.setReference(reference);
                p.setLibelle(libele);
                previsionService.save(p);
                System.out.println(p.getAgance());

                System.out.println("**");

            }

        } finally {

            return "ok";
        }
    }

    @PostMapping("/upload")
    public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, String line) throws ParseException {

        if (file.isEmpty()) {
            return new ModelAndView("status", "message", "Please select a file and try again");
        }

        try {
            // read and write the file to the selected location-
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Full_path = (path.toString());
            System.out.println(Full_path);
            Files.write(path, bytes);

            BufferedReader br = null;

            try {
                File file1 = new File(Full_path);

                FileInputStream fis = new FileInputStream(file1);

                br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

                while ((line = br.readLine()) != null) {

                    prevision p;
                    p = new prevision();
                    DateFormat sourceFormat = new SimpleDateFormat("dd/mm/yyyy");
                    System.out.println("**");
                    
                    if(gindusc == true) {
                    String banque = line.substring(gposition_debutc,gposition_debutc + glongueurc);
                     p.setBanque(banque);
                    
                    }
                    if(gindusag == true ){
                      String agance = line.substring(gposition_debutag,gposition_debutag + glongueurag);
                      p.setAgance(agance);
                    }
                    if(gindusf== true ){
                    String flux;
                      flux = line.substring(gposition_debutf,gposition_debutf + glongueurf);
                      p.setFlux(flux);
                    }
                    if(gindusd == true){
                    String date_operation = line.substring(gposition_debutd,gposition_debutd+glongueurd);
                    Date date = sourceFormat.parse(date_operation);
                     p.setDate_opration(date);
                    }
                    if(gindusdev == true){
                        String devise = line.substring(gposition_debutdev, gposition_debutdev+glongueurdev);
                        p.setDevise(devise);
                    
                    }
                    if(gindusnmouv == true){
                        String num_mouvement= line.substring(gposition_debutnmouv,gposition_debutnmouv+ glongueurnmouv);
                        int numero_mouvement= Integer.parseInt(num_mouvement);    
                        p.setN_mouvement(numero_mouvement);
                    }
                    
                    if(ginduscb == true){
                        
                        String code_bugitaire =line.substring(gposition_debutcb,gposition_debutcb + glongueurcb);
                        p.setCode_budgitaire(code_bugitaire);
                    
                    }
                    if(gindusm == true){
                        String montant = line.substring(gposition_debutm,gposition_debutm + glongueurm);
                    double value = Double.parseDouble(montant.replace(",", "."));
                    p.setMontant_transaction(value);
                    }
                    if(gindusr == true) {
                    
                    String reference= line.substring(gposition_debutr,gposition_debutr+ glongueurr);
                    p.setReference(reference);
                    
                    }
                    if (gindusl == true) {
                    String libelle = line.substring(gposition_debutl, gposition_debutl+glongueurl);
                    p.setLibelle(libelle);
                    
                    }
                    
                    if(gindusdv == true) {
                     String date_valeur= line.substring(gposition_debutdv,gposition_debutdv+ glongueurdv);
                     Date datev = sourceFormat.parse(date_valeur);
                     p.setDate_valeur(datev);
                    
                    }
                    if(gindusnsit == true){
                        String n_sit = line.substring(gposition_debutnsit, gposition_debutnsit+glongueurnsit);
                        int n_site = Integer.parseInt(n_sit);
                        p.setN_site(n_site);
                    }
                    if(ginduscommi == true) {
                     String commi = line.substring(gposition_debutcommi,gposition_debutcommi+ glongueurcommi);
                     double valeur_commi =Double.parseDouble(commi.replace(",", "."));
                     p.setCommission(valeur_commi);
                    }
                    
                    if(gindusdevc == true) {
                      String devisecompte = line.substring(gposition_debutdevc, gposition_debutdevc+glongueurdevc);
                      p.setDevise_compte(devisecompte);
                    
                    }
                    if(gindusmcv == true){
                      String montantcvaleur = line.substring(gposition_debutmcv,gposition_debutmcv+glongueurmcv);
                       double valeur_montant = Double.parseDouble(montantcvaleur.replace(",", "."));
                       p.setMontant_conte_valeur(valeur_montant);
                      
                      
                    }
                    
                    if(gindussens == true) {
                        
                 
                    String senss = line.substring(gposition_debutsens, gposition_debutsens+glongueursens);
                    p.setSens(senss);
                    
                    
                    }
                    /*  //0-3
                    String banque = line.substring(gposition_debutc, glongueurc);
                    //3-7
                    String agance = line.substring(3, 7);
                    String flux;
                    //7-15
                    flux = line.substring(7, 15);
                    //13-25
                    String date_operation = line.substring(13, 25);
                    Date date = sourceFormat.parse(date_operation);
                    //43-51
                    String montant = line.substring(43, 51);
                    double value = Double.parseDouble(montant.replace(",", "."));
                    //52-65
                    String reference = line.substring(52, 65);
                    //76 length
                    String libele = line.substring(76, line.length());

                    p.setBanque(banque);
                    p.setAgance(agance);
                    p.setFlux(flux);
                    p.setDate_opration(date);
                    p.setMontant_transaction(value);
                    p.setReference(reference);
                    p.setLibelle(libele);
                    previsionService.save(p);*/
                    System.out.println(p.getAgance());
                    System.out.println(p.getDate_opration());

                   // System.out.println("**" + banque);

                }

            } finally {

                System.out.println("ok");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView("status", "message", "File Uploaded sucessfully");
    }

    @RequestMapping("/upload")
    public ModelAndView showUpload() {
        return new ModelAndView("upload");
    }

    @RequestMapping(value = "/push ", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ModelAndView file(@RequestParam("structure") MultipartFile file, RedirectAttributes redirectAttributes, String line) throws ParseException {

        if (file.isEmpty()) {
            return new ModelAndView("status", "message", "Please select a file and try again");
        }

        try {
            // read and write the file to the selected location-
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Full_path = (path.toString());
            System.out.println(Full_path);
            Files.write(path, bytes);

            BufferedReader br = null;

            try {
                File file1 = new File(Full_path);

                FileInputStream fis = new FileInputStream(file1);

                br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

                while ((line = br.readLine()) != null) {

                    prevision p;
                    p = new prevision();
                    Structure s;
                    s = new Structure();
                    DateFormat sourceFormat = new SimpleDateFormat("dd/mm/yyyy");
                    System.out.println("**");

                    String banque = line.substring(0, 3);
                    String agance = line.substring(3, 7);
                    String flux;
                    flux = line.substring(7, 15);
                    String date_operation = line.substring(s.getPosition_debutd(), s.getLongueurd());
                    Date date = sourceFormat.parse(date_operation);
                    String montant = line.substring(s.getPosition_debutm(), s.getLongueurm());
                    double value = Double.parseDouble(montant.replace(",", "."));
                    String reference = line.substring(s.getPosition_debutr(), s.getLongueurr());
                    String libele = line.substring(s.getPosition_debutr(), s.getLongueurr());

                    p.setBanque(banque);
                    p.setAgance(agance);
                    p.setFlux(flux);
                    p.setDate_opration(date);
                    p.setMontant_transaction(value);
                    p.setReference(reference);
                    p.setLibelle(libele);
                    previsionService.save(p);
                    System.out.println(p.getAgance());

                    System.out.println("**");

                }

            } finally {

                System.out.println("ok");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView("status", "message", "File Uploaded sucessfully");

    }

    @RequestMapping(value = "/structure", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String SaveStructure(@RequestBody Structure structure) {

        System.out.println(structure.toString());
        glongueurc = structure.getLongueurc();
        gposition_debutc = structure.getPosition_debutc();
        gobligatoirnmouv = structure.isObligatoirc();
        gindusnmouv = structure.isIndusc();
        structure.isIndusag();
        gposition_debutag = structure.getPosition_debutag();
        glongueurag = structure.getLongueurag();
        gobligatoirf = structure.isObligatoirf();

        gobligatoirag = structure.isObligatoirag();
        gindusag = structure.isIndusag();
        gposition_debutag = structure.getPosition_debutag();
        glongueurag = structure.getLongueurag();
        gobligatoirf = structure.isObligatoirf();
        gindusf = structure.isIndusf();
        gposition_debutf = structure.getPosition_debutf();
        glongueurf = structure.getLongueurf();
        gobligatoird = structure.isObligatoird();
        gindusd = structure.isIndusd();
        gposition_debutd = structure.getPosition_debutd();
        glongueurd = structure.getLongueurd();

        gobligatoircb = structure.isObligatoircb();
        ginduscb = structure.isInduscb();
        gposition_debutcb = structure.getPosition_debutcb();
        glongueurcb = structure.getLongueurcb();
        gobligatoirm = structure.isObligatoirm();
        gindusm = structure.isIndusm();
        gposition_debutm = structure.getPosition_debutm();
        glongueurm = structure.getLongueurm();
        gobligatoirl = structure.isObligatoirl();
        gindusl = structure.isIndusl();
        gposition_debutl = structure.getPosition_debutl();
        glongueurl = structure.getLongueurl();
        gobligatoirr = structure.isObligatoirr();
        gindusr = structure.isIndusr();
        gposition_debutr = structure.getPosition_debutr();
        glongueurr = structure.getLongueurr();
        gobligatoirdv = structure.isObligatoirdv();
        gindusdv = structure.isIndusdv();
        gposition_debutdv = structure.getPosition_debutdv();
        glongueurdv = structure.getLongueurdv();
        gobligatoirdev = structure.isObligatoirdev();
        gindusdev = structure.isIndusdev();
        gposition_debutdev = structure.getPosition_debutdev();
        glongueurdev = structure.getLongueurdev();
        gobligatoirnmouv = structure.isObligatoirnmouv();
        gindusnmouv = structure.isIndusnmouv();
        gposition_debutnmouv = structure.getPosition_debutnmouv();
        glongueurnmouv = structure.getLongueurnmouv();
        gobligatoirnsit = structure.isObligatoirnsit();
        gindusnsit = structure.isIndusnsit();
        gposition_debutnsit = structure.getPosition_debutnsit();
        glongueurnsit = structure.getLongueurnsit();
        gobligatoircommi = structure.isObligatoircommi();
        ginduscommi = structure.isInduscommi();
        gposition_debutcommi = structure.getPosition_debutcommi();
        glongueurcommi = structure.getLongueurcommi();
        gobligatoirdevc = structure.isObligatoirdevc();
        gindusdevc = structure.isIndusdevc();
        gposition_debutdevc = structure.getPosition_debutdevc();
        glongueurdevc = structure.getLongueurdevc();
        gobligatoirmdcv = structure.isObligatoirmdcv();
        gindusmcv = structure.isIndusmcv();
        gposition_debutmcv = structure.getPosition_debutmcv();
        glongueurmcv = structure.getLongueurmcv();
        gobligatoirsens = structure.isObligatoirsens();
        gindussens = structure.isIndussens();
        gposition_debutsens = structure.getPosition_debutsens();
        glongueursens = structure.getLongueursens();

        return structure.toString();

    }

}
