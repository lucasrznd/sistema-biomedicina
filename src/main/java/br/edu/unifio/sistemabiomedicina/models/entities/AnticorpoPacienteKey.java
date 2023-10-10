package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AnticorpoPacienteKey implements Serializable {

    @Column(name = "id_anticorpo")
    Long idAnticorpo;

    @Column(name = "id_paciente")
    Long idPaciente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnticorpoPacienteKey that = (AnticorpoPacienteKey) o;
        return Objects.equals(idAnticorpo, that.idAnticorpo) && Objects.equals(idPaciente, that.idPaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnticorpo, idPaciente);
    }
}
