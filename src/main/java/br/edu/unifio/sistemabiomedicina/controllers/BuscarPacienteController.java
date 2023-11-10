package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.services.FenotipagemService;
import br.edu.unifio.sistemabiomedicina.services.PacienteService;
import br.edu.unifio.sistemabiomedicina.utils.GrowlView;
import br.edu.unifio.sistemabiomedicina.utils.ListaUtil;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
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
    private PacienteService pacienteService;
    private Paciente paciente;

    private Paciente pacienteSelecionado;
    private List<Paciente> pacienteList = new ArrayList<>();

    @Autowired
    private FenotipagemService fenotipagemService;
    private List<Fenotipagem> fenotipagemList;

    @PostConstruct
    public void novo() {
        paciente = new Paciente();
        pacienteSelecionado = new Paciente();
        pacienteList = new ArrayList<>();

        fenotipagemList = fenotipagemService.getAll();
    }

    public void redirect() {
        paciente = new Paciente();
        pacienteSelecionado = new Paciente();
        pacienteList = new ArrayList<>();

        Faces.redirect("/cadastro/paciente.xhtml");
    }

    public void buscar() {
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
        pacienteList = pacienteService.getByNome(paciente.getNome());

        ListaUtil.verificaTamanhoLista(pacienteList);
    }

    private void buscarPorDataNascimento() {
        pacienteList = pacienteService.getByDataNascimento(paciente.getDataNascimento());

        ListaUtil.verificaTamanhoLista(pacienteList);
    }

    private void buscarPorCpf() {
        pacienteList = pacienteService.getByCpf(paciente.getCpf());

        ListaUtil.verificaTamanhoLista(pacienteList);
    }

    private void buscarPorFenotipagem() {
        pacienteList = pacienteService.getByFenotipagem(paciente.getFenotipagem());

        ListaUtil.verificaTamanhoLista(pacienteList);
    }

    public void update() {
        pacienteService.update(pacienteSelecionado);

        GrowlView.showInfo("Sucesso", "Registro editado com sucesso.");
    }

    public void delete() {
        pacienteService.delete(pacienteSelecionado);

        /* Remover objeto do arrayList */
        pacienteList.remove(pacienteSelecionado);
        GrowlView.showWarn("Removido", "Registro removido com sucesso.");
    }

}
