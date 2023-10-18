package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
public class PacienteController implements Serializable {

    @Autowired
    private PacienteRepository pacienteRepository;
    private Paciente paciente = new Paciente();

    @Autowired
    private FenotipagemRepository fenotipagemRepository;

    private List<Fenotipagem> fenotipagemList;
    private String fenotipagemSelecionada;

    private Anticorpo anticorpo = new Anticorpo();

    public Fenotipagem obterFenotipagem() {
        /* Faz a busca da Fenotipagem escolhida em String, busca no banco e retorna objeto Fenotipagem */
        Fenotipagem fenotipagem = fenotipagemRepository.getById(Long.parseLong(fenotipagemSelecionada));
        return fenotipagem;
    }

    public void imprimirFenotipagem() {
        System.out.println(fenotipagemSelecionada);
    }

    public void insert() {
        Fenotipagem fenotipagem = obterFenotipagem();

        paciente.setFenotipagem(fenotipagem);
        pacienteRepository.insert(paciente);

        paciente = new Paciente();
        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Paciente salvo com sucesso");
    }

    @PostConstruct
    public void listarFenotipagens() {
        fenotipagemList = fenotipagemRepository.getAll();
    }
}
