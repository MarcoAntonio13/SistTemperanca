package model;

public class Produto {
	private Integer id;
	private String nome;
	private Double valorProducao;
	private Double valorVenda;
	private Double peso;

	public Produto() {

	}

	public Produto(Integer id, String nome, Double valorProducao, Double valorVenda, Double peso) {

		this.id = id;
		this.nome = nome;
		this.valorProducao = valorProducao;
		this.valorVenda = valorVenda;
		this.peso = peso;
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

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
