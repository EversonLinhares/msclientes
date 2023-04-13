package com.br.curso.ms.clientes.msclientes.api.dto.response;

import lombok.Data;

@Data
public class ClienteResponseDTO {

    private Long id;
    private String cpf;
    private String nome;
    private Integer idade;
}
