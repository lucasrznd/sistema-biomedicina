package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import br.edu.unifio.sistemabiomedicina.utils.ListaUtil;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
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
    private FenotipagemRepository fenotipagemRepository;
    private List<Fenotipagem> fenotipagemList;
    private Fenotipagem fenotipagem;

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
        } else if (!fenotipagem.getTipagemAbo().isEmpty()) {
            buscarPorTipagemAbo();
        } else {
            buscarPorTipagemRh();
        }
    }

    private boolean camposDeBuscaVazios() {
        return fenotipagem.getTipagemAbo().isEmpty() && fenotipagem.getTipagemRh().isEmpty();
    }

    private void buscarPorTipagemAbo() {
        fenotipagemList = fenotipagemRepository.getByTipagemAbo(fenotipagem.getTipagemAbo());

        ListaUtil.verificaTamanhoLista(fenotipagemList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    private void buscarPorTipagemRh() {
        fenotipagemList = fenotipagemRepository.getByTipagemRh(fenotipagem.getTipagemRh());

        ListaUtil.verificaTamanhoLista(fenotipagemList);
        PrimeFaces.current().ajax().update("form:datatable");
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
