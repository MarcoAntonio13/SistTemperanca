package dao.dao;

import java.util.List;

import model.EstoqueProduto;

public interface EstoqueProdutoDAO {
	public void inserir(EstoqueProduto estoqueProduto);
	public void remover(int id);
	public List<EstoqueProduto> listar();
	public EstoqueProduto buscar(int id);
	public void editar(EstoqueProduto estoqueProduto);

}
