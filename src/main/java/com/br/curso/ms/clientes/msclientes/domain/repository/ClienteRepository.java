package com.br.curso.ms.clientes.msclientes.domain.repository;

import com.br.curso.ms.clientes.msclientes.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByCpf(String cpf);
}
