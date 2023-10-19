package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.View;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@View
@Data
public class ListagemAnticorpoController {

    @Autowired
    private AnticorpoRepository anticorpoRepository;
    private List<Anticorpo> anticorpoList = new ArrayList<>();

    @PostConstruct
    public void listarAnticorpos() {
        anticorpoList = anticorpoRepository.getAll();
    }
}
