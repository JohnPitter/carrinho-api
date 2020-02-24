package br.com.teste.api.service;

import java.util.List;

import br.com.teste.api.entity.Carrinho;

public interface CarrinhoService {
	
	Carrinho find(int id);
    //List<Carrinho> findAll(List<Carrinho> carrinhos);
    String findAll(List<Carrinho> carrinhos);
    Carrinho update(int idCarrinho, Carrinho carrinho);
    Carrinho insert(Carrinho carrinho);
    void delete(int idCarrinho);

}
