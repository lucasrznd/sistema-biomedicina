package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_retirada")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Retirada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Operador operador;

    @ManyToOne
    private Ampola ampola;

    private LocalDateTime dataRetirada;

}
