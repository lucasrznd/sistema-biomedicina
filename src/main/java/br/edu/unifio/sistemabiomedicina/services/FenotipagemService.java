package br.edu.unifio.sistemabiomedicina.services;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.repositories.FenotipagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class FenotipagemService implements Serializable {

    @Autowired
    private FenotipagemRepository fenotipagemRepository;

    public List<Fenotipagem> getAll() {
        return fenotipagemRepository.getAll();
    }

    public List<Fenotipagem> getByTipagemAbo(String tipagemAbo) {
        return fenotipagemRepository.getByTipagemAbo(tipagemAbo);
    }

    public List<Fenotipagem> getByTipagemRh(String tipagemRh) {
        return fenotipagemRepository.getByTipagemRh(tipagemRh);
    }

    public void insert(Fenotipagem fenotipagem) {
        fenotipagemRepository.insert(fenotipagem);
    }

    public void update(Fenotipagem fenotipagem) {
        fenotipagemRepository.update(fenotipagem);
    }

    public void delete(Fenotipagem fenotipagem) {
        fenotipagemRepository.delete(fenotipagem);
    }

}
