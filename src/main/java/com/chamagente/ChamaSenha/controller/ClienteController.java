package com.chamagente.ChamaSenha.controller;

import com.chamagente.ChamaSenha.model.dto.ClienteDto;
import com.chamagente.ChamaSenha.service.ClienteService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController (ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteDto create(@RequestBody ClienteDto clienteDto){
        return clienteService.create(clienteDto);
    }

    @GetMapping("/findById{id}")
    public ClienteDto findById(@PathVariable Long id){
        return clienteService.findById(id);
    }
}
