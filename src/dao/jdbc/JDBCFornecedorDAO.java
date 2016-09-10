package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexao.ConnectionFactory;
import dao.dao.FornecedorDAO;
import model.Fornecedor;
import model.VendedorFornecedor;

public class JDBCFornecedorDAO implements FornecedorDAO {

	private Connection connection;

	public JDBCFornecedorDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Fornecedor fornecedor) {
		try {
			String SQL = "INSERT INTO fornecedor values (?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setInt(1, fornecedor.getId());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3, fornecedor.getRazaoSocial());
			ps.setLong(4, fornecedor.getTelefone());
			ps.setString(5, fornecedor.getEmail());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fornecedor buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Fornecedor fornecedor) {
		// TODO Auto-generated method stub

	}

}
