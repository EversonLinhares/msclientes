package com.br.curso.ms.clientes.msclientes.domain.service;

import com.br.curso.ms.clientes.msclientes.api.dto.request.ClienteRequestDTO;
import com.br.curso.ms.clientes.msclientes.api.dto.response.ClienteResponseDTO;
import com.br.curso.ms.clientes.msclientes.core.modelmapper.MapperConvert;
import com.br.curso.ms.clientes.msclientes.domain.model.Cliente;
import com.br.curso.ms.clientes.msclientes.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Autowired
    MapperConvert mapperConvert;

    @Transactional
    public Cliente save(ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = clienteRepository.save(mapperConvert.mapDtoToEntity(clienteRequestDTO,Cliente.class));
        return cliente;
    }

    public ClienteResponseDTO findByCpf(String cpf){
        Cliente cliente = clienteRepository.findByCpf(cpf).
                orElseThrow(() -> new RuntimeException("Não foi encontrado cliente com cpf informado: " + cpf));
        return mapperConvert.mapEntityToDto(cliente, ClienteResponseDTO.class);
    }

}
