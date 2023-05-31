package com.example.testeSantander.dto.mapper;

import com.example.testeSantander.dto.ClienteDTO;
import com.example.testeSantander.dto.PageDTO;
import com.example.testeSantander.model.Cliente;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface ClienteMapper {

    ClienteDTO toDTO(Cliente cliente);

    PageDTO<ClienteDTO> toPageDTOs(Page<Cliente> clientes);

    Cliente toCliente(ClienteDTO clienteDTO);
}
