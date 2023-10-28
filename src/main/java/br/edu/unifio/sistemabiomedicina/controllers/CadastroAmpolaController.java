package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Armazenamento;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
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

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
public class CadastroAmpolaController implements Serializable {

    @Autowired
    private AmpolaRepository ampolaRepository;
    private Ampola ampola;

    @Autowired
    private PacienteRepository pacienteRepository;

    private Armazenamento armazenamento;

    @Autowired
    private AnticorpoRepository anticorpoRepository;

    @PostConstruct
    public void novo() {
        ampola = new Ampola();
        armazenamento = new Armazenamento();
    }

    public void insert() {
        ampola.setArmazenamento(armazenamento);
        ampolaRepository.insert(ampola);

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso");
    }

    public List<Paciente> buscarPaciente(String nome) {
        List<Paciente> pacientesEncontrados = pacienteRepository.getByNome(nome);

        if (pacientesEncontrados.size() == 0) {
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
