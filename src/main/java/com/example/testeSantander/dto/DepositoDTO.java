package com.example.testeSantander.dto;

import com.example.testeSantander.model.TipoTransacao;

public class DepositoDTO extends TransacaoDTO {

    DepositoDTO() {
        super();
        this.tipoTransacao = TipoTransacao.DEPOSITO;


    }

}
