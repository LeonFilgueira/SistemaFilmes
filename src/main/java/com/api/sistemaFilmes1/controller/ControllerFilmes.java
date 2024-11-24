/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.sistemaFilmes1.controller;

import com.api.sistemaFilmes1.data.AnaliseEntity;
import com.api.sistemaFilmes1.data.FilmeEntity;
import com.api.sistemaFilmes1.service.AnaliseService;
import com.api.sistemaFilmes1.service.FilmeService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Leon
 */
@Controller
public class ControllerFilmes {

    @Autowired
    FilmeService filmeService;
    
    @Autowired
    AnaliseService analiseService;

    @GetMapping("/tela-inicio")
    public String mostraIndex() {
        return "index";
    }

    @GetMapping("/inserir-filme")
    public String mostraCadastro(Model model) {
        model.addAttribute("filme", new FilmeEntity());
        return "cadastro";
    }

    @PostMapping("/guardar-filme")
    public String processarFormulario(Model model, @ModelAttribute FilmeEntity filme) {
        if (filme.getId() != null) {
            filmeService.atualizarFilme(filme.getId(), filme);
        } else {
            filmeService.criarFilme(filme);
        }
        return "redirect:/listagem";
    }

    @GetMapping("/listagem")
    public String mostraListagem(Model model) {
        model.addAttribute("filmes", filmeService.listarTodosFilmes());
        return "listagem";
    }

    @GetMapping("/exibir")
    public String mostrarDetalhes(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        FilmeEntity filmeEncontrado = new FilmeEntity();
        filmeEncontrado = filmeService.getFilmeId(idFilme);
        
        AnaliseEntity analiseEncontrada;
        analiseEncontrada = analiseService.buscarPorIdFilmeId(idFilme);
        
        
        model.addAttribute("filme", filmeEncontrado);
        model.addAttribute("analises", analiseEncontrada);
        model.addAttribute("analise", new AnaliseEntity());
        return "detalhes";
    }
    
  /*  @PostMapping("/guardar-analise")
    public String processarFormularioAnaliseEntity(Model model, @ModelAttribute AnaliseEntity analise, @ModelAttribute FilmeEntity filme){
        analise.setId(listaAnaliseEntity.size()+1);
        analise.setFilme(filme);
        listaAnaliseEntity.add(analise);
        //System.out.println(listaAnaliseEntity.get(0).getAnaliseEntity());
        return "redirect:/listagem";
    }*/
}
