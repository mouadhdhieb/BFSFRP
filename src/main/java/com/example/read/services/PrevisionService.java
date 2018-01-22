/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.services;

import com.example.read.model.prevision;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mouadh
 */

public interface PrevisionService {
    public void save(prevision p);
    public void ReadFile(String line);
    public void SavePrevisonList();
    public List<prevision> getall();
    void store(MultipartFile file);
public void init() ;
    public Resource loadFile(String filename) ;
    void deleteAll();

    
    
}
