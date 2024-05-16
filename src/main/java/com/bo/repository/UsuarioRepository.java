package com.bo.repository;

import com.bo.collection.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByCedula(String nit);

    Optional<Usuario> findByUsuarioAndContraseña(String usuario, String contraseñaEncriptada);
}
