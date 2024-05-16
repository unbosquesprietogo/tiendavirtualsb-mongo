package com.bo.controller;


import com.bo.collection.Cliente;
import com.bo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarCliente(@RequestBody Cliente cliente) {
        clienteService.registrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto guardado exitosamente");
    }



    @GetMapping("/consultar")
    public List<Cliente> consultarClientes() {
        return clienteService.consultarClientes();
    }
}

