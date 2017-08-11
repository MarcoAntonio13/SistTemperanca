package dao.jdbc;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.dao.EstoqueMaterialDAO;
import model.EstoqueMaterial;
import model.EstoqueProduto;


public class JDBCEstoqueMaterialDAO implements EstoqueMaterialDAO {
	
	private SessionFactory factory;

	public JDBCEstoqueMaterialDAO(){
	factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(EstoqueMaterial estoqueMaterial) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(estoqueMaterial);
		session.getTransaction().commit();

	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		EstoqueMaterial estoqueMaterial = new EstoqueMaterial();
		estoqueMaterial.setId(id);
		session.delete(estoqueMaterial);
		session.getTransaction().commit();

	}

	@Override
	public List<EstoqueMaterial> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EstoqueMaterial> estoquesMateriais = session.createQuery("from EstoqueMaterial").getResultList();
		session.getTransaction().commit();
		return estoquesMateriais;
	}

	@Override
	public EstoqueMaterial buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		EstoqueMaterial estoqueMaterial = new EstoqueMaterial();
		estoqueMaterial.setId(id);
		estoqueMaterial = session.get(EstoqueMaterial.class, estoqueMaterial.getId());
		session.getTransaction().commit();
		return estoqueMaterial;
	}
	
	public EstoqueMaterial buscarPorIdMaterial(int id) {
		Session session = factory.getCurrentSession();
		try{
		session.beginTransaction();
		EstoqueMaterial estoqueMaterial = new EstoqueMaterial();
		estoqueMaterial = (EstoqueMaterial) session.createQuery("SELECT e from EstoqueMaterial e where e.material.id="+id).getSingleResult();
		session.getTransaction().commit();
		return estoqueMaterial;
		}catch(NoResultException e){
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public void editar(EstoqueMaterial estoqueMaterial) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(estoqueMaterial);
		session.getTransaction().commit();	

	}
	
	public List<EstoqueMaterial> listarPorNome(String nome) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EstoqueMaterial> estoquesMateriais = session.createQuery("SELECT e from EstoqueMaterial e where e.material.nome LIKE '%"+nome+ "%'").getResultList();
		session.getTransaction().commit();
		return estoquesMateriais;
	}
	
	public List<EstoqueMaterial> listarPorNomeExato(String nome) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EstoqueMaterial> estoquesMateriais = session.createQuery("SELECT e from EstoqueMaterial e where e.material.nome LIKE '"+nome+ "'").getResultList();
		session.getTransaction().commit();
		return estoquesMateriais;
	}
	
	

}
