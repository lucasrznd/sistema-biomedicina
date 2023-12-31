package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.utils.StringUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public Fenotipagem getById(Long id) {
        return em.find(Fenotipagem.class, id);
    }

    public List<Fenotipagem> buscaDinamica(Fenotipagem fenotipagem) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Fenotipagem.class);
        Root<Fenotipagem> root = criteriaQuery.from(Fenotipagem.class);

        List<Predicate> predicates = new ArrayList<>();

        if (!fenotipagem.getTipagemAbo().isBlank()) {
            predicates.add(criteriaBuilder.equal(root.get("tipagemAbo"), fenotipagem.getTipagemAbo()));
        }

        if (!fenotipagem.getTipagemRh().isBlank()) {
            predicates.add(criteriaBuilder.equal(root.get("tipagemRh"), fenotipagem.getTipagemRh()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<Fenotipagem> getByTipagemAbo(String tipagemAbo) {
        Query query = em.createQuery("SELECT f FROM Fenotipagem f where f.tipagemAbo LIKE:tipagemAbo");
        query.setParameter("tipagemAbo", "%" + tipagemAbo + "%");
        return query.getResultList();
    }

    public List<Fenotipagem> getByFenotipagemCompleta(String tipagemAbo, String tipagemRh) {
        Query query = em.createQuery("SELECT f FROM Fenotipagem f WHERE f.tipagemAbo = :tipagemAbo AND f.tipagemRh = :tipagemRh");
        query.setParameter("tipagemAbo", tipagemAbo);
        query.setParameter("tipagemRh", tipagemRh);
        return query.getResultList();
    }

    public List<Fenotipagem> getByTipagemRh(String tipagemRh) {
        Query query = em.createQuery("SELECT f FROM Fenotipagem f where f.tipagemRh LIKE:tipagemRh");
        query.setParameter("tipagemRh", "%" + tipagemRh + "%");
        return query.getResultList();
    }


    @Transactional
    public void insert(Fenotipagem fenotipagem) {
        // Converte os atributos que sao String para UPPERCASE
        StringUtil.convertToUpperCase(fenotipagem);

        em.persist(fenotipagem);
    }

    @Transactional
    public void update(Fenotipagem fenotipagem) {
        // Converte os atributos que sao String para UPPERCASE
        StringUtil.convertToUpperCase(fenotipagem);

        em.merge(fenotipagem);
    }

    @Transactional
    public void delete(Fenotipagem fenotipagem) {
        em.remove(em.contains(fenotipagem) ? fenotipagem : em.merge(fenotipagem));
    }
}
