package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.models.entities.Armazenamento;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.services.AmpolaService;
import br.edu.unifio.sistemabiomedicina.services.AnticorpoService;
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
public class CadastroAmpolaController implements Serializable {

    @Autowired
    private AmpolaService ampolaService;
    private Ampola ampola;

    @Autowired
    private PacienteService pacienteService;

    private Armazenamento armazenamento;

    @Autowired
    private AnticorpoService anticorpoService;
    private List<Anticorpo> anticorpoList;

    @PostConstruct
    public void novo() {
        ampola = new Ampola();
        armazenamento = new Armazenamento();

        anticorpoList = anticorpoService.getAll();
    }

    public void insert() {
        ampola.setArmazenamento(armazenamento);
        ampolaService.insert(ampola);

        /* Retorna mensagem de sucesso. */
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso");
    }

    public List<Paciente> buscarPaciente(String nome) {
        List<Paciente> pacientesEncontrados = pacienteService.getByNome(nome);

        if (pacientesEncontrados.isEmpty()) {
            Messages.addFlashGlobalError("Paciente não encontrado");
        }
        return pacientesEncontrados;
    }

    public void onItemUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item removido: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
