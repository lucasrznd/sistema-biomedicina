package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
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
    public void novo() {
        anticorpo = new Anticorpo();
    }

    public void insert() {
        anticorpoRepository.insert(anticorpo);

        anticorpo = new Anticorpo();

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso");
    }

    @PostConstruct
    public void listarAnticorpos() {
        anticorposList = anticorpoRepository.getAll();
    }
}
