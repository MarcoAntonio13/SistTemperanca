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
import dao.dao.FornecedorDAO;
import model.Fornecedor;

public class JDBCFornecedorDAO implements FornecedorDAO {

	private Connection connection;

	public JDBCFornecedorDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Fornecedor fornecedor) {
		try {
			String SQL = "INSERT INTO fornecedor values (null, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setString(1, fornecedor.getCnpj());
			ps.setString(2, fornecedor.getRazaoSocial());
			ps.setLong(3, fornecedor.getTelefone());
			ps.setString(4, fornecedor.getEmail());
			ps.executeUpdate();

			SQL = "UPDATE vendedorFornecedor SET idfornecedor = ? where id = ?";
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
		try {
			String SQL = "DELETE FROM fornecedor WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<Fornecedor> listar() {
		try {
			String SQL = "SELECT * FROM fornecedor";
			List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setCnpj(rs.getString("cnpj"));
				fornecedor.setRazaoSocial(rs.getString("razao_social"));
				fornecedor.setTelefone(rs.getLong("telefone"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedores.add(fornecedor);
			}
			return fornecedores;

		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public Fornecedor buscar(int id) {
		try {
			String SQL = "SELECT * FROM fornecedor where id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(rs.getInt("id"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setRazaoSocial(rs.getString("razao_social"));
			fornecedor.setTelefone(rs.getLong("telefone"));
			fornecedor.setEmail(rs.getString("email"));
			
			return fornecedor;
		} catch (SQLException ex) {
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public void editar(Fornecedor fornecedor) {
		try {
			String SQL = "UPDATE fornecedor set cnpj = ?, razao_social = ?, telefone = ?, email = ?   where id = ? ";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(5, fornecedor.getId());
			ps.setString(1, fornecedor.getCnpj());
			ps.setString(2, fornecedor.getRazaoSocial());
			ps.setLong(3, fornecedor.getTelefone());
			ps.setString(4, fornecedor.getEmail());
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

}
