package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Retirada;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RetiradaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Retirada> getAll() {
        Query query = em.createQuery("SELECT r FROM Retirada r ORDER BY r.dataRetirada DESC");
        return query.getResultList();
    }

    public List<Retirada> getByCodigoOperador(Long codigoOperador) {
        Query query = em.createQuery("SELECT r FROM Retirada r WHERE r.operador.id = :codigoOperador " +
                "ORDER BY r.dataRetirada DESC");
        query.setParameter("codigoOperador", codigoOperador);
        return query.getResultList();
    }

    public List<Retirada> getByDataRetirada(LocalDate dataRetirada) {
        Query query = em.createQuery("SELECT r FROM Retirada r WHERE DATE(r.dataRetirada) = :dataRetirada");
        query.setParameter("dataRetirada", dataRetirada);
        return query.getResultList();
    }

    @Transactional
    public void insert(Retirada retirada) {
        em.persist(retirada);
    }

    @Transactional
    public void update(Retirada retirada) {
        em.merge(retirada);
    }

}
