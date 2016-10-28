package dao.dao;

import java.util.List;

import model.EstoqueMaterial;

public interface EstoqueMaterialDAO {
	public void inserir(EstoqueMaterial estoqueMaterial);
	public void remover(int id);
	public List<EstoqueMaterial> listar();
	public EstoqueMaterial buscar(int id);
	public void editar(EstoqueMaterial estoqueMaterial);
}
