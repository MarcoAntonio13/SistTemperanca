package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexao.ConnectionFactory;
import dao.dao.MaterialDAO;
import model.Material;

public class JDBCMaterialDAO implements MaterialDAO {
	
	private Connection connection;

	public JDBCMaterialDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Material material) {
		try {
			String SQL = "INSERT INTO material values (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(1, material.getId());
			ps.setString(2, material.getNome());
			ps.setDouble(3, material.getPeso());
			ps.setLong(4, material.getTelefone());
			ps.executeUpdate();

			SQL = "UPDATE vendedor_fornecedor SET id_fornecedor = ? where id = ?";
			PreparedStatement ps2 = connection.prepareStatement(SQL);
			fornecedor.getVendedores().forEach(vendedorFornecedor -> {

				try {
					ps2.setInt(1, fornecedor.getId());
					ps2.setInt(2, vendedorFornecedor.getId());
					ps2.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});

		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Material> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Material buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Material material) {
		// TODO Auto-generated method stub
		
	}

}
