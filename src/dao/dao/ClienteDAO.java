package dao.dao;

import java.util.List;

import model.Cliente;

public interface ClienteDAO {
	public void inserir(Cliente cliente);
	public void remover(int id);
	public List<Cliente> listar();
	public Cliente buscar(int id);
	public void editar(Cliente cliente);

}
