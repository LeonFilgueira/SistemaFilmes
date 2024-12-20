/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.sistemaFilmes1.controller;

import com.api.sistemaFilmes1.data.AnaliseEntity;
import com.api.sistemaFilmes1.service.AnaliseService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analise")
public class AnalisesController {
    
    @Autowired
    AnaliseService analiseService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllAnalises(){
        List<AnaliseEntity> analises = analiseService.listarTodasAnalises();
        
        return new ResponseEntity<>(analises, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<AnaliseEntity> getAnaliseById(@PathVariable Integer id){
        
        AnaliseEntity analise = analiseService.getAnaliseId(id);
        return new ResponseEntity<>(analise, HttpStatus.OK);
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<AnaliseEntity> addAnalise(@RequestBody AnaliseEntity analise){
        
        var novaAnalise = analiseService.criarAnalise(analise);
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AnaliseEntity> atualizarAnalise(@PathVariable Integer id, @RequestBody AnaliseEntity analise){
        var analiseAtualizado = analiseService.atualizarAnalise(id, analise);
        return new ResponseEntity<>(analiseAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarAnalise(@PathVariable Integer id){
        analiseService.deletarAnalise(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/pesquisar/{filmeId}")
    public ResponseEntity<AnaliseEntity> listarAnalises(@PathVariable Integer filmeId){
        AnaliseEntity analise = analiseService.buscarPorIdFilmeId(filmeId);
        return new ResponseEntity<>(analise, HttpStatus.OK);
    }
    
}
