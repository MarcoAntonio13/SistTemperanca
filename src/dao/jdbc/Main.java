package dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Endereco;

public class Main {
	public static void main (String[]args){
		JDBCClienteDAO daoC = new JDBCClienteDAO();
//		JDBCEnderecoDAO daoE = new JDBCEnderecoDAO();
		Cliente cliente = daoC.buscar(5);

		cliente.getEnderecos().forEach(action -> System.out.println(action.getId()));
//		daoE.inserir(endereco);
//		List<Endereco> enderecos = new ArrayList();
//		enderecos.add(endereco);
//		cliente.setEnderecos(enderecos);
		daoC.editar(cliente);
	}
}
