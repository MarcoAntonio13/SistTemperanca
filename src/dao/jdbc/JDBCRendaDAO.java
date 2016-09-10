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
import dao.dao.RendaDAO;
import model.Renda;

public class JDBCRendaDAO implements RendaDAO {
	
	private Connection connection;
	public JDBCRendaDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Renda renda) {
		try{
			String SQL = "INSERT INTO outras_rendas values (?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
		
			ps.setInt(1, renda.getId());
			ps.setString(2, renda.getDescricao());
			ps.setDate(4, new Date(DateConverter.convertToDatabaseColumn(renda.getData()).getTime()));
			ps.setDouble(3, renda.getValor());
			ps.setString(5, renda.getNome());
			ps.executeUpdate();
			
			}catch(SQLException ex){
				Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		
	}

	@Override
	public void remover(int id) {
		try{
			String SQL = "DELETE FROM outras_rendas WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, id);
	
			ps.executeUpdate();
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public List<Renda> listar() {
		try{
			String SQL = "SELECT * FROM outras_rendas";
			List<Renda> rendas = new ArrayList<Renda>();
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Renda renda = new Renda();
				renda.setId(rs.getInt("id"));
				renda.setDescricao(rs.getString("descricao"));
				renda.setData(DateConverter.convertToEntityAttribute(rs.getDate("data")));
				renda.setValor(rs.getDouble("valor"));
				renda.setNome(rs.getString("nome"));
				
				rendas.add(renda);
			}
			return rendas;
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public Renda buscar(int id) {
		try{
			String SQL = "SELECT * FROM outras_rendas where id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Renda renda = new Renda();
			renda.setId(rs.getInt("id"));
			renda.setDescricao(rs.getString("descricao"));
			renda.setData(DateConverter.convertToEntityAttribute(rs.getDate("data")));
			renda.setValor(rs.getDouble("valor"));
			renda.setNome(rs.getString("nome"));
			
			return renda;
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public void editar(Renda renda) {
		try{
			String SQL = "UPDATE outras_rendas set descricao = ?, data = ?, valor = ?, nome = ? where id = ? ";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setInt(5, renda.getId());
			ps.setString(1, renda.getDescricao());
			ps.setDate(2, new Date(DateConverter.convertToDatabaseColumn(renda.getData()).getTime()));
			ps.setDouble(3, renda.getValor());
			ps.setString(4, renda.getNome());
			ps.executeUpdate();
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
