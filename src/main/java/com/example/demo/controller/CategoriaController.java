package com.example.demo.controller;

import com.example.demo.modelEntity.Categoria;
import com.example.demo.repository.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/add")
    public Categoria add(
            @RequestParam String nome
    ){
        Categoria categoria = new Categoria();
        categoria.setNome(nome);
        return categoriaRepositorio.save(categoria);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/all")
    public Iterable<Categoria> getAll(){
        return categoriaRepositorio.findAll();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/findById")
    public Optional<Categoria> findById(
            @RequestParam Long id
    ){
        return categoriaRepositorio.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path="/update")
    public void atualizar(
            @RequestParam Long id,
            @RequestParam String nome
    ){
        Categoria c = this.findById(id).get();
        c.setNome(nome);
        categoriaRepositorio.save(c);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path="/delete")
    public void deleteById(
            @RequestParam Long id
    ){
        categoriaRepositorio.deleteById(id);
    }
}
