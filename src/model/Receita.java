package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany
	private List<Material> materias;
	
	@ManyToOne
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
