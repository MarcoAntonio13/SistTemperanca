package conexao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
	
	public static Connection getConnection(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/sist_temperanca", "root", "root");
		} catch(SQLException ex){
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
			throw new RuntimeException("Erro SQLException ao abrir a conexão em ConnectionFactory");
		}catch (ClassNotFoundException ex){
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
			throw new RuntimeException("Erro ClassNotFoundException em ConnectionFactory");
		}

		
	}
	

}
