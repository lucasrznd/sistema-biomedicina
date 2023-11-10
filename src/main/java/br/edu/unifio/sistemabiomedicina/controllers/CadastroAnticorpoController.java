package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.services.AnticorpoService;
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
public class CadastroAnticorpoController implements Serializable {

    @Autowired
    private AnticorpoService anticorpoService;
    private Anticorpo anticorpo;

    @PostConstruct
    public void novo() {
        anticorpo = new Anticorpo();
    }

    public void insert() {
        anticorpoService.insert(anticorpo);

        /* Retorna mensagem de sucesso. */
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso");
    }

}
