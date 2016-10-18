package dao.dao;

import java.util.List;

import model.Endereco;

public interface EnderecoDAO {
	public void inserir(Endereco endereco);
	public void remover(int id);
	public List<Endereco> listar();
	public Endereco buscar(int id);
	public void editar(Endereco endereco);

}
