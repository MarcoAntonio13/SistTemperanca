package dao.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.FornecedorDAO;
import model.Fornecedor;

public class JDBCFornecedorDAO implements FornecedorDAO {

	private SessionFactory factory;

	public JDBCFornecedorDAO() {
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(Fornecedor fornecedor) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(fornecedor);
		session.getTransaction().commit();
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		session.delete(fornecedor);
		session.getTransaction().commit();
	}

	@Override
	public List<Fornecedor> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Fornecedor> fornecedores = session.createQuery("from Fornecedor").getResultList();
		session.getTransaction().commit();
		return fornecedores;
	}
	
	public List<Fornecedor> listarPorRazaoSocial(String razaoSocial){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Fornecedor> fornecedores = session.createQuery("select f from Fornecedor f where f.razaoSocial like '%"+razaoSocial+"%'").getResultList();
		session.getTransaction().commit();
		return fornecedores;

	}

	@Override
	public Fornecedor buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		fornecedor = session.get(Fornecedor.class, fornecedor.getId());
		session.getTransaction().commit();
		return fornecedor;
	}

	@Override
	public void editar(Fornecedor fornecedor) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(fornecedor);
		session.getTransaction().commit();
	}

}
