package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class CadastroAnticorpoController {

    @Autowired
    private AnticorpoRepository anticorpoRepository;
    private Anticorpo anticorpo;
    private List<Anticorpo> anticorposList;

    @PostConstruct
    public void instanciarAnticorpo() {
        anticorpo = new Anticorpo();
    }

    public void insert() {
        anticorpoRepository.insert(anticorpo);

        anticorpo = new Anticorpo();

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Anticorpo salvo com sucesso");

        /*Atualiza a tabela*/
        listarAnticorpos();
        PrimeFaces.current().ajax().update("form:datatable");
    }

    @PostConstruct
    public void listarAnticorpos() {
        anticorposList = anticorpoRepository.getAll();
    }
}
