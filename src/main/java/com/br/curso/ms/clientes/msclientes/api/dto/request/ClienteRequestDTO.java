package com.br.curso.ms.clientes.msclientes.api.dto.request;

import lombok.Data;

@Data
public class ClienteRequestDTO {

    private String cpf;
    private String nome;
    private Integer idade;

}
