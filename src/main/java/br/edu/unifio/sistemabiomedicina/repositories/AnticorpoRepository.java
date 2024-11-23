package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.domain.Anticorpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnticorpoRepository extends JpaRepository<Anticorpo, Integer> {
}
