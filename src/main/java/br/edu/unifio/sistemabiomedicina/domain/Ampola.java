package br.edu.unifio.sistemabiomedicina.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_ampola")
@Getter
@Setter
public class Ampola extends GenericDomain {

    @ManyToOne
    private Paciente paciente;

    @Column(nullable = false)
    private Long codigoInternacao;

    @Column(nullable = false)
    private Short ampolaMl;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "tb_anticorpo_ampola", joinColumns = {@JoinColumn(name = "id_ampola")},
            inverseJoinColumns = {@JoinColumn(name = "id_anticorpo")})
    private List<Anticorpo> anticorpos;

    @Column(length = 20, nullable = false)
    private String tituloAnticorpo;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    @Column(nullable = false)
    private LocalDate dataValidade;

    private Short numeroGaveta;
    private Short numeroCaixa;

    private Boolean statusArmazenamento;

    /* Metódo que retorna o booleano em sim ou não*/
    public String statusDeArmazenamento() {
        if (statusArmazenamento) {
            return "Sim";
        }
        return "Não";
    }

}
