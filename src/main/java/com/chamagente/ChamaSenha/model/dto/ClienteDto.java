package com.chamagente.ChamaSenha.model.dto;

public class ClienteDto {
    private Long id;
    private String nome;
    private String cpf;

    public ClienteDto() {
    }

    public ClienteDto(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

}
