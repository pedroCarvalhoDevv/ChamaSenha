package com.chamagente.ChamaSenha.service;

import com.chamagente.ChamaSenha.model.StatusSenha;
import com.chamagente.ChamaSenha.model.dto.ClienteDto;
import com.chamagente.ChamaSenha.model.entity.Cliente;
import com.chamagente.ChamaSenha.model.entity.Senha;
import com.chamagente.ChamaSenha.repository.ClienteRepository;
import com.chamagente.ChamaSenha.repository.SenhaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SenhaService {

    @Autowired
    private SenhaRepository senhaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Senha gerarSenha(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        Integer proximaSenha = senhaRepository.findMaxNumeroSenha().orElse(0) + 1;

        Senha senha = new Senha();
        senha.setNumeroSenha(proximaSenha);
        senha.setCliente(cliente);
        senha.setStatus(StatusSenha.AGUARDANDO);
        senha.setHorarioCriacao(LocalDateTime.now());

        return senhaRepository.save(senha);
    }

    public Senha chamarProximaSenha() {
        // Marcar a atual como ATENDIDA
        senhaRepository.findFirstByStatus(StatusSenha.CHAMADA)
                .ifPresent(s -> {
                    s.setStatus(StatusSenha.ATENDIDA);
                    senhaRepository.save(s);
                });

        Senha proxima = senhaRepository.findFirstByStatusOrderByHorarioCriacaoAsc(StatusSenha.AGUARDANDO)
                .orElseThrow(() -> new RuntimeException("Nenhuma senha aguardando"));

        proxima.setStatus(StatusSenha.CHAMADA);
        proxima.setHorarioChamada(LocalDateTime.now());
        return senhaRepository.save(proxima);
    }
    public List<Senha> getTodasAsSenhasDaFila() {
        return senhaRepository.findAllByOrderByHorarioCriacaoAsc();
    }

    public Senha getSenhaAtual() {
        return senhaRepository.findFirstByStatus(StatusSenha.CHAMADA)
                .orElse(null);
    }

    public List<Senha> getFilaDeEspera() {
        return senhaRepository.findAllByStatusOrderByHorarioCriacaoAsc(StatusSenha.AGUARDANDO);
    }


}


