package dao.jdbc;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Cliente;
import model.Despesa;
import model.Endereco;
import model.FormaPagamento;
import model.Fornecedor;
import model.Material;
import model.Produto;
import model.Receita;
import model.Renda;
import model.Venda;
import model.VendedorFornecedor;

public class HibernateStarter {
	
	private static SessionFactory factory;
	
	public HibernateStarter() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Produto.class)
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Endereco.class)
				.addAnnotatedClass(Fornecedor.class)
				.addAnnotatedClass(VendedorFornecedor.class)
				.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Produto.class)
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Endereco.class)
				.addAnnotatedClass(Fornecedor.class)
				.addAnnotatedClass(VendedorFornecedor.class)
				.addAnnotatedClass(Despesa.class)
				.addAnnotatedClass(FormaPagamento.class)
				.addAnnotatedClass(Material.class)
				.addAnnotatedClass(Receita.class)
				.addAnnotatedClass(Renda.class)
				.addAnnotatedClass(Venda.class)
				.buildSessionFactory();
		return factory;
	}
}
