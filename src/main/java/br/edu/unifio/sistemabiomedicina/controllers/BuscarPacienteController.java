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
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class BuscarPacienteController {

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
        pacienteList = pacienteRepository.getByNome(paciente.getNome());
        PrimeFaces.current().ajax().update("form:datatable");
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
