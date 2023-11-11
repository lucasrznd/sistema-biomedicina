package br.edu.unifio.sistemabiomedicina.services;

import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class PacienteService implements Serializable {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> buscaDinamica(Paciente paciente) {
        return pacienteRepository.buscaDinamica(paciente);
    }

    public List<Paciente> getByNome(String nome) {
        return pacienteRepository.getByNome(nome);
    }

    public void insert(Paciente paciente) {
        pacienteRepository.insert(paciente);
    }

    public void update(Paciente paciente) {
        pacienteRepository.update(paciente);
    }

    public void delete(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

}
