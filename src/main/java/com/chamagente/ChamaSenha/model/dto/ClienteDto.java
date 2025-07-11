package com.chamagente.ChamaSenha.model.dto;

public class ClienteDto {
    private Long id;
    private String nome;
    private int cpf;

    public ClienteDto() {
    }

    public ClienteDto(Long id, String nome, int cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
