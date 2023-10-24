package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Armazenamento;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
public class CadastroAmpolaController {

    @Autowired
    private AmpolaRepository ampolaRepository;
    private Ampola ampola;

    @Autowired
    private PacienteRepository pacienteRepository;

    private Armazenamento armazenamento;

    @PostConstruct
    public void novo() {
        ampola = new Ampola();
        armazenamento = new Armazenamento();
    }

    public void insert() {
        ampola.setArmazenamento(armazenamento);
        ampolaRepository.insert(ampola);

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso");
    }

    public List<Paciente> buscarPaciente(String nome) {
        List<Paciente> pacientesEncontrados = pacienteRepository.getByNome(nome);

        if (pacientesEncontrados.size() == 0) {
            Messages.addFlashGlobalError("Paciente não encontrado");
        }
        return pacientesEncontrados;
    }

}
