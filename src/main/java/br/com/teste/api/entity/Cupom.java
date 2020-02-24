package br.com.teste.api.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Builder;

@Builder
@Entity
@Table(name = "cupom")
public class Cupom implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idCupom;
	
	private static final long serialVersionUID = 1L;
	
	private String descCupom;
	private String code;
	private Integer percent;

	//Construtores
	public Cupom(){}
	
	public Cupom(String descCupom, String code, Integer percent) {
		this.descCupom = descCupom;
		this.code = code;
		this.percent = percent;
	}

	//Gets and Sets
	public String getDesc() {
		return descCupom;
	}

	public void setDesc(String desc) {
		this.descCupom = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPercent() {
		return percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}
	
}
