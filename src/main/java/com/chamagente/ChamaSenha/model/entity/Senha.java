package com.chamagente.ChamaSenha.model.entity;

import com.chamagente.ChamaSenha.model.StatusSenha;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "senha_tb")
public class Senha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Integer numeroSenha;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusSenha status;

    private LocalDateTime horarioCriacao;
    private LocalDateTime horarioChamada;

    public Senha() {
    }

    public Senha(Long id, Integer numeroSenha, Cliente cliente, StatusSenha status, LocalDateTime horarioCriacao, LocalDateTime horarioChamada) {
        Id = id;
        this.numeroSenha = numeroSenha;
        this.cliente = cliente;
        this.status = status;
        this.horarioCriacao = horarioCriacao;
        this.horarioChamada = horarioChamada;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getNumeroSenha() {
        return numeroSenha;
    }

    public void setNumeroSenha(Integer numeroSenha) {
        this.numeroSenha = numeroSenha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusSenha getStatus() {
        return status;
    }

    public void setStatus(StatusSenha status) {
        this.status = status;
    }

    public LocalDateTime getHorarioCriacao() {
        return horarioCriacao;
    }

    public void setHorarioCriacao(LocalDateTime horarioCriacao) {
        this.horarioCriacao = horarioCriacao;
    }

    public LocalDateTime getHorarioChamada() {
        return horarioChamada;
    }

    public void setHorarioChamada(LocalDateTime horarioChamada) {
        this.horarioChamada = horarioChamada;
    }
}
