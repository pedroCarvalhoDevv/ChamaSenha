package com.chamagente.ChamaSenha.controller;

import com.chamagente.ChamaSenha.model.dto.ClienteDto;
import com.chamagente.ChamaSenha.model.dto.SenhaDto;
import com.chamagente.ChamaSenha.model.entity.Cliente;
import com.chamagente.ChamaSenha.model.entity.Senha;
import com.chamagente.ChamaSenha.service.ClienteService;
import com.chamagente.ChamaSenha.service.SenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/senhas")
public class SenhaController {

    @Autowired
    private SenhaService senhaService;

    // Rota 1: Gera senha para um cliente
    @PostMapping("/{clienteId}")
    public ResponseEntity<Senha> gerarSenha(@PathVariable Long clienteId) {
        Senha novaSenha = senhaService.gerarSenha(clienteId);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSenha);
    }

    // Rota 2: Retorna a senha que está sendo chamada agora
    @GetMapping("/atual")
    public ResponseEntity<Senha> senhaAtual() {
        Senha atual = senhaService.getSenhaAtual();
        if (atual == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atual);
    }
    @GetMapping("/fila/todos")
    public ResponseEntity<List<Senha>> listarTodaFila() {
        return ResponseEntity.ok(senhaService.getTodasAsSenhasDaFila());
    }

    // Rota 3: Chama a próxima senha da fila
    @PutMapping("/proxima")
    public ResponseEntity<Senha> chamarProxima() {
        Senha proxima = senhaService.chamarProximaSenha();
        return ResponseEntity.ok(proxima);
    }
    @GetMapping("/fila")
    public ResponseEntity<List<Senha>> listarFila() {
        List<Senha> fila = senhaService.getFilaDeEspera();
        return ResponseEntity.ok(fila);
    }

}
