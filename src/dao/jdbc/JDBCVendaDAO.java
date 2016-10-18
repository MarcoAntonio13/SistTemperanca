package dao.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.VendaDAO;
import model.Venda;

public class JDBCVendaDAO implements VendaDAO {
	
	private SessionFactory factory;
	public JDBCVendaDAO() {
		
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(Venda venda) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(venda);
		session.getTransaction().commit();
		
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Venda venda = new Venda();
		venda.setId(id);
		session.delete(venda);
		session.getTransaction().commit();
		
	}

	@Override
	public List<Venda> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Venda> vendas = session.createQuery("from Venda").getResultList();
		session.getTransaction().commit();
		return vendas;
	}

	@Override
	public Venda venda(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Venda venda = new Venda();
		venda.setId(id);
		venda = session.get(Venda.class, venda.getId());
		session.getTransaction().commit();
		return venda;
	}

	@Override
	public void editar(Venda venda) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(venda);
		session.getTransaction().commit();		
	}

}
