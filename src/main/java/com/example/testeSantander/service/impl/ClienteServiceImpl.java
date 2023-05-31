package com.example.testeSantander.service.impl;

import com.example.testeSantander.dto.*;
import com.example.testeSantander.dto.mapper.ClienteMapper;
import com.example.testeSantander.dto.mapper.TransacaoMapper;
import com.example.testeSantander.exception.ClienteNotFoundException;
import com.example.testeSantander.model.Cliente;
import com.example.testeSantander.model.Transacao;
import com.example.testeSantander.repository.ClienteRepository;
import com.example.testeSantander.repository.TransacaoRepository;
import com.example.testeSantander.service.ClienteService;
import com.example.testeSantander.service.SaqueService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteMapper clienteMapper;
    private final TransacaoMapper transacaoMapper;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private SaqueService saqueService;

    @Override
    public PageDTO<ClienteDTO> getPageCliente(int page, int size) {
        Pageable plantPage = PageRequest.of(page, size, Sort.by("id"));

        return clienteMapper.toPageDTOs(clienteRepository.findAll(plantPage));
    }

    @Override
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
        return clienteMapper.toDTO(clienteRepository.save(clienteMapper.toCliente(clienteDTO)));
    }

    @Override
    public ClienteDTO saque(int clienteId, SaqueDTO saqueDTO) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteNotFoundException(clienteId));
        BigDecimal saqueMaisTaxas = saqueService.calcularSaqueComTaxas(cliente.getPlanoExclusive(), saqueDTO);
        cliente.setSaldo(cliente.getSaldo().subtract(saqueMaisTaxas));
        cliente.addTransacao(gerarTransacao(saqueDTO));
        clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    @Override
    public ClienteDTO deposito(int clienteId, DepositoDTO depositoDTO) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteNotFoundException(clienteId));
        cliente.setSaldo(cliente.getSaldo().add(depositoDTO.getValor()));
        cliente.addTransacao(gerarTransacao(depositoDTO));
        clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    private Transacao gerarTransacao(TransacaoDTO dto) {
        return transacaoMapper.toTransacao(dto)
                .withDataDaTransacao(LocalDate.now());
    }

    @Override
    public List<TransacaoDTO> historico(int clienteId, LocalDate data) {
        List<Transacao> transacoes = transacaoRepository.findByDataDaTransacaoAndClienteId(data, clienteId).stream().toList();
        return transacaoMapper.toDTOs(transacoes.stream().toList());
    }
}
