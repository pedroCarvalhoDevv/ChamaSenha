package com.chamagente.ChamaSenha.repository;

import com.chamagente.ChamaSenha.model.StatusSenha;
import com.chamagente.ChamaSenha.model.entity.Senha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SenhaRepository extends JpaRepository <Senha , Long> {
    Optional<Senha> findFirstByStatusOrderByHorarioCriacaoAsc(StatusSenha status); // CERTO

    @Query("SELECT MAX(s.numeroSenha) FROM Senha s" )
    Optional<Integer> findMaxNumeroSenha();

    List<Senha> findAllByOrderByHorarioCriacaoAsc();


    Optional<Senha> findFirstByStatus(StatusSenha status); // CORRETO

    List<Senha> findAllByStatusOrderByHorarioCriacaoAsc(StatusSenha status);

}
