package br.edu.unifio.sistemabiomedicina.services;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import br.edu.unifio.sistemabiomedicina.models.entities.Operador;
import br.edu.unifio.sistemabiomedicina.models.entities.Retirada;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import br.edu.unifio.sistemabiomedicina.repositories.RetiradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class RetiradaService implements Serializable {

    @Autowired
    private AmpolaRepository ampolaRepository;

    @Autowired
    private RetiradaRepository retiradaRepository;

    public List<Retirada> getAll() {
        return retiradaRepository.getAll();
    }

    public List<Retirada> getByCodigoOperador(Long codigoOperador) {
        return retiradaRepository.getByCodigoOperador(codigoOperador);
    }

    public List<Retirada> getByDataRetirada(LocalDate dataRetirada) {
        return retiradaRepository.getByDataRetirada(dataRetirada);
    }

    public void realizarRetirada(List<Ampola> ampolasSelecionadas, Operador operador) {
        for (Ampola amp : ampolasSelecionadas) {
            amp.setStatusArmazenamento(false);
            ampolaRepository.update(amp);

            Retirada retirada = new Retirada(null, operador, amp, LocalDateTime.now());
            retiradaRepository.insert(retirada);
        }
    }

}
