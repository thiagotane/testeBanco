package com.example.testeSantander.service;

import com.example.testeSantander.dto.SaqueDTO;

import java.math.BigDecimal;

public interface SaqueService {
    BigDecimal calcularSaqueComTaxas(boolean planoExclusive, SaqueDTO saqueDTO);
}
