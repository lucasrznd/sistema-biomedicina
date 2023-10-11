package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FenotipagemRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Fenotipagem> getAll() {
        Query query = em.createQuery("SELECT f FROM Fenotipagem f");
        return query.getResultList();
    }

    public Fenotipagem getById(Fenotipagem fenotipagem) {
        return em.find(Fenotipagem.class, fenotipagem.getId());
    }

    public List<Fenotipagem> getByTipagemAbo(String tipagemAbo) {
        Query query = em.createQuery("SELECT f FROM Fenotipagem f where f.tipagemAbo LIKE:tipagemAbo");
        query.setParameter("tipagemAbo", "%" + tipagemAbo + "%");
        return query.getResultList();
    }

    public List<Fenotipagem> getByTipagemRh(Character tipagemRh) {
        Query query = em.createQuery("SELECT f FROM Fenotipagem f where f.tipagemRh LIKE:tipagemRh");
        query.setParameter("tipagemRh", "%" + tipagemRh + "%");
        return query.getResultList();
    }


    @Transactional
    public void insert(Fenotipagem fenotipagem) {
        em.persist(fenotipagem);
    }

    @Transactional
    public void update(Fenotipagem fenotipagem) {
        Fenotipagem fenotipagemEncontrada = getById(fenotipagem);

        fenotipagemEncontrada.setTipagemRh(fenotipagem.getTipagemRh());
        fenotipagemEncontrada.setTipagemAbo(fenotipagem.getTipagemAbo());

        em.persist(fenotipagemEncontrada);
    }

    @Transactional
    public void delete(Fenotipagem fenotipagem) {
        em.remove(fenotipagem.getId());
    }
}
