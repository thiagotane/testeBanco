package com.example.testeSantander.dto;

import com.example.testeSantander.model.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TransacaoDTO {

    protected TipoTransacao tipoTransacao;
    private BigDecimal valor;
    private LocalDate dataDaTransacao;

}
