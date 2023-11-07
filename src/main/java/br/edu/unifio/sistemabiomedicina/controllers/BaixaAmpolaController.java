package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ViewScoped
@Data
public class BaixaAmpolaController implements Serializable {

    @Autowired
    private AmpolaRepository ampolaRepository;
    private Ampola ampola;

    @PostConstruct
    public void load() {
        ampola = Faces.getFlashAttribute("ampolaSelecionada");
    }

    public void darBaixa() {
        ampola.setStatusArmazenamento(false);
        ampolaRepository.update(ampola);

        /* Redireciona para a tela de busca */
        Faces.redirect("/buscar/ampola.xhtml");
    }

}
