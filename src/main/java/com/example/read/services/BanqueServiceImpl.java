/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.services;

import com.example.read.model.FicheBanque;
import com.example.read.repository.BanqueRepository;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author suissi
 */
@Service
@Transactional
public class BanqueServiceImpl implements BanqueService{
@Autowired
BanqueRepository banquerepository ;

    

    @Override
    public List<FicheBanque> getall() {
       return banquerepository.findAll();
    }

    @Override
    public void save(FicheBanque F) {
         banquerepository.save(F);
    }

    @Override
    public void ReadFile(String line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SavePrevisonList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
