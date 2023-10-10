package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;

    @ManyToOne
    private Fenotipagem fenotipagem;

}
