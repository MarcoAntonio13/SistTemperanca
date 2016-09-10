package model;

import java.util.Calendar;
import java.util.List;

public class Venda {
	private Integer id;
	private Double valorTotal;
	private Cliente cliente;
	private FormaPagamento formaPagamento;
	private Calendar data;
	private List<Produto> produtos;

	public Venda() {

	}

	public Venda(Integer id, Double valorTotal, Cliente cliente, FormaPagamento formaPagamento, Calendar data,
			List<Produto> produtos) {
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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
