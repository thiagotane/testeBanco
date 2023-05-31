package com.example.testeSantander.controller;

import com.example.testeSantander.dto.*;
import com.example.testeSantander.exception.ClienteNotFoundException;
import com.example.testeSantander.service.ClienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/cliente")
@Validated
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public PageDTO<ClienteDTO> getPageCliente(@RequestParam int page, @RequestParam int size) {
        return clienteService.getPageCliente(page, size);
    }

    @PostMapping
    public ClienteDTO newCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        return clienteService.saveCliente(clienteDTO);
    }

    @PostMapping("/{id}/saque")
    public ClienteDTO saque(@PathVariable int id, @RequestBody SaqueDTO saqueDTO) {
        try {
            return clienteService.saque(id, saqueDTO);
        } catch (ClienteNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @PostMapping("/{id}/deposito")
    public ClienteDTO deposito(@PathVariable int id, @RequestBody DepositoDTO depositoDTO) {
        try {
            return clienteService.deposito(id, depositoDTO);
        } catch (ClienteNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @GetMapping("/{id}/historico/{data}")
    public List<TransacaoDTO> historico(@PathVariable int id, @PathVariable LocalDate data) {
        return clienteService.historico(id, data);
    }
}
