package br.edu.unifio.sistemabiomedicina.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "tb_armazenamento")
@Data
public class Armazenamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroGaveta;
    private Integer numeroCaixa;

    public String posicaoFreezer() {
        return getNumeroGaveta() + " | " + getNumeroCaixa();
    }

}
