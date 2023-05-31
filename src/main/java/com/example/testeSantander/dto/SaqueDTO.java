package com.example.testeSantander.dto;

import com.example.testeSantander.model.TipoTransacao;

public class SaqueDTO extends TransacaoDTO {


    public SaqueDTO() {
        this.tipoTransacao = TipoTransacao.SAQUE;
    }
}
