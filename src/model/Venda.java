package model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valorTotal;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	@ManyToOne
	private FormaPagamento formaPagamento;

	private LocalDate data;

	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EstoqueProduto> produtos;

	public Venda() {

	}
	
	
	public Venda(Integer id, Double valorTotal, Cliente cliente, FormaPagamento formaPagamento, LocalDate data,
			List<EstoqueProduto> produtos) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.formaPagamento = formaPagamento;
		this.data = data;
		this.produtos = produtos;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	

	public List<EstoqueProduto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<EstoqueProduto> produtos) {
		this.produtos = produtos;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cliente.getRazaoSocial() + " Data: " + data.getDayOfMonth() + "/" + data.getMonthValue() + "/"
				+ data.getYear();
	}
}
