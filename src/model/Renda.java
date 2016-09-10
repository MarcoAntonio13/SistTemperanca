package model;

import java.util.Calendar;

public class Renda {
	private Integer id;
	private String descricao;
	private Double valor;
	private Calendar data;
	private String nome;

	public Renda() {

	}

	public Renda(Integer id, String descricao, Double valor, Calendar data, String nome) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
