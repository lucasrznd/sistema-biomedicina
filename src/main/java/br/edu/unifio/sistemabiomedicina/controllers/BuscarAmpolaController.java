package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
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
public class BuscarAmpolaController implements Serializable {

    @Autowired
    private AmpolaRepository ampolaRepository;
    private Ampola ampola;
    private List<Ampola> ampolaList = new ArrayList<>();
    private Ampola ampolaSelecionada;

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostConstruct
    public void novo() {
        ampola = new Ampola();
        ampolaSelecionada = new Ampola();
    }

    public void redirect() {
        ampola = new Ampola();
        ampolaSelecionada = new Ampola();
        ampolaList = new ArrayList<>();

        Faces.redirect("/cadastro/ampolaSelecionada.xhtml");
    }

    public void buscarAmpola() {
        if (camposDeBuscaVazios()) {
            Messages.addFlashGlobalError("Preencha um dos campos para busca.");
        } else if (ampola.getPaciente() != null) {
            buscarPorNomePaciente();
        } else if (ampola.getCodigoInternacao() != null) {
            buscarPorCodigoInternacao();
        } else if (ampola.getAmpolaMl() != null) {
            buscarPorMlAmpola();
        } else if (ampola.getDataCadastro() != null) {
            buscarPorDataCadastro();
        } else if (ampola.getDataValidade() != null) {
            buscarPorDataValidade();
        }
    }

    private boolean camposDeBuscaVazios() {
        return ampola.getPaciente() == null && ampola.getCodigoInternacao() == null
                && ampola.getAmpolaMl() == null && ampola.getDataCadastro() == null
                && ampola.getDataValidade() == null;
    }

    private void buscarPorNomePaciente() {
        ampolaList = ampolaRepository.getByNomePaciente(ampola.getPaciente().getNome());

        ListaUtil.verificaTamanhoLista(ampolaList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    private void buscarPorCodigoInternacao() {
        ampolaList = ampolaRepository.getByCodigoInternacao(ampola.getCodigoInternacao());

        ListaUtil.verificaTamanhoLista(ampolaList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    private void buscarPorMlAmpola() {
        ampolaList = ampolaRepository.getByAmpolaMl(ampola.getAmpolaMl());

        ListaUtil.verificaTamanhoLista(ampolaList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    private void buscarPorDataCadastro() {
        ampolaList = ampolaRepository.getByDataCadastro(ampola.getDataCadastro());

        ListaUtil.verificaTamanhoLista(ampolaList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    private void buscarPorDataValidade() {
        ampolaList = ampolaRepository.getByDataValidade(ampola.getDataValidade());

        ListaUtil.verificaTamanhoLista(ampolaList);
        PrimeFaces.current().ajax().update("form:datatable");
    }

    public List<Paciente> buscarPaciente(String nome) {
        List<Paciente> pacientesEncontrados = pacienteRepository.getByNome(nome);

        if (pacientesEncontrados.isEmpty()) {
            Messages.addFlashGlobalWarn("Nenhum registro encontrado.");
        }
        return pacientesEncontrados;
    }

    public void update() {
        ampolaRepository.update(ampolaSelecionada);

        GrowlView.showInfo("Conclúido", "Registro editado com sucesso.");
    }

    public void delete() {
        ampolaRepository.delete(ampolaSelecionada);

        GrowlView.showWarn("Removido", "Registro removido com sucesso.");
    }

    public void darBaixa(Ampola ampolaSelecionada) {
        // Armazena o objeto no escopo do Flash
        Faces.setFlashAttribute("ampolaSelecionada", ampolaSelecionada);

        // Redireciona para a página de dar baixa
        Faces.redirect("/baixa/ampolaSelecionada.xhtml");
    }

}
