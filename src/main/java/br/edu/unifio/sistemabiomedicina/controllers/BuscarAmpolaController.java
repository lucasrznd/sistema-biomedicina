package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class BuscarAmpolaController {

    @Autowired
    private AmpolaRepository ampolaRepository;
    private Ampola ampola;
    private List<Ampola> ampolaList = new ArrayList<>();

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostConstruct
    public void novo() {
        ampola = new Ampola();
    }

    public void buscarAmpola() {
        if (ampola.getPaciente().getNome() != null) {
            ampolaList = ampolaRepository.getByNomePaciente(ampola.getPaciente().getNome());
            PrimeFaces.current().ajax().update("form:datatable");
        }
    }

    public List<Paciente> buscarPaciente(String nome) {
        List<Paciente> pacientesEncontrados = pacienteRepository.getByNome(nome);

        if (pacientesEncontrados.size() == 0) {
            Messages.addFlashGlobalError("Paciente não encontrado");
        }
        return pacientesEncontrados;
    }

}