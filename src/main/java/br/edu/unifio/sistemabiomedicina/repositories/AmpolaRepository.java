package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Ampola;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    public List<Ampola> getByCodigoInternacao(Long codigoInternacao) {
        Query query = em.createQuery("SELECT a FROM Ampola a WHERE a.codigoInternacao = :codigoInternacao");
        query.setParameter("codigoInternacao", codigoInternacao);
        return query.getResultList();
    }

    public List<Ampola> getByAmpolaMl(Integer ampolaMl) {
        Query query = em.createQuery("SELECT a FROM Ampola a WHERE a.ampolaMl = :ampolaMl");
        query.setParameter("ampolaMl", ampolaMl);
        return query.getResultList();
    }

    public List<Ampola> getByDataCadastro(LocalDate dataCadastro) {
        Query query = em.createQuery("SELECT a FROM Ampola a WHERE a.dataCadastro = :dataCadastro");
        query.setParameter("dataCadastro", dataCadastro);
        return query.getResultList();
    }

    public List<Ampola> getByDataValidade(LocalDate dataValidade) {
        Query query = em.createQuery("SELECT a FROM Ampola a WHERE a.dataValidade = :dataValidade");
        query.setParameter("dataValidade", dataValidade);
        return query.getResultList();
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
