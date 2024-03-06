package com.example.demo.controller;

import com.example.demo.modelEntity.Usuario;
import com.example.demo.repository.UsuarioRepositorio;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(path="/usuario")
public class UsuarioControlller {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(
            @RequestParam String nome, @RequestParam String email,
            @RequestParam @DateTimeFormat(pattern="dd/MM/yyyy") Date dataNascimento
    ){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setDataNascimento(dataNascimento);
        usuarioRepositorio.save(usuario);
        return usuario + " salvo";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Usuario> getAllUsers(){
        return usuarioRepositorio.findAll();
    }

    @GetMapping(path="/findByEmail")
    public @ResponseBody Usuario findByEmail(
            @RequestParam String email
    ){
        Usuario achou = usuarioRepositorio.findByEmail(email);
        return achou;
    }

    @GetMapping(path="/existeEmail")
    public @ResponseBody boolean existeEmail(
            @RequestParam String email
    ){
        return  usuarioRepositorio.existsByEmail(email);

    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Usuario> getUsuario(@PathVariable String id){
        return usuarioRepositorio.findById(Long.parseLong(id));
    }
}
