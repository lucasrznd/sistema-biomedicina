package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.services.FenotipagemService;
import br.edu.unifio.sistemabiomedicina.services.PacienteService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
public class CadastroPacienteController implements Serializable {

    /* Paciente */
    @Autowired
    private PacienteService pacienteService;
    private Paciente paciente;

    /* Fenotipagem */
    @Autowired
    private FenotipagemService fenotipagemService;
    private List<Fenotipagem> fenotipagemList;

    @PostConstruct
    public void novo() {
        paciente = new Paciente();

        fenotipagemList = fenotipagemService.getAll();
    }

    public void insert() {
        pacienteService.insert(paciente);

        /* Retorna mensagem de sucesso. */
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso");
    }

    public void onItemUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item removido: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
