package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.PostPersist;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class FenotipagemController {

    private Fenotipagem fenotipagem = new Fenotipagem();

    @Autowired
    private FenotipagemRepository fenotipagemRepository;

    public void insert() {
        fenotipagemRepository.insert(fenotipagem);

        fenotipagem = new Fenotipagem();
        Messages.addFlashGlobalInfo("Fenotipagem salva com sucesso");
    }

    public String getFenotipagemTotal() {
        return fenotipagem.getTipagemAbo() + fenotipagem.getTipagemRh();
    }

}
