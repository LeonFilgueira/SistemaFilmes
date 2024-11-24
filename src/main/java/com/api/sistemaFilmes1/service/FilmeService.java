/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.sistemaFilmes1.service;

import com.api.sistemaFilmes1.data.FilmeEntity;
import com.api.sistemaFilmes1.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    public FilmeEntity criarFilme(FilmeEntity filme) {

        filme.setId(null);

        filmeRepository.save(filme);

        return filme;

    }

    public FilmeEntity atualizarFilme(Integer filmeID, FilmeEntity filmeRequest) {

        FilmeEntity filme = getFilmeId(filmeID);

        filme.setTitulo(filmeRequest.getTitulo());

        filme.setGenero(filmeRequest.getGenero());

        filme.setSinopse(filmeRequest.getSinopse());

        filme.setAno(filmeRequest.getAno());

        filmeRepository.save(filme);

        return filme;

    }

    public FilmeEntity getFilmeId(Integer filmeId) {

        return filmeRepository.findById(filmeId).orElseThrow();

    }

    public List<FilmeEntity> listarTodosFilmes() {
        return filmeRepository.findAll();
    }

    public void deletarFilme(Integer filmeId) {

        FilmeEntity filme = getFilmeId(filmeId);

        filmeRepository.deleteById(filme.getId());

    }

}
