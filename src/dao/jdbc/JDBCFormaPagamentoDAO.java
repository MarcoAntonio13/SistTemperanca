package dao.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.FormaPagamentoDAO;

import model.FormaPagamento;

public class JDBCFormaPagamentoDAO implements FormaPagamentoDAO {

	private SessionFactory factory;

	public JDBCFormaPagamentoDAO() {
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(FormaPagamento formaPagamento) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(formaPagamento);
		session.getTransaction().commit();

	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setId(id);
		session.delete(formaPagamento);
		session.getTransaction().commit();
	}

	@Override
	public List<FormaPagamento> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<FormaPagamento> formasPagamento = session.createQuery("from FormaPagamento").getResultList();
		session.getTransaction().commit();
		return formasPagamento;
	}

	@Override
	public FormaPagamento buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setId(id);
		formaPagamento = session.get(FormaPagamento.class, formaPagamento.getId());
		session.getTransaction().commit();
		return formaPagamento;
	}

	@Override
	public void editar(FormaPagamento formaPagamento) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(formaPagamento);
		session.getTransaction().commit();
	}
}
