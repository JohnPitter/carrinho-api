package br.com.teste.api.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Builder;

@Builder
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idProduto;
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String descProduto;
	private Double value;
	
	@Transient
	private Integer quantidade;
	
	//Construtores
	public Produto() {}
	
	
	public Produto(String name, String descProduto, Double value) {
		this.name = name;
		this.descProduto = descProduto;
		this.value = value;
	}
	
	
	//Gets and Sets
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return descProduto;
	}
	public void setDesc(String descProduto) {
		this.descProduto = descProduto;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	
}

