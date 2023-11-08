package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Operador;
import br.edu.unifio.sistemabiomedicina.models.entities.Retirada;
import br.edu.unifio.sistemabiomedicina.repositories.AmpolaRepository;
import br.edu.unifio.sistemabiomedicina.repositories.RetiradaRepository;
import br.edu.unifio.sistemabiomedicina.service.OperadorService;
import br.edu.unifio.sistemabiomedicina.utils.ListaUtil;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Component
@Data
public class HistoricoRetiradaController implements Serializable {

    @Autowired
    private RetiradaRepository retiradaRepository;
    private List<Retirada> retiradaList;
    private Retirada retirada;

    private Operador operador;

    @Autowired
    private AmpolaRepository ampolaRepository;

    @Autowired
    private OperadorService operadorService;

    @PostConstruct
    public void novo() {
        operador = new Operador();
        retirada = new Retirada();

        retiradaList = retiradaRepository.getAll();
    }

    public void redirect() {
        Faces.redirect("/retirada/ampola.xhtml");
    }

    public void buscar() {
        if (camposDeBuscaVazios()) {
            Messages.addFlashGlobalWarn("Preencha um campo para busca.");
            return;
        }

        if (operador.getId() != null) {
            if (operadorService.autenticarOperador(operador)) {
                buscarPorOperador();
            } else {
                Messages.addFlashGlobalError("Código de Operador inválido.");
            }
        }
    }

    private boolean camposDeBuscaVazios() {
        return operador.getId() == null && retirada.getDataRetirada() == null;
    }

    private void buscarPorOperador() {
        retiradaList = retiradaRepository.getByCodigoOperador(operador.getId());

        ListaUtil.verificaTamanhoLista(retiradaList);
    }

    private void buscarPorDataRetirada() {
        /* Converte o atributo LocalDateTime para LocalDate para a consulta*/
        LocalDate dataConvertida = retirada.getDataRetirada().toLocalDate();
        retiradaList = retiradaRepository.getByDataRetirada(dataConvertida);

        ListaUtil.verificaTamanhoLista(retiradaList);
    }

}
