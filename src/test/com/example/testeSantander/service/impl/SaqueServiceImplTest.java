package com.example.testeSantander.service.impl;

import com.example.testeSantander.dto.SaqueDTO;
import com.example.testeSantander.service.SaqueService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;

class SaqueServiceImplTest {
    BigDecimal taxa1 = new BigDecimal(1.04);
    BigDecimal taxa2 = new BigDecimal(1.10);

    @Test
    void calcularSaqueComTaxas_ClienteExlusiveFaixaIsento_Isento() {
        SaqueService saqueService = new SaqueServiceImpl();
        SaqueDTO saqueDTO = new SaqueDTO();
        saqueDTO.setValor(new BigDecimal(100));
        BigDecimal resultado = saqueService.calcularSaqueComTaxas(true, saqueDTO);
        assertThat(saqueDTO.getValor(), Matchers.comparesEqualTo(resultado));
    }

    @Test
    void calcularSaqueComTaxas_ClienteExlusiveFaixaTaxa1_Isento() {
        SaqueService saqueService = new SaqueServiceImpl();
        SaqueDTO saqueDTO = new SaqueDTO();
        saqueDTO.setValor(new BigDecimal(300));
        BigDecimal resultado = saqueService.calcularSaqueComTaxas(true, saqueDTO);
        assertThat(saqueDTO.getValor(), Matchers.comparesEqualTo(resultado));
    }

    @Test
    void calcularSaqueComTaxas_ClienteExlusiveFaixaTaxa2_Isento() {
        SaqueService saqueService = new SaqueServiceImpl();
        SaqueDTO saqueDTO = new SaqueDTO();
        saqueDTO.setValor(new BigDecimal(400));
        BigDecimal resultado = saqueService.calcularSaqueComTaxas(true, saqueDTO);
        assertThat(saqueDTO.getValor(), Matchers.comparesEqualTo(resultado));
    }

    @Test
    void calcularSaqueComTaxas_ClienteFaixaIsento_Isento() {
        SaqueService saqueService = new SaqueServiceImpl();
        SaqueDTO saqueDTO = new SaqueDTO();
        saqueDTO.setValor(new BigDecimal(100));
        BigDecimal resultado = saqueService.calcularSaqueComTaxas(false, saqueDTO);
        assertThat(saqueDTO.getValor(), Matchers.comparesEqualTo(resultado));
    }

    @Test
    void calcularSaqueComTaxas_ClienteFaixaTaxa1_Taxa1Aplicada() {
        SaqueService saqueService = new SaqueServiceImpl();
        SaqueDTO saqueDTO = new SaqueDTO();
        saqueDTO.setValor(new BigDecimal(300));
        BigDecimal resultado = saqueService.calcularSaqueComTaxas(false, saqueDTO);
        assertThat(saqueDTO.getValor().multiply(taxa1), Matchers.comparesEqualTo(resultado));
    }

    @Test
    void calcularSaqueComTaxas_ClienteFaixaTaxa2_Taxa2Aplicada() {
        SaqueService saqueService = new SaqueServiceImpl();
        SaqueDTO saqueDTO = new SaqueDTO();
        saqueDTO.setValor(new BigDecimal(400));
        BigDecimal resultado = saqueService.calcularSaqueComTaxas(false, saqueDTO);

        assertThat(saqueDTO.getValor().multiply(taxa2), Matchers.comparesEqualTo(resultado));
    }
}