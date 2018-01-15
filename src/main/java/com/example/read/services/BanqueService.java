/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.services;

import com.example.read.model.FicheBanque;
import com.example.read.model.prevision;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author suissi
 */
public interface BanqueService {
      public void save(FicheBanque F );
    public void ReadFile(String line);
    public void SavePrevisonList();
    public List<FicheBanque> getall();
}
