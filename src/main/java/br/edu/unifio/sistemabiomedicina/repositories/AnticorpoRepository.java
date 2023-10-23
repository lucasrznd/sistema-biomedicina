package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Anticorpo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AnticorpoRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Anticorpo> getAll() {
        Query query = em.createQuery("SELECT an FROM Anticorpo an");
        return query.getResultList();
    }

    public Anticorpo getById(Anticorpo anticorpo) {
        return em.find(Anticorpo.class, anticorpo.getId());
    }

    public List<Anticorpo> getByAnticorpoIdentificado(String anticorpoIdentificado) {
        Query query = em.createQuery("SELECT an FROM Anticorpo an where an.anticorpoIdentificado LIKE:anticorpoIdentificado");
        query.setParameter("anticorpoIdentificado", "%" + anticorpoIdentificado + "%");
        return query.getResultList();
    }

    @Transactional
    public void insert(Anticorpo anticorpo) {
        em.persist(anticorpo);
    }

    @Transactional
    public void update(Anticorpo anticorpo) {
        Anticorpo anticorpoEncontrado = getById(anticorpo);

        anticorpoEncontrado.setAnticorpoIdentificado(anticorpo.getAnticorpoIdentificado());

        em.persist(anticorpoEncontrado);
    }

    @Transactional
    public void delete(Anticorpo anticorpo) {
        em.remove(em.contains(anticorpo) ? anticorpo : em.merge(anticorpo));
    }

}
