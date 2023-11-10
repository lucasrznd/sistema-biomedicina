package br.edu.unifio.sistemabiomedicina.services;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Component
public class AmpolaService implements Serializable {

    @Autowired
    private AmpolaRepository ampolaRepository;

    public List<Ampola> getAllTrue() {
        return ampolaRepository.getAllTrue();
    }

    public List<Ampola> getByNomePaciente(String nome) {
        return ampolaRepository.getByNomePaciente(nome);
    }

    public List<Ampola> getByCodigoInternacao(Long codigoInternacao) {
        return ampolaRepository.getByCodigoInternacao(codigoInternacao);
    }

    public List<Ampola> getByDataValidade(LocalDate dataValidade) {
        return ampolaRepository.getByDataValidade(dataValidade);
    }

    public List<Ampola> getByDataCadastro(LocalDate dataCadastro) {
        return ampolaRepository.getByDataCadastro(dataCadastro);
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
