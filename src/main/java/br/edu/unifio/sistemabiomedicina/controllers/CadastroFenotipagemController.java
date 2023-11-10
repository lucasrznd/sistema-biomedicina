package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.services.FenotipagemService;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ViewScoped
@Data
public class CadastroFenotipagemController implements Serializable {

    @Autowired
    private FenotipagemService fenotipagemService;
    private Fenotipagem fenotipagem;

    @PostConstruct
    public void novo() {
        fenotipagem = new Fenotipagem();
    }

    public void insert() {
        fenotipagemService.insert(fenotipagem);

        /* Retorna mensagem de sucesso. */
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso.");
    }
}
