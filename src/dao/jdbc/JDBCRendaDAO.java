package dao.jdbc;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


import dao.dao.RendaDAO;
import model.Renda;

public class JDBCRendaDAO implements RendaDAO {

	private SessionFactory factory;

	public JDBCRendaDAO() {
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(Renda renda) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(renda);
		session.getTransaction().commit();

	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Renda renda = new Renda();
		renda.setId(id);
		session.delete(renda);
		session.getTransaction().commit();
	}

	@Override
	public List<Renda> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Renda> rendas = session.createQuery("from Renda").getResultList();
		session.getTransaction().commit();
		return rendas;
	}

	@Override
	public Renda buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Renda renda = new Renda();
		renda.setId(id);
		renda = session.get(Renda.class, renda.getId());
		session.getTransaction().commit();
		return renda;
	}

	@Override
	public void editar(Renda renda) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(renda);
		session.getTransaction().commit();
	}

}
