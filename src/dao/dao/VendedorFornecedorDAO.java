/**
 * 
 */
package dao.dao;

import java.util.List;

import model.VendedorFornecedor;

/**
 * @author MarcoAntônio
 *
 */
public interface VendedorFornecedorDAO {
	public void inserir(VendedorFornecedor vendedorFornecedor);

	public void remover(int id);

	public List<VendedorFornecedor> listar();

	public VendedorFornecedor buscar(int id);

	public void editar(VendedorFornecedor vendedorFornecedor);

}
