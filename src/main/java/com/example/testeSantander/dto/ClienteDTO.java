package com.example.testeSantander.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;

@Value
public class ClienteDTO {
    private Integer id;
    @NotNull(message = "Nome é necessário.")
    private String nome;
    @NotNull(message = "Exclusive é necessário.")
    private Boolean planoExclusive;
    @NotNull(message = "Saldo é necessário.")
    private BigDecimal saldo;
    @NotBlank(message = "Numero da Conta é necessário.")
    private String numeroDaConta;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Data de Nascimento é necessário.")
    private Date dataDeNascimento;
}
