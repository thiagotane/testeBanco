package com.example.testeSantander.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal valor;
    @CreationTimestamp
    private LocalDate dataDaTransacao;
    private TipoTransacao tipoTransacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

}
