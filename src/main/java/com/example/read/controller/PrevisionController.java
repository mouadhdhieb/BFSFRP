
package com.example.read.controller;

import static com.example.read.ReadApplication.UPLOAD_SIZE;
import static com.example.read.StringData.processLine;
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
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@RestController
@RequestMapping("/bfs")
public class PrevisionController {
 @Autowired
 PrevisionService previsionService;
    private static String Full_path;
   private static String UPLOAD_FOLDER = "E:\\";
    
@RequestMapping(value="/getall", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
public List<prevision> getAll() {
    return previsionService.getall();
}
    


@RequestMapping(value="/add", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
public String addFileLines(String line) throws FileNotFoundException, UnsupportedEncodingException, IOException, ParseException {
    
    
    
    
     BufferedReader br = null;
  
        
        try {
            File file = new File(Full_path);
          
            FileInputStream fis = new FileInputStream(file);
  
            br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            
           
            while ((line = br.readLine()) != null ) {
                
            prevision   p;
            p = new prevision() ;
             DateFormat sourceFormat = new SimpleDateFormat("dd/mm/yyyy");
              System.out.println("**");

           String banque = line.substring(0,3);
         String agance  = line.substring(3,7);         
         String flux;   
       flux = line.substring(7,15 );
         String date_operation = line.substring(13, 25);
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
           previsionService.save(p);
            System.out.println(p.getAgance());
           
            System.out.println("**");
        
          
            }
      
    

        }
         finally {
            
             return "ok";
        }
}


@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			return new ModelAndView("status", "message", "Please select a file and try again");
		}

		try {
			// read and write the file to the selected location-
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
                        Full_path=(path.toString());
                        System.out.println(Full_path);
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("status", "message", "File Uploaded sucessfully");
	}
        	@RequestMapping("/upload")
	public ModelAndView showUpload() {
		return new ModelAndView("upload");
	}

   
}
