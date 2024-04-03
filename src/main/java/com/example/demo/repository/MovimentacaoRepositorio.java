package com.example.demo.repository;

import com.example.demo.modelEntity.Movimentacao;
import org.springframework.data.repository.CrudRepository;

public interface MovimentacaoRepositorio extends CrudRepository <Movimentacao, Long> {
}
