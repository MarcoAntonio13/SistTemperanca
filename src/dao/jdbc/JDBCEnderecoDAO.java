package dao.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.EnderecoDAO;
import model.Endereco;

public class JDBCEnderecoDAO implements EnderecoDAO {
	
	private SessionFactory factory;

	public JDBCEnderecoDAO(){
	factory = HibernateStarter.getSessionFactory();
	}
	

	@Override
	public void inserir(Endereco endereco) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(endereco);
		session.getTransaction().commit();
		
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Endereco endereco = new Endereco();
		endereco.setId(id);
		session.delete(endereco);
		session.getTransaction().commit();
		
	}

	@Override
	public List<Endereco> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Endereco> enderecos = session.createQuery("from Endereco").getResultList();
		session.getTransaction().commit();
		return enderecos;
	}
	
	@Override
	public Endereco buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Endereco endereco = new Endereco();
		endereco.setId(id);
		endereco = session.get(Endereco.class, endereco.getId());
		session.getTransaction().commit();
		return endereco;
	}

	
	@Override
	public void editar(Endereco endereco) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(endereco);
		session.getTransaction().commit();		
	}


	

}
