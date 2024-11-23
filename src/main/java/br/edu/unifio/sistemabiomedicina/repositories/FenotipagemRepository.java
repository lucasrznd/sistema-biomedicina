package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.domain.Fenotipagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FenotipagemRepository extends JpaRepository<Fenotipagem, Long> {
}
