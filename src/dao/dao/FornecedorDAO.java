package dao.dao;

import java.util.List;

import model.Fornecedor;

public interface FornecedorDAO {
	public void inserir(Fornecedor fornecedor);

	public void remover(int id);

	public List<Fornecedor> listar();

	public Fornecedor buscar(int id);

	public void editar(Fornecedor fornecedor);

}
