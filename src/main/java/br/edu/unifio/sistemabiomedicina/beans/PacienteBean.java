package br.edu.unifio.sistemabiomedicina.beans;

import br.edu.unifio.sistemabiomedicina.domain.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.domain.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class PacienteBean implements Serializable {

    @Autowired
    private PacienteRepository repository;
    private Paciente paciente;
    private List<Paciente> pacientes;

    @Autowired
    private FenotipagemRepository fenotipagemRepository;
    private List<Fenotipagem> fenotipagens;

    @PostConstruct
    public void listar() {
        try {
            pacientes = repository.findAll();
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao listar os pacientes.");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            paciente = new Paciente();
            fenotipagens = fenotipagemRepository.findAll();
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao buscar as fenotipagens.");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            repository.save(paciente);

            novo();
            listar();

            Messages.addFlashGlobalInfo("Paciente salvo com sucesso.");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao salvar o paciente.");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        paciente = (Paciente) evento.getComponent().getAttributes().get("pacienteSelecionado");
    }

    public void excluir(ActionEvent evento) {
        try {
            paciente = (Paciente) evento.getComponent().getAttributes().get("pacienteSelecionado");

            repository.delete(paciente);
            novo();
            listar();

            Messages.addFlashGlobalInfo("Paciente removido com sucesso.");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao remover o paciente.");
            erro.printStackTrace();
        }
    }
}
