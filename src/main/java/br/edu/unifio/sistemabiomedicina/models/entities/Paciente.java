package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Fenotipagem fenotipagem;

    @ManyToMany
    @JoinTable(name = "tb_anticorpo_paciente", joinColumns = {@JoinColumn(name = "id_paciente")},
            inverseJoinColumns = {@JoinColumn(name = "id_anticorpo")})
    private List<Anticorpo> anticorpos;
    private String tituloAnticorpo;

}
