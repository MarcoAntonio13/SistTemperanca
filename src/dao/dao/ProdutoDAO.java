package dao.dao;

import java.util.List;

import model.Produto;

public interface ProdutoDAO {
	public void inserir(Produto produto);
	public void remover(int id);
	public List<Produto> listar();
	public Produto buscar(int id);
	public void editar(Produto produto);

}
