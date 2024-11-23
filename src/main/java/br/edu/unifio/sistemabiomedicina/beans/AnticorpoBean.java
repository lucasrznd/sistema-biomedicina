package br.edu.unifio.sistemabiomedicina.beans;

import br.edu.unifio.sistemabiomedicina.domain.Anticorpo;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
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
public class AnticorpoBean implements Serializable {

    @Autowired
    private AnticorpoRepository repository;
    private Anticorpo anticorpo;
    private List<Anticorpo> anticorpos;

    @PostConstruct
    public void listar() {
        try {
            anticorpos = repository.findAll();
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao listar os anticorpos.");
            erro.printStackTrace();
        }
    }

    public void novo() {
        anticorpo = new Anticorpo();
    }

    public void salvar() {
        try {
            repository.save(anticorpo);

            novo();
            listar();

            Messages.addFlashGlobalInfo("Anticorpo salvo com sucesso.");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao salvar o anticorpo.");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        anticorpo = (Anticorpo) evento.getComponent().getAttributes().get("anticorpoSelecionado");
    }

    public void excluir(ActionEvent evento) {
        try {
            anticorpo = (Anticorpo) evento.getComponent().getAttributes().get("anticorpoSelecionado");

            repository.delete(anticorpo);
            novo();
            listar();

            Messages.addFlashGlobalInfo("Anticorpo removido com sucesso.");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao remover o anticorpo.");
            erro.printStackTrace();
        }
    }

}
