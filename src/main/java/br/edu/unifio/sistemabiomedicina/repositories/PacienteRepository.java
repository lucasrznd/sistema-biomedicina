package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PacienteRepository {

    @PersistenceContext
    private EntityManager em;


    public List<Paciente> getALL(){
        Query query = em.createQuery("SELECT p FROM Paciente p");
        return query.getResultList();

    }


    public Paciente getById(Paciente paciente){
        return em.find(Paciente.class, paciente.getId());
    }




    @Transactional
    public void insert(Paciente paciente){em.persist(paciente);}

    @Transactional
    public void update(Paciente paciente){
        Paciente pacienteEncontrado = getById(paciente);



    }



}