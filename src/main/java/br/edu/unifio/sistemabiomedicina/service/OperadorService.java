package br.edu.unifio.sistemabiomedicina.service;

import br.edu.unifio.sistemabiomedicina.models.entities.Operador;
import br.edu.unifio.sistemabiomedicina.repositories.OperadorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperadorService {

    @Autowired
    private OperadorRepository operadorRepository;
    private List<Operador> operadorList;

    @PostConstruct
    private void novo() {
        operadorList = operadorRepository.getAll();
    }

    public boolean autenticarOperador(Operador operador) {
        for (Operador op : operadorList) {
            if (operador.getId().equals(op.getId())) {
                return true;
            }
        }
        return false;
    }

    public List<Operador> getAll() {
        return operadorRepository.getAll();
    }

}
