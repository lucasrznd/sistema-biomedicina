package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_ampola")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ampola implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigoInternacao;
    private Integer ampolaMl;
    private LocalDate dataCadastro;
    private LocalDate dataValidade;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Armazenamento armazenamento;
    private Boolean statusArmazenamento;

    /* Metódo que retorna o booleano em sim ou não*/
    public String statusDeArmazenamento() {
        if (statusArmazenamento) {
            return "Sim";
        }
        return "Não";
    }

}
