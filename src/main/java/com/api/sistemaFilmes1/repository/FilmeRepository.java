/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.sistemaFilmes1.repository;

import com.api.sistemaFilmes1.data.FilmeEntity;
import com.api.sistemaFilmes1.data.FilmeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leon
 */

@Repository
public interface FilmeRepository extends JpaRepository<FilmeEntity, Integer> {
    
}
