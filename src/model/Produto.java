package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double valorProducao;
	private Double valorVenda;
	private Double pesoPorEmbalagem;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="produto")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.REMOVE, CascadeType.DELETE, CascadeType.MERGE })
	private List<Receita> receitas;

	public Produto() {

	}

	public Produto(Integer id, String nome, Double valorProducao, Double valorVenda, Double pesoPorEmbalagem,
			List<Receita> receitas) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorProducao = valorProducao;
		this.valorVenda = valorVenda;
		this.pesoPorEmbalagem = pesoPorEmbalagem;
		this.receitas = receitas;
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

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public Double getPesoPorEmbalagem() {
		return pesoPorEmbalagem;
	}

	public void setPesoPorEmbalagem(Double pesoPorEmbalagem) {
		this.pesoPorEmbalagem = pesoPorEmbalagem;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome;
	}

}
