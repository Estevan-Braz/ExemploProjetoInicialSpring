package com.example.demo.repository;

import com.example.demo.modelEntity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {
}
