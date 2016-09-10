package dao.dao;

import java.util.List;

import model.Despesa;

public interface DespesaDAO {
	public void inserir(Despesa despesa);
	public void remover(int id);
	public List<Despesa> listar();
	public Despesa buscar(int id);
	public void editar(Despesa despesa);

}
