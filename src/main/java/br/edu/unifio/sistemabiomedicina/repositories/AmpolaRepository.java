package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AmpolaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Ampola> getALL() {
        Query query = em.createQuery("SELECT a FROM Ampola a");
        return query.getResultList();
    }

    public List<Ampola> ultimasCadastradas() {
        /* 3 últimos cadastrados */
        Query query = em.createQuery("SELECT a FROM Ampola a ORDER BY a.id");
        query.setMaxResults(3);
        return query.getResultList();
    }

    public Ampola getById(Ampola ampola) {
        return em.find(Ampola.class, ampola.getId());
    }

    public List<Ampola> getByNomePaciente(String nomePaciente) {
        Query query = em.createQuery("SELECT a FROM Ampola a WHERE a.paciente.nome LIKE:nomePaciente");
        query.setParameter("nomePaciente", "%" + nomePaciente + "%");
        return query.getResultList();
    }

    public Ampola getByCodigoInternacao(Ampola ampola) {
        return em.find(Ampola.class, ampola.getAmpolaMl());
    }

    public Ampola getByDataCadastro(Ampola ampola) {
        return em.find(Ampola.class, ampola.getDataCadastro());
    }

    public Ampola getByDataValidade(Ampola ampola) {
        return em.find(Ampola.class, ampola.getDataValidade());
    }

    @Transactional
    public void insert(Ampola ampola) {
        em.persist(ampola);
    }

    @Transactional
    public void update(Ampola ampola) {
        Ampola ampolaEncontrada = getById(ampola);

        ampolaEncontrada.setCodigoInternacao(ampola.getCodigoInternacao());
        ampolaEncontrada.setPaciente(ampola.getPaciente());
        ampolaEncontrada.setAmpolaMl(ampola.getAmpolaMl());
        ampolaEncontrada.setDataCadastro(ampola.getDataCadastro());
        ampolaEncontrada.setDataValidade(ampola.getDataValidade());

        em.persist(ampolaEncontrada);
    }

    @Transactional
    public void delete(Ampola ampola) {
        em.remove(ampola.getId());
    }

}
