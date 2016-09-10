package dao.dao;

import java.util.List;

import model.FormaPagamento;

public interface FormaPagamentoDAO {
	public void inserir(FormaPagamento formaPagamento);
	public void remover(int id);
	public List<FormaPagamento> listar();
	public FormaPagamento buscar(int id);
	public void editar(FormaPagamento formaPagamento);

}
