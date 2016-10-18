package dao.dao;

import java.util.List;

import model.Venda;

public interface VendaDAO {
	public void inserir(Venda venda);
	public void remover(int id);
	public List<Venda> listar();
	public Venda venda(int id);
	public void editar(Venda venda);
}
