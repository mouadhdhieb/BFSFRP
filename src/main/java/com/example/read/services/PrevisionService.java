/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.services;

import com.example.read.model.prevision;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mouadh
 */

public interface PrevisionService {
    public void save(prevision p);
    public void ReadFile(String line);
    public void SavePrevisonList();
    public List<prevision> getall();
    
    
}
