package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class CadastroPacienteController implements Serializable {

    /* Repositories e classes da entidade Paciente */
    @Autowired
    private PacienteRepository pacienteRepository;
    private Paciente paciente = new Paciente();

    /* Repositories e classes da entidade Fenotipagem */
    @Autowired
    private FenotipagemRepository fenotipagemRepository;

    private List<Fenotipagem> fenotipagemList = new ArrayList<>();

    /* Repositories e classes da entidade Anticorpo */
    @Autowired
    private AnticorpoRepository anticorpoRepository;
    private List<Anticorpo> anticorposList;

    public void novo() {
        paciente = new Paciente();
    }

    public void insert() {
        pacienteRepository.insert(paciente);

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso");
    }

    public void imprimirAnticorpos() {
        System.out.println(fenotipagemList);
    }

    @PostConstruct
    public void listarAnticorpos() {
        anticorposList = anticorpoRepository.getAll();
    }

    @PostConstruct
    public void listarFenotipagens() {
        fenotipagemList = fenotipagemRepository.getAll();
    }
}
