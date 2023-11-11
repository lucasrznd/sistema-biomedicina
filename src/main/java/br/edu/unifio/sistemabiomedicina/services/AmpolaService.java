package br.edu.unifio.sistemabiomedicina.services;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class AmpolaService implements Serializable {

    @Autowired
    private AmpolaRepository ampolaRepository;

    public List<Ampola> getAllTrue() {
        return ampolaRepository.getAllTrue();
    }

    public List<Ampola> buscaDinamica(Ampola ampola) {
        return ampolaRepository.buscaDinamica(ampola);
    }

    public void insert(Ampola ampola) {
        ampolaRepository.insert(ampola);
    }

    public void update(Ampola ampola) {
        ampolaRepository.update(ampola);
    }

    public void delete(Ampola ampola) {
        ampolaRepository.delete(ampola);
    }

}
