package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import br.edu.unifio.sistemabiomedicina.utils.ListaUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.View;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@View
@Data
public class BuscarAnticorpoController implements Serializable {

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

    public void redirect() {
        anticorpo = new Anticorpo();
        anticorpoSelecionado = new Anticorpo();
        anticorpoList = new ArrayList<>();

        Faces.redirect("/cadastro/anticorpo.xhtml");
    }

    public void buscarPorAnticorpoIdentificado() {
        anticorpoList = anticorpoRepository.getByAnticorpoIdentificado(anticorpo.getAnticorpoIdentificado());

        ListaUtil.verificaTamanhoLista(anticorpoList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    public void update() {
        anticorpoRepository.update(anticorpoSelecionado);

        GrowlView.showInfo("Sucesso", "Registro editado com sucesso.");
    }

    public void delete() {
        anticorpoRepository.delete(anticorpoSelecionado);
        anticorpoList = anticorpoRepository.getAll();

        GrowlView.showWarn("Removido", "Registro removido com sucesso.");
    }

}
