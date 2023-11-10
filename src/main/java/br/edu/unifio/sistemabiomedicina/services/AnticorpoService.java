package br.edu.unifio.sistemabiomedicina.services;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import br.edu.unifio.sistemabiomedicina.repositories.AnticorpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class AnticorpoService implements Serializable {

    @Autowired
    private AnticorpoRepository anticorpoRepository;

    public List<Anticorpo> getAll() {
        return anticorpoRepository.getAll();
    }

    public List<Anticorpo> getByAnticorpoIdentificado(String anticorpoIdentificado) {
        return anticorpoRepository.getByAnticorpoIdentificado(anticorpoIdentificado);
    }

    public void insert(Anticorpo anticorpo) {
        anticorpoRepository.insert(anticorpo);
    }

    public void update(Anticorpo anticorpo) {
        anticorpoRepository.update(anticorpo);
    }

    public void delete(Anticorpo anticorpo) {
        anticorpoRepository.delete(anticorpo);
    }

}
