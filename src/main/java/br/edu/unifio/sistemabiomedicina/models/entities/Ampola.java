package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_ampola")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ampola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigoInternacao;
    private Integer ampolaMl;
    private LocalDate dataCadastro;
    private LocalDate dataValidade;

    @ManyToOne
    private Paciete paciete;

}
