package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_anticorpo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anticorpo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String anticorpoIdentificado;

    @ManyToMany(mappedBy = "anticorpos")
    private List<Ampola> ampola;

    @Override
    public String toString() {
        return anticorpoIdentificado;
    }

}
