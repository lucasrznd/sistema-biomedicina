package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
public class BuscarFenotipagemController implements Serializable {

    @Autowired
    private FenotipagemRepository fenotipagemRepository;
    private List<Fenotipagem> fenotipagemList;
    private Fenotipagem fenotipagem;

    private Fenotipagem fenotipagemSelecionada;

    @PostConstruct
    public void novo() {
        fenotipagem = new Fenotipagem();
        fenotipagemSelecionada = new Fenotipagem();
    }

    public void buscarFenotipagem() {
        if (fenotipagem.getTipagemAbo() != null) {
            fenotipagemList = fenotipagemRepository.getByTipagemAbo(fenotipagem.getTipagemAbo());
            PrimeFaces.current().ajax().update("form:datatable");
        } else {
            // Adicione um método semelhante para buscar por tipagemRh, se necessário
        }
    }

    public void update() {
        fenotipagemRepository.update(fenotipagemSelecionada);

        GrowlView.showInfo("Sucesso", "Registro editado com sucesso.");
    }

    public void delete() {
        fenotipagemRepository.delete(fenotipagemSelecionada);

        /* Remover objeto do arrayList */
        fenotipagemList.remove(fenotipagemSelecionada);

        GrowlView.showWarn("Removido", "Registro removido com sucesso.");
    }

}
