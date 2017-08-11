package dao.jdbc;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.EstoqueProdutoDAO;
import model.EstoqueMaterial;
import model.EstoqueProduto;

public class JDBCEstoqueProdutoDAO implements EstoqueProdutoDAO {
	
	private SessionFactory factory;

	public JDBCEstoqueProdutoDAO(){
	factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(EstoqueProduto estoqueProduto) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(estoqueProduto);
		session.getTransaction().commit();
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		EstoqueProduto estoqueProduto = new EstoqueProduto();
		estoqueProduto.setId(id);
		session.delete(estoqueProduto);
		session.getTransaction().commit();

	}

	@Override
	public List<EstoqueProduto> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EstoqueProduto> estoquesProdutos = session.createQuery("from EstoqueProduto").getResultList();
		session.getTransaction().commit();
		return estoquesProdutos;
	}

	@Override
	public EstoqueProduto buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		EstoqueProduto estoqueProduto = new EstoqueProduto();
		estoqueProduto.setId(id);
		estoqueProduto = session.get(EstoqueProduto.class, estoqueProduto.getId());
		session.getTransaction().commit();
		return estoqueProduto;
	}
	


	@Override
	public void editar(EstoqueProduto estoqueProduto) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(estoqueProduto);
		session.getTransaction().commit();	

	}

}
