package model;

import java.util.List;

public class Receita {

	private List<Material> materias;
	private Produto produto;

	public Receita() {
		// TODO Auto-generated constructor stub
	}

	public Receita(List<Material> materias, Produto produto) {
		super();
		this.materias = materias;
		this.produto = produto;
	}

	public List<Material> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Material> materias) {
		this.materias = materias;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
