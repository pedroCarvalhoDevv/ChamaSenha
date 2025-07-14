package com.chamagente.ChamaSenha.repository;

import com.chamagente.ChamaSenha.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente , Long> {
    boolean existsByCpf (String cpf);
}
