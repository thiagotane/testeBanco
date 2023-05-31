package com.example.testeSantander.service.impl;

import com.example.testeSantander.dto.SaqueDTO;
import com.example.testeSantander.exception.ClienteNotFoundException;
import com.example.testeSantander.repository.ClienteRepository;
import com.example.testeSantander.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {
    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void saque_clienteIdNaoEncontrado_exception() {
        Mockito.when(clienteRepository.findById(13)).thenReturn(Optional.empty());
        assertThrows(ClienteNotFoundException.class, () ->  {clienteService.saque(13, new SaqueDTO());});
    }
}