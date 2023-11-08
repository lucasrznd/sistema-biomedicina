package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_ampola")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ampola implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    private Long codigoInternacao;
    private Integer ampolaMl;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "tb_anticorpo_ampola", joinColumns = {@JoinColumn(name = "id_ampola")},
            inverseJoinColumns = {@JoinColumn(name = "id_anticorpo")})
    private List<Anticorpo> anticorpos;
    private String tituloAnticorpo;

    private LocalDate dataCadastro;
    private LocalDate dataValidade;

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
