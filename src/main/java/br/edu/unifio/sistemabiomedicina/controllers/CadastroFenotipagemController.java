package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class CadastroFenotipagemController {

    @Autowired
    private FenotipagemRepository fenotipagemRepository;
    private Fenotipagem fenotipagem;

    @PostConstruct
    public void novo() {
        fenotipagem = new Fenotipagem();
    }

    public void insert() {
        fenotipagemRepository.insert(fenotipagem);

        /*Retorna uma mensagem na tela para o usuário*/
        Messages.addFlashGlobalInfo("Registro armazenado com sucesso.");
    }
}
