/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.sistemaFilmes1.service;

import com.api.sistemaFilmes1.repository.AnaliseRepository;
import com.api.sistemaFilmes1.data.AnaliseEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnaliseService {
    
    @Autowired
    AnaliseRepository analiseRepository;

    public AnaliseEntity criarAnalise(AnaliseEntity analise) {

        analise.setId(null);

        analiseRepository.save(analise);

        return analise;

    }
    
    public AnaliseEntity atualizarAnalise(Integer analiseID, AnaliseEntity analiseRequest) {

        AnaliseEntity analise = getAnaliseId(analiseID);

        analise.setAnalise(analiseRequest.getAnalise());

        analise.setNota(analiseRequest.getNota());

        analiseRepository.save(analise);

        return analise;

    }


    public AnaliseEntity getAnaliseId(Integer analiseId) {

        return analiseRepository.findById(analiseId).orElse(null);

    }

    public List<AnaliseEntity> listarTodasAnalises() {
        return analiseRepository.findAll();
    }

    public void deletarAnalise(Integer analiseId) {

        AnaliseEntity analise = getAnaliseId(analiseId);

        analiseRepository.deleteById(analise.getId());

    }
    
    public AnaliseEntity buscarPorIdFilmeId (Integer filmeId){
        return analiseRepository.findByFilmeId(filmeId);
    }
    
}
