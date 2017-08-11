package dao.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.ClienteDAO;
import model.Cliente;


public class JDBCClienteDAO implements ClienteDAO {
	
	private SessionFactory factory;
	public JDBCClienteDAO() {
		
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(Cliente cliente) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(cliente);
		session.getTransaction().commit();
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Cliente cliente = session.get(Cliente.class, id);
		session.delete(cliente);
		session.getTransaction().commit();
	}

	@Override
	public List<Cliente> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = session.createQuery("from Cliente c JOIN FETCH c.enderecos").getResultList();
		session.getTransaction().commit();
		return clientes;
	}

	@Override
	public Cliente buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Cliente cliente = new Cliente();
		cliente = (Cliente) session.createQuery("from Cliente c JOIN FETCH c.enderecos where c.id="+id).getSingleResult();
		session.getTransaction().commit();
		return cliente;
	}

	@Override
	public void editar(Cliente cliente) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(cliente);
		session.getTransaction().commit();
	}
	
	public List<Cliente> listarPorRazaoSocial(String razaoSocial){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = session.createQuery("from Cliente c where c.razaoSocial like '%"+razaoSocial+"%'").getResultList();
		session.getTransaction().commit();
		return clientes;

	}
	
	
	
}
