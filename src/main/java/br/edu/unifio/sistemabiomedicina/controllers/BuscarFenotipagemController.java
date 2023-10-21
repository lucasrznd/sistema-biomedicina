package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
public class BuscarFenotipagemController implements Serializable {

    @Autowired
    private FenotipagemRepository fenotipagemRepository;
    private List<Fenotipagem> fenotipagemList;
    private Fenotipagem fenotipagem;

    private Fenotipagem fenotipagemSelecionada;

    @PostConstruct
    public void novo() {
        fenotipagem = new Fenotipagem();
        fenotipagemSelecionada = new Fenotipagem();
    }

    public void buscarFenotipagem() {
        System.out.println(fenotipagem.getTipagemAbo());
        if (fenotipagem.getTipagemAbo() != null) {
            fenotipagemList = fenotipagemRepository.getByTipagemAbo(fenotipagem.getTipagemAbo());
            PrimeFaces.current().ajax().update("form:datatable");
        } else {
            // Adicione um método semelhante para buscar por tipagemRh, se necessário
        }
    }

    public void editar() {
        System.out.println("kadskskaakd");
        System.out.println(fenotipagemSelecionada);
        fenotipagem = fenotipagemSelecionada;
    }

    public void edicao() {
        System.out.println("Objeto foi editado uhuull" + fenotipagemSelecionada.getTipagemAbo()
                + ", " + fenotipagemSelecionada.getTipagemRh());
        addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content");
    }

    public void update() {
        //ConfirmView.confirmar();
        fenotipagemRepository.update(fenotipagemSelecionada);
    }

    public void delete() {
        //ConfirmView.delete();
        System.out.println("Item excluído com sucesso.");
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

}
