package com.lucky.lavandaria.service;
import com.lucky.lavandaria.model.Produto;
import com.lucky.lavandaria.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProdutoService {

	private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
	

}
