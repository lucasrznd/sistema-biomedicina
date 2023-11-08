package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Operador;
import br.edu.unifio.sistemabiomedicina.models.entities.Retirada;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import br.edu.unifio.sistemabiomedicina.repositories.OperadorRepository;
import br.edu.unifio.sistemabiomedicina.repositories.RetiradaRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class RetiradaAmpolaController implements Serializable {

    @Autowired
    private AmpolaRepository ampolaRepository;
    private List<Ampola> ampolaList;
    private List<Ampola> ampolasSelecionadas;

    @Autowired
    private OperadorRepository operadorRepository;
    private List<Operador> operadorList;
    private Operador operador;

    @Autowired
    private RetiradaRepository retiradaRepository;

    @PostConstruct
    public void novo() {
        ampolasSelecionadas = new ArrayList<>();
        operador = new Operador();

        ampolaList = ampolaRepository.getAllTrue();
        operadorList = operadorRepository.getAll();
    }

    public void efetuarRetirada() {
        if (!autenticarOperador()) {
            Messages.addFlashGlobalError("Código de Operador inválido.");
            return;
        }
        if (ampolasSelecionadas.isEmpty()) {
            Messages.addFlashGlobalError("Selecione um registro para retirada.");
            return;
        }

        realizarRetirada();

        ampolaList = ampolaRepository.getAllTrue();
        Messages.addFlashGlobalInfo("Retirada concluída com sucesso.");
    }

    private void realizarRetirada() {
        for (Ampola amp : ampolasSelecionadas) {
            amp.setStatusArmazenamento(false);
            ampolaRepository.update(amp);

            Retirada retirada = new Retirada(null, operador, amp, LocalDateTime.now());
            retiradaRepository.insert(retirada);
        }
    }

    private boolean autenticarOperador() {
        for (Operador op : operadorList) {
            if (operador.getId().equals(op.getId())) {
                operador = op;
                return true;
            }
        }
        return false;
    }

}
