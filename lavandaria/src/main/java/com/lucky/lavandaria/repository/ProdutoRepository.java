package com.lucky.lavandaria.repository;

import com.lucky.lavandaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
