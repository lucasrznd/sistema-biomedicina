package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.models.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Usuario> getAll() {
        Query query = em.createQuery("SELECT u FROM Usuario u");
        return query.getResultList();
    }

    public Usuario getById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getId());
    }

    @Transactional
    public void insert(Usuario usuario) {
        em.persist(usuario);
    }

    @Transactional
    public void update(Usuario usuario) {
        Usuario usuarioEncontrado = getById(usuario);

        usuarioEncontrado.setSenha(usuario.getSenha());

        em.persist(usuarioEncontrado);
    }

    @Transactional
    public void delete(Usuario usuario) {
        em.remove(usuario);
    }
}
