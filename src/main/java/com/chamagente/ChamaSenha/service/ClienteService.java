package com.chamagente.ChamaSenha.service;

import com.chamagente.ChamaSenha.model.dto.ClienteDto;
import com.chamagente.ChamaSenha.model.entity.Cliente;
import com.chamagente.ChamaSenha.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

     public ClienteDto create (ClienteDto clienteDto){
        if(clienteRepository.existsByCpf(clienteDto.getCpf())){
            throw new RuntimeException("Cliente já cadastrado");
        }
         Cliente cliente = new Cliente();
        cliente.setNome(clienteDto.getNome());
        cliente.setCpf(clienteDto.getCpf());
        cliente.setDataCadastro(new Date());
        Cliente cliente1 = clienteRepository.save(cliente);
        return new ClienteDto(cliente1.getId(), cliente1.getNome(), cliente1.getCpf());
     }

     public List<ClienteDto> findAll(){
        List<Cliente> cliente = clienteRepository.findAll();
        List<ClienteDto> clienteDtos = new ArrayList<>();
        for (Cliente cliente1 : cliente ){
            clienteDtos.add(new ClienteDto(
                cliente1.getId(),
                cliente1.getNome(),
                cliente1.getCpf()));
            }
        return clienteDtos;
     }

    public ClienteDto findById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente" + id + "não encontrado"));
        return new ClienteDto(cliente.getId(),
                    cliente.getNome(),
                    cliente.getCpf());
}





}
