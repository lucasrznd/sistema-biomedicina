package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class HomeController {

    @Autowired
    private AmpolaRepository ampolaRepository;
    private List<Ampola> ampolaList = new ArrayList<>();

    @PostConstruct
    public void ultimosCadastrados() {
        ampolaList = ampolaRepository.ultimasCadastradas();
    }
}
