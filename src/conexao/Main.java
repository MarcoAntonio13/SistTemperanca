package conexao;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.UpdatableResultSet;

import java.sql.Date;

import converter.DateConverter;
import dao.jdbc.JDBCDespesaDAO;
import dao.jdbc.JDBCFornecedorDAO;
import dao.jdbc.JDBCRendaDAO;
import dao.jdbc.JDBCVendedorFornecedorDAO;
import model.Despesa;
import model.Fornecedor;
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
		VendedorFornecedor vendedorFornecedor2 = new VendedorFornecedor(9, 6934240101l, "Marco HUE", "ewegwrehweh");
		VendedorFornecedor vendedorFornecedor3 = new VendedorFornecedor(8, 6934240101l, "Marco HUE", "ewegwrehweh");
		VendedorFornecedor vendedorFornecedor4 = new VendedorFornecedor(7, 6934240101l, "Marco HUE", "ewegwrehweh");
		VendedorFornecedor vendedorFornecedor5 = new VendedorFornecedor(6, 6934240101l, "Marco HUE", "ewegwrehweh");
		List<VendedorFornecedor> vendedoresFornecedores = new ArrayList<VendedorFornecedor>();
		vendedoresFornecedores.add(vendedorFornecedor);
		vendedoresFornecedores.add(vendedorFornecedor2);
		vendedoresFornecedores.add(vendedorFornecedor3);
		vendedoresFornecedores.add(vendedorFornecedor4);
		vendedoresFornecedores.add(vendedorFornecedor5);
//		
		Fornecedor fornecedor = new Fornecedor(5, "23190850721398", "Não sei", 6934240106l, "iqwufhiq@fuhe.com", vendedoresFornecedores);
		
		JDBCFornecedorDAO daoFornecedo = new JDBCFornecedorDAO();
		
		daoFornecedo.editar(fornecedor);
		
//		daoFornecedo.inserir(fornecedor);
//		JDBCVendedorFornecedorDAO daoVendedorFornecedor = new JDBCVendedorFornecedorDAO();
//		daoVendedorFornecedor.inserir(vendedorFornecedor);
//		daoVendedorFornecedor.remover(12);
//		System.out.println(daoVendedorFornecedor.buscar(10).getEmail());
//		daoVendedorFornecedor.editar(vendedorFornecedor);
//		daoVendedorFornecedor.listar().forEach(action -> System.out.println(action.getNome()));

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
