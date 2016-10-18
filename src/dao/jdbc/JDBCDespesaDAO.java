package dao.jdbc;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.dao.DespesaDAO;
import model.Despesa;

public class JDBCDespesaDAO implements DespesaDAO {
	
	private SessionFactory factory;
	public JDBCDespesaDAO() {
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(Despesa despesa) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(despesa);
		session.getTransaction().commit();
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Despesa despesa = new Despesa();
		despesa.setId(id);
		session.delete(despesa);
		session.getTransaction().commit();
	}

	@Override
	public List<Despesa> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Despesa> despesas = session.createQuery("from Despesa").getResultList();
		session.getTransaction().commit();
		return despesas;
	}

	@Override
	public Despesa buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Despesa despesa = new Despesa();
		despesa.setId(id);
		despesa = session.get(Despesa.class, despesa.getId());
		session.getTransaction().commit();
		return despesa;
	}

	@Override
	public void editar(Despesa despesa) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(despesa);
		session.getTransaction().commit();
		
	}
}
