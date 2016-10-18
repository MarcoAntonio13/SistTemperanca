package dao.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.ReceitaDAO;
import model.Receita;

public class JDBCReceitaDAO implements ReceitaDAO{
	
	private SessionFactory factory;
	public JDBCReceitaDAO() {
		
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(Receita receita) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(receita);
		session.getTransaction().commit();
		
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Receita receita = new Receita();
		receita.setId(id);
		session.delete(receita);
		session.getTransaction().commit();
		
	}

	@Override
	public List<Receita> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Receita> receitas = session.createQuery("from Receita").getResultList();
		session.getTransaction().commit();
		return receitas;
	}

	@Override
	public Receita buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Receita receita = new Receita();
		receita.setId(id);
		receita = session.get(Receita.class, receita.getId());
		session.getTransaction().commit();
		return receita;
	}

	@Override
	public void editar(Receita receita) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(receita);
		session.getTransaction().commit();
	}

}
