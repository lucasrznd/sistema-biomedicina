package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class ListagemPacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    private List<Paciente> pacienteList;

    @PostConstruct
    public void listarTodosPacientes() {
        pacienteList = pacienteRepository.getAll();
    }
}
