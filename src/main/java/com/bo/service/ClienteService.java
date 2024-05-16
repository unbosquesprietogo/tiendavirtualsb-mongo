package com.bo.service;

import com.bo.collection.Cliente;
import com.bo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void registrarCliente(Cliente cli) {
        clienteRepository.save(cli);
    }

    public List<Cliente> consultarClientes() {
        return clienteRepository.findAll();
    }
}
