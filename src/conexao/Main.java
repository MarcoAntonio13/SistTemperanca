package conexao;


import java.time.LocalDate;
import java.sql.Date;

import converter.DateConverter;
import dao.jdbc.JDBCDespesaDAO;
import dao.jdbc.JDBCRendaDAO;
import dao.jdbc.JDBCVendedorFornecedorDAO;
import model.Despesa;
import model.Renda;
import model.VendedorFornecedor;


public class Main {
	
	public static void main (String[]args){
		
		LocalDate data = LocalDate.of(2010, 4 , 20);
//		JDBCDespesaDAO daoDespesa = new JDBCDespesaDAO();
//		daoDespesa.remover(19);
//				
		
//		Renda renda = new Renda(11, "A mulher ", 1560.23 , data, "Salário da Mulher");
//		JDBCRendaDAO daoRenda = new JDBCRendaDAO();
		
		VendedorFornecedor vendedorFornecedor = new VendedorFornecedor(10, 6934240101l, "Marco HUE", "ewegwrehweh");
		JDBCVendedorFornecedorDAO daoVendedorFornecedor = new JDBCVendedorFornecedorDAO();
//		daoVendedorFornecedor.inserir(vendedorFornecedor);
//		daoVendedorFornecedor.remover(12);
		System.out.println(daoVendedorFornecedor.buscar(10).getEmail());
		daoVendedorFornecedor.editar(vendedorFornecedor);
		daoVendedorFornecedor.listar().forEach(action -> System.out.println(action.getNome()));

//		daoRenda.inserir(renda);
//		daoRenda.remover(11);
//		daoRenda.listar().forEach(action -> System.out.println(action.getDescricao() + action.getData()));
//		System.out.println(daoRenda.buscar(11).getNome());
//		daoRenda.editar(renda);
		
//		daoDespesa.listar().forEach(action -> System.out.println(action.getData()));
//		daoDespesa.editar(despesa);
//		System.out.println(daoFormaPagamento.buscar(2).getNome());
//		daoFormaPagamento.remover(10);
//		
//		JDBCClienteDAO daoCliente = new JDBCClienteDAO();
//		
//		System.out.println(daoCliente.buscar(1).getRazaoSocial());
//		daoCliente.listar().forEach(action -> System.out.println(action.getRazaoSocial()));
		
		
	}

}
