package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.services.AnticorpoService;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import br.edu.unifio.sistemabiomedicina.utils.ListaUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.View;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
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
    private AnticorpoService anticorpoService;
    private Anticorpo anticorpo;

    private Anticorpo anticorpoSelecionado;
    private List<Anticorpo> anticorpoList;

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

    public void buscar() {
        if (campoDeBuscaVazio()) {
            Messages.addFlashGlobalWarn("Preencha um campo para busca.");
            return;
        }

        buscarPorAnticorpoIdentificado();
    }

    public boolean campoDeBuscaVazio() {
        return anticorpo.getAnticorpoIdentificado().isEmpty();
    }

    private void buscarPorAnticorpoIdentificado() {
        anticorpoList = anticorpoService.getByAnticorpoIdentificado(anticorpo.getAnticorpoIdentificado());

        ListaUtil.verificaTamanhoLista(anticorpoList);
    }

    public void update() {
        anticorpoService.update(anticorpoSelecionado);

        GrowlView.showInfo("Sucesso", "Registro editado com sucesso.");
    }

    public void delete() {
        anticorpoService.delete(anticorpoSelecionado);

        GrowlView.showWarn("Removido", "Registro removido com sucesso.");
    }

}
