package com.example.demo.controller;

import com.example.demo.modelEntity.Usuario;
import com.example.demo.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/usuario")
public class UsuarioControlller {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(
            @RequestParam String nome, @RequestParam String email
    ){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuarioRepositorio.save(usuario);
        return usuario + " salvo";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Usuario> getAllUsers(){
        return usuarioRepositorio.findAll();
    }
}
