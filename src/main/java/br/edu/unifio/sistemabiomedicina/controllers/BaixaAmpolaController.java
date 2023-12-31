package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Operador;
import br.edu.unifio.sistemabiomedicina.models.entities.Retirada;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import br.edu.unifio.sistemabiomedicina.repositories.OperadorRepository;
import br.edu.unifio.sistemabiomedicina.repositories.RetiradaRepository;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Component
@ViewScoped
@Data
public class BaixaAmpolaController implements Serializable {

    @Autowired
    private AmpolaRepository ampolaRepository;
    private Ampola ampola;

    @Autowired
    private OperadorRepository operadorRepository;
    private Operador operador;
    private List<Operador> operadorList;

    @Autowired
    private RetiradaRepository retiradaRepository;

    @PostConstruct
    public void load() {
        ampola = Faces.getFlashAttribute("ampolaSelecionada");
        operador = new Operador();

        operadorList = operadorRepository.getAll();
    }

    public void darBaixa() {
        if (!autenticarOperador()) {
            Messages.addFlashGlobalError("Código de Operador inválido.");
            return;
        }

        ampola.setStatusArmazenamento(false);
        ampolaRepository.update(ampola);

        Retirada retirada = new Retirada(null, operador, ampola, LocalDateTime.now());
        retiradaRepository.insert(retirada);

        Messages.addFlashGlobalInfo("Retirada com sucesso.");

        /* Redireciona para a tela de busca */
        Faces.redirect("/buscar/ampolaSelecionada.xhtml");
    }

    public boolean autenticarOperador() {
        for (Operador op : operadorList) {
            if (operador.getId().equals(op.getId())) {
                operador = op;
                return true;
            }
        }
        return false;
    }

}
