package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Operador;
import br.edu.unifio.sistemabiomedicina.services.AmpolaService;
import br.edu.unifio.sistemabiomedicina.services.OperadorService;
import br.edu.unifio.sistemabiomedicina.services.RetiradaService;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class RetiradaAmpolaController implements Serializable {

    @Autowired
    private AmpolaService ampolaService;
    private List<Ampola> ampolaList;
    private List<Ampola> ampolasSelecionadas;

    @Autowired
    private OperadorService operadorService;
    private Operador operador;

    @Autowired
    private RetiradaService retiradaService;

    @PostConstruct
    public void novo() {
        ampolasSelecionadas = new ArrayList<>();
        operador = new Operador();

        ampolaList = ampolaService.getAllTrue();
    }

    public void efetuarRetirada() {
        if (!operadorService.autenticarOperador(operador)) {
            Messages.addFlashGlobalError("Código de Operador inválido.");
            return;
        }
        if (ampolasSelecionadas.isEmpty()) {
            Messages.addFlashGlobalError("Selecione um registro para retirada.");
            return;
        }

        /* Percorre a lista de selecionadas e efetua retirada  */
        retiradaService.realizarRetirada(ampolasSelecionadas, operador);

        ampolaList = ampolaService.getAllTrue();
        Messages.addFlashGlobalInfo("Retirada concluída com sucesso.");
    }

}
