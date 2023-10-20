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
public class BuscarFenotipagemController {

    @Autowired
    private FenotipagemRepository fenotipagemRepository;
    private List<Fenotipagem> fenotipagemList = new ArrayList<>();
    private Fenotipagem fenotipagem;

    private Fenotipagem fenotipagemSelecionada;

    @PostConstruct
    public void novo() {
        fenotipagem = new Fenotipagem();
    }

    public void buscarFenotipagem() {
        if (fenotipagem.getTipagemAbo() != null) {
            fenotipagemList = fenotipagemRepository.getByTipagemAbo(fenotipagem.getTipagemAbo());
            PrimeFaces.current().ajax().update("form:datatable");
        } else {
            // Adicione um método semelhante para buscar por tipagemRh, se necessário
        }
    }

}
