package com.example.testeSantander.service;

import com.example.testeSantander.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface ClienteService {
    PageDTO<ClienteDTO> getPageCliente(int page, int size);


    ClienteDTO saveCliente(ClienteDTO cliente);


    ClienteDTO deposito(int clienteId, DepositoDTO depositoDTO);

    List<TransacaoDTO> historico(int clienteId, LocalDate data);

    ClienteDTO saque(int clienteId, SaqueDTO saqueDTO);
}
