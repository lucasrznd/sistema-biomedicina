package br.edu.unifio.sistemabiomedicina.beans;

import br.edu.unifio.sistemabiomedicina.domain.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.event.ActionEvent;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class FenotipagemBean implements Serializable {

    @Autowired
    private FenotipagemRepository repository;
    private Fenotipagem fenotipagem;
    private List<Fenotipagem> fenotipagems;

    @PostConstruct
    public void listar() {
        try {
            fenotipagems = repository.findAll();
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao listar as fenotipagens.");
            erro.printStackTrace();
        }
    }

    public void novo() {
        fenotipagem = new Fenotipagem();
    }

    public void salvar() {
        try {
            repository.save(fenotipagem);

            novo();
            listar();

            Messages.addFlashGlobalInfo("Fenotipagem salva com sucesso.");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao salvar a fenotipagem.");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        fenotipagem = (Fenotipagem) evento.getComponent().getAttributes().get("fenotipagemSelecionada");
    }

    public void excluir(ActionEvent evento) {
        try {
            fenotipagem = (Fenotipagem) evento.getComponent().getAttributes().get("fenotipagemSelecionada");

            repository.delete(fenotipagem);
            novo();
            listar();

            Messages.addFlashGlobalInfo("Fenotipagem removida com sucesso.");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao remover a fenotipagem.");
            erro.printStackTrace();
        }
    }
}
