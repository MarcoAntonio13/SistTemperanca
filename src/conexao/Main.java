package conexao;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.jdbc.JDBCClienteDAO;
import dao.jdbc.JDBCEnderecoDAO;
import dao.jdbc.JDBCFornecedorDAO;
import dao.jdbc.JDBCProdutoDAO;
import dao.jdbc.JDBCVendaDAO;
import dao.jdbc.JDBCVendedorFornecedorDAO;
import model.Cliente;
import model.Endereco;
import model.Fornecedor;
import model.Produto;
import model.Venda;
import model.VendedorFornecedor;


public class Main {
	
	public static void main (String[]args){
		
		JDBCFornecedorDAO fornecedorDAO = new JDBCFornecedorDAO();
		List<Fornecedor> fornecedores = fornecedorDAO.listarPorRazaoSocial("Marco");
		
		fornecedores.forEach(action -> System.out.println("Razão Social: "+ action.getRazaoSocial()));
		
		
//		Endereco endereco = new Endereco();
//		endereco.setRua("Curitiba");
//		endereco.setBairro("Nova brasilia");
//		endereco.setNumeroEstabeleciemnto(2697);
//		JDBCEnderecoDAO enderecoDAO = new JDBCEnderecoDAO();
//		enderecoDAO.inserir(endereco);
//		
//		List<Endereco> enderecos = new ArrayList<Endereco>();
//		enderecos.add(endereco);
//
//		Cliente cliente = new Cliente();
//		cliente.setCnpj(1238123124124l);
//		cliente.setRazaoSocial("Ervas da terra LTDA ME");
//		cliente.setEnderecos(enderecos);
//		
//		JDBCClienteDAO clienteDAO = new JDBCClienteDAO();
//		clienteDAO.inserir(cliente);
//		
//		Produto produto = new Produto();
//		produto.setNome("Oregano Estragado");
//		produto.setValorVenda(4.45);
//		produto.setPeso(5.87);
//		
//		JDBCProdutoDAO produtoDAO = new JDBCProdutoDAO();
//		produtoDAO.inserir(produto);
//		
//		List<Produto> produtos = new ArrayList<Produto>();
//		produtos.add(produto);
//		
//		Venda venda = new Venda();
//		venda.setCliente(cliente);
//		venda.setData(Calendar.getInstance());
//		venda.setProdutos(produtos);
//		
//		JDBCVendaDAO vendaDAO = new JDBCVendaDAO();
//		vendaDAO.inserir(venda);
//		
		
//		LocalDate data = LocalDate.of(2010, 4 , 20);
//		JDBCDespesaDAO daoDespesa = new JDBCDespesaDAO();
//		daoDespesa.remover(19);
//				
//		Renda renda = new Renda(11, "A mulher ", 1560.23 , data, "Salário da Mulher");
//		JDBCRendaDAO daoRenda = new JDBCRendaDAO();
		
//		VendedorFornecedor vendedorFornecedor = new VendedorFornecedor(10, 6934240101l, "Marco HUE", "ewegwrehweh");
//		VendedorFornecedor vendedorFornecedor2 = new VendedorFornecedor(9, 6934240101l, "Marco HUE", "ewegwrehweh");
//		VendedorFornecedor vendedorFornecedor3 = new VendedorFornecedor(8, 6934240101l, "Marco HUE", "ewegwrehweh");
//		VendedorFornecedor vendedorFornecedor4 = new VendedorFornecedor(7, 6934240101l, "Marco HUE", "ewegwrehweh");
//		VendedorFornecedor vendedorFornecedor5 = new VendedorFornecedor(6, 6934240101l, "Marco HUE", "ewegwrehweh");
//		List<VendedorFornecedor> vendedoresFornecedores = new ArrayList<VendedorFornecedor>();
//		vendedoresFornecedores.add(vendedorFornecedor);
//		vendedoresFornecedores.add(vendedorFornecedor2);
//		vendedoresFornecedores.add(vendedorFornecedor3);
//		vendedoresFornecedores.add(vendedorFornecedor4);
//		vendedoresFornecedores.add(vendedorFornecedor5);
////		
//		Fornecedor fornecedor = new Fornecedor(null, "23190850721398", "Não sei", 6934240106l, "iqwufhiq@fuhe.com", vendedoresFornecedores);
//		
//		JDBCFornecedorDAO daoFornecedo = new JDBCFornecedorDAO();
//		JDBCVendedorFornecedorDAO daoVendedorFornecedor = new JDBCVendedorFornecedorDAO();
//		daoVendedorFornecedor.inserir(vendedorFornecedor);
//		daoVendedorFornecedor.inserir(vendedorFornecedor2);
//		daoVendedorFornecedor.inserir(vendedorFornecedor3);
//		daoVendedorFornecedor.inserir(vendedorFornecedor4);
//		daoVendedorFornecedor.inserir(vendedorFornecedor5);
//		
//		daoFornecedo.inserir(fornecedor);
		
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
