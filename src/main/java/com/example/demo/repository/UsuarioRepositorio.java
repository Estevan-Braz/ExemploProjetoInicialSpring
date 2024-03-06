package com.example.demo.repository;

import com.example.demo.modelEntity.*;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    boolean existsByEmail(String email);
}
