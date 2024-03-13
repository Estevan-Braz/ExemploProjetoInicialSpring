package com.example.demo.controller;

import com.example.demo.modelEntity.Produto;
import com.example.demo.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepositorio produtoRepositorio;

    @PostMapping(path="/add")
    public String add(
            @RequestParam String nome,
            @RequestParam String descricao,
            @RequestParam int quantidadeEstoque
    ){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setQuantidadeEstoque(quantidadeEstoque);

        produtoRepositorio.save(produto);
        return produto + "[Salvo]";
    }

    @GetMapping(path="/all")
    public Iterable<Produto> findAll(){
        return produtoRepositorio.findAll();
    }
}
