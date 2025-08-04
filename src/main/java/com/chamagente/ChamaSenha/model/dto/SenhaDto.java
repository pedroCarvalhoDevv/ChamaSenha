package com.chamagente.ChamaSenha.model.dto;

import com.chamagente.ChamaSenha.model.StatusSenha;
import com.chamagente.ChamaSenha.model.entity.Senha;

import java.time.LocalDateTime;

public class SenhaDto {

        private Long id;
        private Integer numeroSenha;
        private String nomeCliente;
        private StatusSenha status;


        // Construtor para facilitar a conversão
        public SenhaDto(Senha senha) {
            this.id = senha.getId();
            this.numeroSenha = senha.getNumeroSenha();
            this.nomeCliente = senha.getCliente().getNome();
            this.status = senha.getStatus();

        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroSenha() {
        return numeroSenha;
    }

    public void setNumeroSenha(Integer numeroSenha) {
        this.numeroSenha = numeroSenha;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public StatusSenha getStatus() {
        return status;
    }

    public void setStatus(StatusSenha status) {
        this.status = status;
    }
}


