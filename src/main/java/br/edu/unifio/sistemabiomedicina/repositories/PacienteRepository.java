package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Fenotipagem;
import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.utils.StringUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Paciente> getAll() {
        Query query = em.createQuery("SELECT p FROM Paciente p");
        return query.getResultList();
    }

    public Paciente getById(Paciente paciente) {
        return em.find(Paciente.class, paciente.getId());
    }

    public Paciente getById(Long id) {
        return em.find(Paciente.class, id);
    }

    public List<Paciente> buscaDinamica(Paciente paciente) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Paciente> criteriaQuery = criteriaBuilder.createQuery(Paciente.class);
        Root<Paciente> root = criteriaQuery.from(Paciente.class);

        List<Predicate> predicates = new ArrayList<>();

        if (paciente.getNome() != null && !paciente.getNome().isBlank()) {
            predicates.add(criteriaBuilder.like(root.get("nome"), "%" + paciente.getNome() + "%"));
        }

        if (paciente.getDataNascimento() != null) {
            predicates.add(criteriaBuilder.equal(root.get("dataNascimento"), paciente.getDataNascimento()));
        }

        if (paciente.getCpf() != null && !paciente.getCpf().isBlank()) {
            predicates.add(criteriaBuilder.equal(root.get("cpf"), paciente.getCpf()));
        }

        if (paciente.getFenotipagem() != null) {
            predicates.add(criteriaBuilder.equal(root.get("fenotipagem"), paciente.getFenotipagem()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<Paciente> getByNome(String nome) {
        Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.nome LIKE:nome");
        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }

    public List<Paciente> getByDataNascimento(LocalDate dataNascimento) {
        Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.dataNascimento = :dataNascimento");
        query.setParameter("dataNascimento", dataNascimento);
        return query.getResultList();
    }

    public List<Paciente> getByCpf(String cpf) {
        Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.cpf = :cpf");
        query.setParameter("cpf", cpf);
        return query.getResultList();
    }

    public List<Paciente> getByFenotipagem(Fenotipagem fenotipagem) {
        Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.fenotipagem = :fenotipagem");
        query.setParameter("fenotipagem", fenotipagem);
        return query.getResultList();
    }

    @Transactional
    public void insert(Paciente paciente) {
        // Converte os atributos que sao String para UPPERCASE
        StringUtil.convertToUpperCase(paciente);

        em.persist(paciente);
    }

    @Transactional
    public void update(Paciente paciente) {
        // Converte os atributos que sao String para UPPERCASE
        StringUtil.convertToUpperCase(paciente);

        em.merge(paciente);
    }

    @Transactional
    public void delete(Paciente paciente) {
        em.remove(em.contains(paciente) ? paciente : em.merge(paciente));
    }
}
