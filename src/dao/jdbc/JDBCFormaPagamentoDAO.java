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
import dao.dao.FormaPagamentoDAO;
import model.FormaPagamento;

public class JDBCFormaPagamentoDAO implements FormaPagamentoDAO {

	Connection connection;

	public JDBCFormaPagamentoDAO() {

		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(FormaPagamento formaPagamento) {
		try{
			String SQL = "INSERT INTO forma_de_pagamento values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, formaPagamento.getId());
			ps.setString(2, formaPagamento.getNome());
			ps.setString(3, formaPagamento.getDescricao());

			ps.executeUpdate();
			
			}catch(SQLException ex){
				Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		
	}

	@Override
	public void remover(int id) {
		try{
			String SQL = "DELETE FROM forma_de_pagamento WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			
			ps.setInt(1, id);
	
			ps.executeUpdate();
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	@Override
	public List<FormaPagamento> listar() {
		try{
			String SQL = "SELECT * FROM forma_de_pagamento";
			List<FormaPagamento> formasPagamento = new ArrayList<FormaPagamento>();
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				FormaPagamento formaPagamento = new FormaPagamento();
				formaPagamento.setId(rs.getInt("id"));
				formaPagamento.setNome(rs.getString("nome"));
				formaPagamento.setDescricao(rs.getString("descricao"));
				
				formasPagamento.add(formaPagamento);
			}
			return formasPagamento;
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public FormaPagamento buscar(int id) {
		try{
			String SQL = "SELECT * FROM forma_de_pagamento where id = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			FormaPagamento formaPagamento = new FormaPagamento();
			formaPagamento.setId(rs.getInt("id"));
			formaPagamento.setNome(rs.getString("nome"));
			formaPagamento.setDescricao(rs.getString("descricao"));
			
			return formaPagamento;
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	@Override
	public void editar(FormaPagamento formaPagamento) {
		try{
			String SQL = "UPDATE forma_de_pagamento set nome = ?, descricao = ? where id = ? ";
			PreparedStatement ps = connection.prepareStatement(SQL);
		
			ps.setString(1, formaPagamento.getNome());
			ps.setString(2, formaPagamento.getDescricao());
			ps.setInt(3, formaPagamento.getId());
	
			ps.executeUpdate();
			
		}catch(SQLException ex){
			Logger.getLogger(JDBCClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}



}
