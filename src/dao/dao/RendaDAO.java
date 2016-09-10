package dao.dao;

import java.util.List;
import model.Renda;

public interface RendaDAO {
	public void inserir(Renda renda);

	public void remover(int id);

	public List<Renda> listar();

	public Renda buscar(int id);

	public void editar(Renda renda);

}
