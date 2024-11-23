package br.edu.unifio.sistemabiomedicina.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_fenotipagem")
@Getter
@Setter
public class Fenotipagem extends GenericDomain {

    @Column(length = 2, nullable = false)
    private String tipagemAbo;

    @Column(length = 1, nullable = false)
    private String tipagemRh;

}
