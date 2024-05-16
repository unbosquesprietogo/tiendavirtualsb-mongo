package com.bo.service;


import com.bo.collection.Usuario;
import com.bo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class UsuarioService {

    private static final String PRIVATE_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean registrarUsuario(Usuario usuario) {
        try {
            String contraseñaEncriptada = encriptarContraseña(usuario.getContraseña());
            usuario.setContraseña(contraseñaEncriptada);
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Usuario> consultarUsuarios(String nit) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            if (nit != null && !nit.equals("null")) {
                Optional<Usuario> usuarioOptional = usuarioRepository.findByCedula(nit);
                usuarioOptional.ifPresent(usuarios::add);
            } else {
                usuarios = usuarioRepository.findAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean login(Usuario usuario) {
        try {
            String contraseñaEncriptada = encriptarContraseña(usuario.getContraseña());
            Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuarioAndContraseña(usuario.getUsuario(), contraseñaEncriptada);
            return usuarioOptional.isPresent();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String encriptarContraseña(String contraseña) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest((contraseña + PRIVATE_KEY).getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
