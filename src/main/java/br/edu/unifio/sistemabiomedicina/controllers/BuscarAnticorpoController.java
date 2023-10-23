package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.View;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@View
@Data
public class BuscarAnticorpoController {

    @Autowired
    private AnticorpoRepository anticorpoRepository;
    private Anticorpo anticorpo;
    private List<Anticorpo> anticorpoList = new ArrayList<>();

    private Anticorpo anticorpoSelecionado;

    @PostConstruct
    public void novo() {
        anticorpo = new Anticorpo();
        anticorpoSelecionado = new Anticorpo();
    }

    public void buscarAnticorpo() {
        if (anticorpo.getAnticorpoIdentificado() != null) {
            anticorpoList = anticorpoRepository.getByAnticorpoIdentificado(anticorpo.getAnticorpoIdentificado());
            PrimeFaces.current().ajax().update("form:datatable");
        }
    }

    public void update() {
        anticorpoRepository.update(anticorpoSelecionado);

        Messages.addFlashGlobalWarn("Registro editado com sucesso.");
    }

    public void delete() {
        anticorpoRepository.delete(anticorpoSelecionado);
        /* Remover objeto do arrayList */
        anticorpoList.remove(anticorpoSelecionado);

        Messages.addFlashGlobalWarn("Registro removido com sucesso.");
    }

}
