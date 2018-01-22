/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.services;

import com.example.read.model.prevision;
import com.example.read.repository.PrevisionRepository;
import java.io.IOException;
import java.net.MalformedURLException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mouadh
 */
@Service
@Transactional//Permet le RollBack 
public class PrevisionServiceImpl  implements PrevisionService {
    @Autowired
    PrevisionRepository previsionRepository ;
    
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");

    @Override
    public void save(prevision p) {
        
        previsionRepository.save(p);
    }

   

    @Override
    public List<prevision> getall() {
        return previsionRepository.findAll();
    }

    

    @Override
    public void store(MultipartFile file) {
    try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
    
    }
     
    @Override
    public void deleteAll() {
       FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
    
    @Override
    public Resource loadFile(String filename) {
        try {
			Path file = rootLocation.resolve(filename);
			Resource resource = (Resource) new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
       
    }

    @Override
    public void ReadFile(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SavePrevisonList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init() {
      try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
    }
    
    
    
    
    }

  

  

  
  
    
    

