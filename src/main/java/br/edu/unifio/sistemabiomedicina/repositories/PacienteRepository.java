package br.edu.unifio.sistemabiomedicina.repositories;

import br.edu.unifio.sistemabiomedicina.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
