package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class BuscarPacienteController implements Serializable {

    @Autowired
    private PacienteRepository pacienteRepository;
    private Paciente paciente;
    private List<Paciente> pacienteList = new ArrayList<>();

    private Paciente pacienteSelecionado;

    @Autowired
    private FenotipagemRepository fenotipagemRepository;
    private List<Fenotipagem> fenotipagemList;

    @Autowired
    private AnticorpoRepository anticorpoRepository;
    private List<Anticorpo> anticorposList;

    @PostConstruct
    public void novo() {
        paciente = new Paciente();
        pacienteSelecionado = new Paciente();
    }

    public void redirect() {
        paciente = new Paciente();
        pacienteSelecionado = new Paciente();
        pacienteList = new ArrayList<>();

        Faces.redirect("/cadastro/paciente.xhtml");
    }

    public void buscarPaciente() {
        if (paciente.getNome().isEmpty() && paciente.getSobrenome().isEmpty() &&
                paciente.getDataNascimento() == null && paciente.getCpf().isEmpty()) {
            Messages.addFlashGlobalError("Preencha pelo menos um campo para busca.");
        } else if (!paciente.getNome().isEmpty()) {
            pacienteList = pacienteRepository.getByNome(paciente.getNome());
            PrimeFaces.current().ajax().update("form:datatable");
        } else if (!paciente.getSobrenome().isEmpty()) {
            pacienteList = pacienteRepository.getBySobrenome(paciente.getSobrenome());
            PrimeFaces.current().ajax().update("form:datatable");
        } else if (paciente.getDataNascimento() != null) {
            pacienteList = pacienteRepository.getByDataNascimento(paciente.getDataNascimento());
        }
    }

    public void update() {
        pacienteRepository.update(pacienteSelecionado);

        GrowlView.showInfo("Sucesso", "Registro editado com sucesso.");
    }

    public void delete() {
        pacienteRepository.delete(pacienteSelecionado);

        GrowlView.showWarn("Removido", "Registro removido com sucesso.");
    }

    @PostConstruct
    public void listarAnticorpos() {
        anticorposList = anticorpoRepository.getAll();

        /* Remover objeto do arrayList */
        pacienteList.remove(pacienteSelecionado);
    }

    @PostConstruct
    public void listarFenotipagens () {
        fenotipagemList = fenotipagemRepository.getAll();
    }

}
