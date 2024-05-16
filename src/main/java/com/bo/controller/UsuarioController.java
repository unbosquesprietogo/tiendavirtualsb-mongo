package com.bo.controller;

import com.bo.collection.Usuario;
import com.bo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public boolean registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @GetMapping("/consultar")
    public List<Usuario> consultarUsuarios(@RequestParam(required = false) String nit) {
        return usuarioService.consultarUsuarios(nit);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Usuario usuario) {
        return usuarioService.login(usuario);
    }
}

