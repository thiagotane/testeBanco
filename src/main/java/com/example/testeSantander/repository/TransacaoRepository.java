package com.example.testeSantander.repository;

import com.example.testeSantander.model.Transacao;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransacaoRepository extends CrudRepository<Transacao, Integer> {

    List<Transacao> findByDataDaTransacaoAndClienteId(LocalDate data, Integer id);
}
