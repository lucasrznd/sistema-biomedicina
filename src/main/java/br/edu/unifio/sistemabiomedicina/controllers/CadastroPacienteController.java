package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import br.edu.unifio.sistemabiomedicina.repositories.PacienteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    private Paciente paciente;

    /* Repositories e classes da entidade Fenotipagem */
    @Autowired
    private FenotipagemRepository fenotipagemRepository;
    private List<Fenotipagem> fenotipagemList;

    /* Repositories e classes da entidade Anticorpo */
    @Autowired
    private AnticorpoRepository anticorpoRepository;
    private List<Anticorpo> anticorposList;

    @PostConstruct
    public void novo() {
        paciente = new Paciente();
    }

    public void imprimir() {
        System.out.println(paciente.getAnticorpos());

        for (Anticorpo anticorpo : paciente.getAnticorpos()) {
            System.out.println(anticorpo.getId());
        }
    }

    public void insert() {
        pacienteRepository.insert(paciente);

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso");
    }

    @PostConstruct
    public void listarAnticorpos() {
        anticorposList = anticorpoRepository.getAll();
    }

    @PostConstruct
    public void listarFenotipagens() {
        fenotipagemList = fenotipagemRepository.getAll();
    }

    public void onItemUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item removido: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
