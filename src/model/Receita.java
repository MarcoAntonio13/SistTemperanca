package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Material material;

	@ManyToOne
	private Produto produto;

	private Double pesoMaterial;

	public Receita() {
		// TODO Auto-generated constructor stub
	}

	public Receita(Integer id, Material material, Produto produto, Double pesoMaterial) {
		super();
		this.id = id;
		this.material = material;
		this.produto = produto;
		this.pesoMaterial = pesoMaterial;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPesoMaterial() {
		return pesoMaterial;
	}

	public void setPesoMaterial(Double pesoMaterial) {
		this.pesoMaterial = pesoMaterial;
	}

}
