package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "tb_anticorpos_paciente")
@Data
public class AnticorpoPaciente implements Serializable {

    @EmbeddedId
    AnticorpoPacienteKey id;

    @ManyToOne
    @MapsId("idAnticorpo")
    @JoinColumn(name = "id_anticorpo")
    Anticorpo anticorpo;

    @ManyToOne
    @MapsId("idPaciente")
    @JoinColumn(name = "id_paciente")
    Paciente paciente;

}
