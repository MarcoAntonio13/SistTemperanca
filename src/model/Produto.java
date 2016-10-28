package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double valorProducao;
	private Double valorVenda;
	private Double pesoPorEmbalagem;

	public Produto() {

	}
	
	
	public Produto(Integer id, String nome, Double valorProducao, Double valorVenda, Double pesoPorEmbalagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorProducao = valorProducao;
		this.valorVenda = valorVenda;
		this.pesoPorEmbalagem = pesoPorEmbalagem;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorProducao() {
		return valorProducao;
	}

	public void setValorProducao(Double valorProducao) {
		this.valorProducao = valorProducao;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}


	public Double getPesoPorEmbalagem() {
		return pesoPorEmbalagem;
	}


	public void setPesoPorEmbalagem(Double pesoPorEmbalagem) {
		this.pesoPorEmbalagem = pesoPorEmbalagem;
	}
	
	



}
