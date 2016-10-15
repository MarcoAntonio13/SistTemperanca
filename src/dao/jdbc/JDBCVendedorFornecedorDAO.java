package dao.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexao.ConnectionFactory;

import dao.dao.VendedorFornecedorDAO;

import model.VendedorFornecedor;

public class JDBCVendedorFornecedorDAO implements VendedorFornecedorDAO {

	private Connection connection;

	public JDBCVendedorFornecedorDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(VendedorFornecedor vendedorFornecedor) {
		try {
			String SQL = "INSERT INTO vendedorFornecedor values (null, ?, ?, ?, null)";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setString(1, vendedorFornecedor.getNome());
			ps.setLong(2, vendedorFornecedor.getTelefone());
			ps.setString(3, vendedorFornecedor.getEmail());
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void remover(int id) {
		try {
			String SQL = "DELETE FROM vendedorFornecedor WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<VendedorFornecedor> listar() {
		try {
			String SQL = "SELECT * FROM vendedorFornecedor";
			List<VendedorFornecedor> vendedoresFornecedores = new ArrayList<VendedorFornecedor>();
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				VendedorFornecedor vendedorFornecedor = new VendedorFornecedor();
				vendedorFornecedor.setId(rs.getInt("id"));
				vendedorFornecedor.setNome(rs.getString("nome"));
				vendedorFornecedor.setTelefone(rs.getLong("telefone"));
				vendedorFornecedor.setEmail(rs.getString("email"));
				vendedoresFornecedores.add(vendedorFornecedor);
			}
			return vendedoresFornecedores;

		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public VendedorFornecedor buscar(int id) {
		try {
			String SQL = "SELECT * FROM vendedorFornecedor where id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			VendedorFornecedor vendedorFornecedor = new VendedorFornecedor();
			vendedorFornecedor.setId(rs.getInt("id"));
			vendedorFornecedor.setNome(rs.getString("nome"));
			vendedorFornecedor.setTelefone(rs.getLong("telefone"));
			vendedorFornecedor.setEmail(rs.getString("email"));

			return vendedorFornecedor;
		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public void editar(VendedorFornecedor vendedorFornecedor) {
		try {
			String SQL = "UPDATE vendedorFornecedor set nome = ?, telefone = ?, email = ?  where id = ? ";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(4, vendedorFornecedor.getId());
			ps.setString(1, vendedorFornecedor.getNome());
			ps.setLong(2, vendedorFornecedor.getTelefone());
			ps.setString(3, vendedorFornecedor.getEmail());
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
