package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Operador;
import br.edu.unifio.sistemabiomedicina.utils.StringUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OperadorRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Operador> getAll() {
        Query query = em.createQuery("SELECT o FROM Operador o ORDER BY o.id");
        return query.getResultList();
    }

    @Transactional
    public void insert(Operador operador) {
        StringUtil.convertToUpperCase(operador);

        em.persist(operador);
    }

    @Transactional
    public void update(Operador operador) {
        // Converte os atributos que sao String para UPPERCASE
        StringUtil.convertToUpperCase(operador);

        em.merge(operador);
    }

}
