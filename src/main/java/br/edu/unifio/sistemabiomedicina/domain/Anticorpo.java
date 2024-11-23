package br.edu.unifio.sistemabiomedicina.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_anticorpo")
@Getter
@Setter
public class Anticorpo extends GenericDomain {

    @Column(length = 20, nullable = false)
    private String descricao;

}
