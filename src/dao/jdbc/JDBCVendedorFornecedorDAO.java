package dao.jdbc;



import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


import dao.dao.VendedorFornecedorDAO;

import model.VendedorFornecedor;

public class JDBCVendedorFornecedorDAO implements VendedorFornecedorDAO {

	private SessionFactory factory;

	public JDBCVendedorFornecedorDAO() {
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(VendedorFornecedor vendedorFornecedor) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(vendedorFornecedor);
		session.getTransaction().commit();
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		VendedorFornecedor vendedorFornecedor = new VendedorFornecedor();
		vendedorFornecedor.setId(id);
		session.delete(vendedorFornecedor);
		session.getTransaction().commit();
	}

	@Override
	public List<VendedorFornecedor> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<VendedorFornecedor> vendedoresFornecedor = session.createQuery("from VendedorFornecedor").getResultList();
		session.getTransaction().commit();
		return vendedoresFornecedor;
	}

	@Override
	public VendedorFornecedor buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		VendedorFornecedor vendedorFornecedor = new VendedorFornecedor();
		vendedorFornecedor.setId(id);
		vendedorFornecedor = session.get(VendedorFornecedor.class, vendedorFornecedor.getId());
		session.getTransaction().commit();
		return vendedorFornecedor;
	}

	@Override
	public void editar(VendedorFornecedor vendedorFornecedor) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(vendedorFornecedor);
		session.getTransaction().commit();
	}

}
