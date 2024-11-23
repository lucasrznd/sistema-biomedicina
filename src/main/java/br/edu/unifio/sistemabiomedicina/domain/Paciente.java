package br.edu.unifio.sistemabiomedicina.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
public class Paciente extends GenericDomain {

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 14, nullable = false)
    private String cpf;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Fenotipagem fenotipagem;

}
