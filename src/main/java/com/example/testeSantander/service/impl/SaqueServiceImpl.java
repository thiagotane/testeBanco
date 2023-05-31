package com.example.testeSantander.service.impl;

import com.example.testeSantander.dto.SaqueDTO;
import com.example.testeSantander.service.SaqueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaqueServiceImpl implements SaqueService {

    final BigDecimal faixaIsento = new BigDecimal(100);
    final BigDecimal faixa1 = new BigDecimal(300);
    final BigDecimal taxa1 = new BigDecimal(1.04);
    final BigDecimal taxa2 = new BigDecimal(1.1);

    @Override
    public BigDecimal calcularSaqueComTaxas(boolean planoExclusive, SaqueDTO saqueDTO) {
        if (planoExclusive || saqueDTO.getValor().compareTo(faixaIsento) <= 0)
            return saqueDTO.getValor();

        if (saqueDTO.getValor().compareTo(faixa1) <= 0)
            return saqueDTO.getValor().multiply(taxa1);

        return saqueDTO.getValor().multiply(taxa2);
    }
}
