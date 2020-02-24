package br.com.teste.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.api.entity.Carrinho;
import br.com.teste.api.exceptions.DataIntegrationException;
import br.com.teste.api.repository.CarrinhoRepository;
import lombok.var;

@Service
public class CarrinhoServiceImpl implements CarrinhoService{

	@Autowired
    CarrinhoRepository carrinhoRepository;

    public Carrinho find(int id){
        //Realiza a busca de um carrinho através do Id
        //O metodo findById retorna um objeto do tipo Optional
        var pro = carrinhoRepository.findById(id);

        //Verifica se o Usuário existe
        if(!pro.isPresent()){
            //Lança uma exceção informando que o carrinho não existe
            throw new DataIntegrationException("Carrinho não existe");
        }

        return pro.get();
    }

  //Busca todos os carrinhos da base
    @Override
    public List<Carrinho> findAll(){
        return carrinhoRepository.findAll();
    }

    @Override
    // Realiza o update do carrinho
    public Carrinho update(int idCarrinho, Carrinho carrinho){

        //Busca o carrinho que será alterado
        var pro = this.find(idCarrinho);

        //sobrescreve os valores antigos pelos novos
        pro.setProdutos(carrinho.getProdutos());
        pro.setCupoms(carrinho.getCupoms());

     // Salva a alteração no banco de dados
     return carrinhoRepository.save(pro);
    }

    @Override
    //Insere um novo carrinho no banco de dados
    public Carrinho insert(Carrinho carrinho) {

        //Busca um carrinho através do descricao informado
        var pro = carrinhoRepository.findById(carrinho.getIdCarrinho());

        //Verifica se já existe um carrinho com o descricao informado
        if(pro.isPresent()){
            //Caso já exista um carrinho cadastrado com o mesmo descricao informado
            //é retornado uma exceção informando que esse descricao ja foi cadastrado para outro carrinho
            throw new DataIntegrationException("Carrinho Ja Cadastrado");
        }

        //Salva um novo carrinho
        return  carrinhoRepository.save( Carrinho.builder()
                .produtos(carrinho.getProdutos())
                .cupoms(carrinho.getCupoms())
                .build());
    }

    @Override
    public void delete(int idCarrinho){
        //Busca o carrinho que será deletado
        var pro = this.find(idCarrinho);
        //deleta o carrinho
        carrinhoRepository.delete(pro);
    }
}
