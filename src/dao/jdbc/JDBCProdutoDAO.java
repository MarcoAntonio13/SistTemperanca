package dao.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.ProdutoDAO;
import model.Produto;

public class JDBCProdutoDAO implements ProdutoDAO {
	
	private SessionFactory factory;
	public JDBCProdutoDAO() {
		
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(Produto produto) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(produto);
		session.getTransaction().commit();		
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Produto produto = new Produto();
		produto.setId(id);
		session.delete(produto);
		session.getTransaction().commit();		
	}

	@Override
	public List<Produto> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Produto> produtos = session.createQuery("from Produto").getResultList();
		session.getTransaction().commit();
		return produtos;

	}

	@Override
	public Produto buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Produto produto = new Produto();
		produto.setId(id);
		produto = session.get(Produto.class, produto.getId());
		session.getTransaction().commit();
		return produto;
	}

	@Override
	public void editar(Produto produto) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(produto);
		session.getTransaction().commit();
		
	}

}
