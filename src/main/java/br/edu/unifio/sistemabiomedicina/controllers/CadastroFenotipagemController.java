package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class CadastroFenotipagemController {

    @Autowired
    private FenotipagemRepository fenotipagemRepository;
    private Fenotipagem fenotipagem = new Fenotipagem();

    public void insert() {
        fenotipagemRepository.insert(fenotipagem);

        fenotipagem = new Fenotipagem();

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Fenotipagem salva com sucesso");
    }
}
