package com.example.testeSantander.dto.mapper;

import com.example.testeSantander.dto.TransacaoDTO;
import com.example.testeSantander.model.Transacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TransacaoMapper {

    TransacaoDTO toDTO(Transacao transacao);

    Transacao toTransacao(TransacaoDTO transacao);

    List<TransacaoDTO> toDTOs(List<Transacao> transacoes);
}
