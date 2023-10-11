package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class FenotipagemController {

    private Fenotipagem fenotipagem = new Fenotipagem();

    @Autowired
    private FenotipagemRepository fenotipagemRepository;

    private List<Fenotipagem> fenotipagemList = new ArrayList<>();

    public void insert() {
        fenotipagemRepository.insert(fenotipagem);

        getAll();
        fenotipagem = new Fenotipagem();

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Fenotipagem salva com sucesso");

        /*Recarrega a tabela com os dados do banco*/
        PrimeFaces.current().ajax().update("form:datatable");
    }

    @PostConstruct
    public void getAll() {
        fenotipagemList = fenotipagemRepository.getAll();
    }
}
