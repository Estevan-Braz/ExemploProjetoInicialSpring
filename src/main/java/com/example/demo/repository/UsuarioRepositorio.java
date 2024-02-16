package com.example.demo.repository;

import com.example.demo.modelEntity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
}
