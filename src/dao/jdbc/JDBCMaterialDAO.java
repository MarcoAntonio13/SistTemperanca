package dao.jdbc;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dao.dao.MaterialDAO;
import model.Material;

public class JDBCMaterialDAO implements MaterialDAO {
	
	private SessionFactory factory;

	public JDBCMaterialDAO() {
		
		factory = HibernateStarter.getSessionFactory();
	}

	@Override
	public void inserir(Material material) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(material);
		session.getTransaction().commit();
	}

	@Override
	public void remover(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Material material = new Material();
		material.setId(id);
		session.delete(material);
		session.getTransaction().commit();		
	}

	@Override
	public List<Material> listar() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Material> materiais = session.createQuery("from Material").getResultList();
		session.getTransaction().commit();
		return materiais;
	}

	@Override
	public Material buscar(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Material material = new Material();
		material.setId(id);
		material = session.get(Material.class, material.getId());
		session.getTransaction().commit();
		return material;
	}

	@Override
	public void editar(Material material) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(material);
		session.getTransaction().commit();
		
	}

}
