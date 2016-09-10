package dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import conexao.ConnectionFactory;
import converter.DateConverter;
import dao.dao.DespesaDAO;
import model.Despesa;

public class JDBCDespesaDAO implements DespesaDAO {
	
	private Connection connection;
	public JDBCDespesaDAO() {
		
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Despesa despesa) {
		try{
			String SQL = "INSERT INTO despesas_diversas values (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
		
			ps.setInt(1, despesa.getId());
			ps.setString(2, despesa.getDescricao());
			ps.setDate(3, new Date(DateConverter.convertToDatabaseColumn(despesa.getData()).getTime()));
			ps.setDouble(4, despesa.getValor());
			ps.executeUpdate();
			
			}catch(SQLException ex){
				Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		
	}

	@Override
	public void remover(int id) {
		try{
			String SQL = "DELETE FROM despesa WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, id);
	
			ps.executeUpdate();
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	@Override
	public List<Despesa> listar() {
		try{
			String SQL = "SELECT * FROM despesas_diversas";
			List<Despesa> despesas = new ArrayList<Despesa>();
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Despesa despesa = new Despesa();
				despesa.setId(rs.getInt("id"));
				despesa.setDescricao(rs.getString("descricao"));
				despesa.setData(DateConverter.convertToEntityAttribute(rs.getDate("data")));
				despesa.setValor(rs.getDouble("valor"));
				
				despesas.add(despesa);
			}
			return despesas;
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public Despesa buscar(int id) {
		try{
			String SQL = "SELECT * FROM despesas_diversas where id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Despesa despesa = new Despesa();
			despesa.setId(rs.getInt("id"));
			despesa.setDescricao(rs.getString("descricao"));
			despesa.setData(DateConverter.convertToEntityAttribute(rs.getDate("data")));
			despesa.setValor(rs.getDouble("valor"));
			
			return despesa;
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public void editar(Despesa despesa) {
		try{
			String SQL = "UPDATE despesas_diversas set descricao = ?, data = ?, valor = ? where id = ? ";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setInt(4, despesa.getId());
			ps.setString(1, despesa.getDescricao());
			ps.setDate(2, new Date(DateConverter.convertToDatabaseColumn(despesa.getData()).getTime()));
			ps.setDouble(3, despesa.getValor());
			ps.executeUpdate();
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}
