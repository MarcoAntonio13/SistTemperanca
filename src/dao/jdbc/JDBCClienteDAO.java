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
import dao.dao.ClienteDAO;
import model.Cliente;

public class JDBCClienteDAO implements ClienteDAO {
	
	Connection connection;
	public JDBCClienteDAO() {
		
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Cliente cliente) {
		try{
		String SQL = "INSERT INTO cliente values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(SQL);
		
		ps.setInt(1, cliente.getId());
		ps.setFloat(2, cliente.getCnpj());
		ps.setInt(3, cliente.getNumeroEstabelecimento());
		ps.setInt(4, cliente.getCep());
		ps.setString(5, cliente.getBairro());
		ps.setString(6, cliente.getRua());
		ps.setString(7, cliente.getRazaoSocial());

		ps.executeUpdate();
		
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
	}

	@Override
	public void remover(int id) {
		try{
			String SQL = "DELETE FROM cliente WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, id);
	
			ps.executeUpdate();
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<Cliente> listar() {
		try{
			String SQL = "SELECT * FROM cliente";
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setCnpj(rs.getLong("cnpj"));
				cliente.setNumeroEstabelecimento(rs.getInt("numero_do_estabelecimento"));
				cliente.setCep(rs.getInt("cep"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setRua(rs.getString("rua"));
				cliente.setRazaoSocial(rs.getString("razao_social"));
				
				clientes.add(cliente);
			}
			return clientes;
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public Cliente buscar(int id) {
		try{
			String SQL = "SELECT * FROM cliente where id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Cliente cliente = new Cliente();
			rs.next();
			cliente.setId(rs.getInt("id"));
			cliente.setCnpj(rs.getLong("cnpj"));
			cliente.setNumeroEstabelecimento(rs.getInt("numero_do_estabelecimento"));
			cliente.setCep(rs.getInt("cep"));
			cliente.setBairro(rs.getString("bairro"));
			cliente.setRua(rs.getString("rua"));
			cliente.setRazaoSocial(rs.getString("razao_social"));
			
			return cliente;
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
		
	}

	@Override
	public void editar(Cliente cliente) {
		try{
			String SQL = "UPDATE cliente set cnpj = ?, numero_do_estabelecimento = ?, cep = ?, bairro = ?, rua = ?, razao_social = ? where id = ? ";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setFloat(1, cliente.getCnpj());
			ps.setInt(2, cliente.getNumeroEstabelecimento());
			ps.setInt(3, cliente.getCep());
			ps.setString(4, cliente.getBairro());
			ps.setString(5, cliente.getRua());
			ps.setString(6, cliente.getRazaoSocial());
			ps.setInt(7, cliente.getId());
	
			ps.executeUpdate();
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
