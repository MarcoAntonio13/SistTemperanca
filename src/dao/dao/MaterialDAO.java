package dao.dao;

import java.util.List;

import model.Material;

public interface MaterialDAO {
	public void inserir(Material material);

	public void remover(int id);

	public List<Material> listar();

	public Material buscar(int id);

	public void editar(Material material);
}
