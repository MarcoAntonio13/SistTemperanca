package dao.dao;

import java.util.List;

import model.Receita;

public interface ReceitaDAO {
	public void inserir(Receita receita);
	public void remover(int id);
	public List<Receita> listar();
	public Receita buscar(int id);
	public void editar(Receita receita);


}
