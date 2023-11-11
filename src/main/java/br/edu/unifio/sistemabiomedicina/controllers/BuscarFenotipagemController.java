package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.services.FenotipagemService;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import br.edu.unifio.sistemabiomedicina.utils.ListaUtil;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class BuscarFenotipagemController implements Serializable {

    @Autowired
    private FenotipagemService fenotipagemService;
    private Fenotipagem fenotipagem;

    private List<Fenotipagem> fenotipagemList;
    private Fenotipagem fenotipagemSelecionada;

    @PostConstruct
    public void novo() {
        fenotipagem = new Fenotipagem();
        fenotipagemSelecionada = new Fenotipagem();
    }

    public void redirect() {
        fenotipagem = new Fenotipagem();
        fenotipagemSelecionada = new Fenotipagem();
        fenotipagemList = new ArrayList<>();

        Faces.redirect("/cadastro/fenotipagem.xhtml");
    }

    public void buscarFenotipagem() {
        if (camposDeBuscaVazios()) {
            Messages.addFlashGlobalWarn("Preencha um campo para busca.");
            return;
        }

        fenotipagemList = fenotipagemService.buscaDinamica(fenotipagem);
        ListaUtil.verificaTamanhoLista(fenotipagemList);
    }

    private boolean camposDeBuscaVazios() {
        return fenotipagem.getTipagemAbo().isEmpty() && fenotipagem.getTipagemRh().isEmpty();
    }

    public void update() {
        fenotipagemService.update(fenotipagemSelecionada);

        GrowlView.showInfo("Sucesso", "Registro editado com sucesso.");
    }

    public void delete() {
        fenotipagemService.delete(fenotipagemSelecionada);

        /* Remover objeto do arrayList */
        fenotipagemList.remove(fenotipagemSelecionada);

        GrowlView.showWarn("Removido", "Registro removido com sucesso.");
    }

}