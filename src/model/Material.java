package model;

public class Material {
	private Integer id;
	private Double peso;
	private Double valorCompra;
	private String nome;
	private Fornecedor fornecedor;

	public Material() {
		// TODO Auto-generated constructor stub
	}

	public Material(Integer id, Double peso, Double valorCompra, String nome, Fornecedor fornecedor) {
		super();
		this.id = id;
		this.peso = peso;
		this.valorCompra = valorCompra;
		this.nome = nome;
		this.fornecedor = fornecedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
