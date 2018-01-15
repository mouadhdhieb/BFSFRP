/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.read.repository;



import com.example.read.model.FicheBanque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 *
 * @author suissi
 */

@Repository
public interface BanqueRepository extends JpaRepository<FicheBanque, Long>{
    
}
