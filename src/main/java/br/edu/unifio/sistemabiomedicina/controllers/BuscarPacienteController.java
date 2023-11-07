package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import br.edu.unifio.sistemabiomedicina.utils.ListaUtil;
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
        pacienteList = new ArrayList<>();

        anticorposList = anticorpoRepository.getAll();
        fenotipagemList = fenotipagemRepository.getAll();
    }

    public void redirect() {
        paciente = new Paciente();
        pacienteSelecionado = new Paciente();
        pacienteList = new ArrayList<>();

        Faces.redirect("/cadastro/paciente.xhtml");
    }

    public void buscarPaciente() {
        if (camposDeBuscaVazios()) {
            Messages.addFlashGlobalWarn("Preencha um campo para busca.");
        } else if (!paciente.getNome().isEmpty()) {
            buscaPorNome();
        } else if (paciente.getDataNascimento() != null) {
            buscarPorDataNascimento();
        } else if (!paciente.getCpf().isEmpty()) {
            buscarPorCpf();
        } else if (paciente.getFenotipagem() != null) {
            buscarPorFenotipagem();
        }
    }

    private boolean camposDeBuscaVazios() {
        return paciente.getNome().isEmpty() && paciente.getDataNascimento() == null
                && paciente.getCpf().isEmpty() && paciente.getFenotipagem() == null;
    }

    private void buscaPorNome() {
        pacienteList = pacienteRepository.getByNome(paciente.getNome());

        ListaUtil.verificaTamanhoLista(pacienteList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    private void buscarPorDataNascimento() {
        pacienteList = pacienteRepository.getByDataNascimento(paciente.getDataNascimento());

        ListaUtil.verificaTamanhoLista(pacienteList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    private void buscarPorCpf() {
        pacienteList = pacienteRepository.getByCpf(paciente.getCpf());

        ListaUtil.verificaTamanhoLista(pacienteList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    private void buscarPorFenotipagem() {
        pacienteList = pacienteRepository.getByFenotipagem(paciente.getFenotipagem());

        ListaUtil.verificaTamanhoLista(pacienteList);
    }

    public void update() {
        pacienteRepository.update(pacienteSelecionado);

        GrowlView.showInfo("Sucesso", "Registro editado com sucesso.");
    }

    public void delete() {
        pacienteRepository.delete(pacienteSelecionado);

        /* Remover objeto do arrayList */
        pacienteList.remove(pacienteSelecionado);
        GrowlView.showWarn("Removido", "Registro removido com sucesso.");
    }

    public String exibirAnticorposString(List<Anticorpo> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Anticorpo item : list) {
            sb.append(item).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

}
