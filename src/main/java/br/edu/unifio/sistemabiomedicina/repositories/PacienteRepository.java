package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import br.edu.unifio.sistemabiomedicina.utils.StringUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    public List<Paciente> getByNome(String nome) {
        Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.nome LIKE:nome");
        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }

    public List<Paciente> getBySobrenome(String sobrenome) {
        Query query = em.createQuery("SELECT p FROM Paciente p WHERE p.sobrenome LIKE:sobrenome");
        query.setParameter("sobrenome", "%" + sobrenome + "%");
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

    @Transactional
    public void insert(Paciente paciente) {
        // Converte os atributos que sao String para UPPERCASE
        StringUtil.convertToUpperCase(paciente);

        em.persist(paciente);
    }

    @Transactional
    public void update(Paciente paciente) {
        Paciente pacienteEncontrado = getById(paciente);

        pacienteEncontrado.setNome(paciente.getNome());
        pacienteEncontrado.setSobrenome(paciente.getSobrenome());
        pacienteEncontrado.setCpf(paciente.getCpf());
        pacienteEncontrado.setDataNascimento(paciente.getDataNascimento());
        pacienteEncontrado.setFenotipagem(paciente.getFenotipagem());

        // Converte os atributos que sao String para UPPERCASE
        StringUtil.convertToUpperCase(pacienteEncontrado);

        em.persist(pacienteEncontrado);
    }

    @Transactional
    public void delete(Paciente paciente) {
        em.remove(em.contains(paciente) ? paciente : em.merge(paciente));
    }
}
