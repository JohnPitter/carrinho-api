package br.com.teste.api.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Builder;

@Builder
@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCarrinho;
     
	private static final long serialVersionUID = 1L;
	
    private Double valorTotal;

    @OneToMany(mappedBy="carrinho", fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cupom", referencedColumnName = "idCupom", nullable = false )
	private List<Cupom> cupoms;

    @OneToMany(mappedBy="carrinho", fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cupom", referencedColumnName = "idCupom", nullable = false )
    private List<Produto> produtos;
	
    
    public Carrinho(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public Carrinho() { }

	//Gets and Sets
	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Integer idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public List<Cupom> getCupoms() {
		return cupoms;
	}

	public void setCupoms(List<Cupom> cupoms) {
		this.cupoms = cupoms;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
