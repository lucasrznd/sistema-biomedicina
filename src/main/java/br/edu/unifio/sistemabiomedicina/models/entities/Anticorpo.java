package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_anticorpo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anticorpo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String anticorpoIdentificado;
    private Integer tituloAnticorpo;

}
