package br.edu.unifio.sistemabiomedicina.services;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Component
public class PacienteService implements Serializable {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> getByNome(String nome) {
        return pacienteRepository.getByNome(nome);
    }

    public List<Paciente> getByDataNascimento(LocalDate dataNascimento) {
        return pacienteRepository.getByDataNascimento(dataNascimento);
    }

    public List<Paciente> getByCpf(String cpf) {
        return pacienteRepository.getByCpf(cpf);
    }

    public List<Paciente> getByFenotipagem(Fenotipagem fenotipagem) {
        return pacienteRepository.getByFenotipagem(fenotipagem);
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
