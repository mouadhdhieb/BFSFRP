/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.services;

import static com.example.read.StringData.processLine;
import com.example.read.model.prevision;
import com.example.read.repository.PrevisionRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mouadh
 */
@Service
@Transactional//Permet le RollBack 
public class PrevisionServiceImpl  implements PrevisionService {
    @Autowired
    PrevisionRepository previsionRepository ;

    @Override
    public void save(prevision p) {
        
        previsionRepository.save(p);
    }

    @Override
    public void SavePrevisonList() {
       
    }

    @Override
    public List<prevision> getall() {
        return previsionRepository.findAll();
    }

    @Override
    public void ReadFile(String line) {
       
    }

    
    
}
