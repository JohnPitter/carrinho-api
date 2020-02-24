package br.com.teste.api.service;

import java.util.List;

import br.com.teste.api.entity.Carrinho;

public interface CarrinhoService {
	
	Carrinho find(int id);
    List<Carrinho> findAll();
    Carrinho update(int idProduto, Carrinho produto);
    Carrinho insert(Carrinho produto);
    void delete(int idProduto);

}
