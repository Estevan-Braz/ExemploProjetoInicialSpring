package com.example.demo.controller;

import com.example.demo.modelEntity.Movimentacao;
import com.example.demo.modelEntity.Produto;
import com.example.demo.modelEntity.TipoMovimentacao;
import com.example.demo.modelEntity.Usuario;
import com.example.demo.repository.MovimentacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepositorio movimentacaoRepositorio;
    @Autowired
    private ProdutoController produtoController;
    @Autowired
    private UsuarioControlller usuarioControlller;
    @PostMapping(path="/add")
    public Movimentacao add(
            @RequestParam Long id_usuario,
            @RequestParam Long id_produto,
            @RequestParam TipoMovimentacao acao,
            @RequestParam int quantidade
    ){
        Optional<Produto> produto = produtoController.findById(id_produto);
        Optional<Usuario> usuario = usuarioControlller.pegarPorId(id_usuario);
        if (produto.isPresent() && usuario.isPresent()){
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setProduto(produto.get());
            movimentacao.setUsuario(usuario.get());
            movimentacao.setAcao(acao);
            movimentacao.setQuantidade(quantidade);
            movimentacaoRepositorio.save(movimentacao);
            return movimentacao;
        }else{
            return null;
        }

    }
}
