package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Operador;
import br.edu.unifio.sistemabiomedicina.models.entities.Retirada;
import br.edu.unifio.sistemabiomedicina.services.RetiradaService;
import br.edu.unifio.sistemabiomedicina.utils.ListaUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
public class HistoricoRetiradaController implements Serializable {

    @Autowired
    private RetiradaService retiradaService;
    private Retirada retirada;
    private List<Retirada> retiradaList;

    @PostConstruct
    public void novo() {
        retirada = new Retirada();
        retirada.setOperador(new Operador());

        retiradaList = retiradaService.getAll();
    }

    public void redirect() {
        Faces.redirect("/retirada/ampola.xhtml");
    }

    public void buscar() {
        if (camposDeBuscaVazios()) {
            Messages.addFlashGlobalWarn("Preencha um campo para busca.");
            return;
        }

        retiradaList = retiradaService.buscaDinamica(retirada);
        ListaUtil.verificaTamanhoLista(retiradaList);
    }

    private boolean camposDeBuscaVazios() {
        return retirada.getOperador().getId() == null && retirada.getDataRetirada() == null;
    }

}
