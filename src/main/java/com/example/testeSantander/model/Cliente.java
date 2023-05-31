package com.example.testeSantander.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<Transacao> transacoes;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Boolean planoExclusive;
    private BigDecimal saldo;
    private String numeroDaConta;
    private Date dataDeNascimento;

    public void addTransacao(Transacao transacao) {
        transacoes.add(transacao);
        transacao.setCliente(this);
    }


}
