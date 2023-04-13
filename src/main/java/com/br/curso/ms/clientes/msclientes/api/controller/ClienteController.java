package com.br.curso.ms.clientes.msclientes.api.controller;

import com.br.curso.ms.clientes.msclientes.api.dto.request.ClienteRequestDTO;
import com.br.curso.ms.clientes.msclientes.api.dto.response.ClienteResponseDTO;
import com.br.curso.ms.clientes.msclientes.domain.model.Cliente;
import com.br.curso.ms.clientes.msclientes.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
@Slf4j
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteService.save(clienteRequestDTO);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(clienteRequestDTO.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDTO> findDataCliente(@RequestParam("cpf") String cpf) {
        log.info("Obtendo o status do msclientes");
        return ResponseEntity.ok().body(clienteService.findByCpf(cpf));
    }

}
