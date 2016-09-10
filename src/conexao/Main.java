package conexao;


import java.time.LocalDate;
import java.sql.Date;

import converter.DateConverter;
import dao.jdbc.JDBCDespesaDAO;
import model.Despesa;


public class Main {
	
	public static void main (String[]args){
		
		LocalDate data = LocalDate.of(2020, 4 , 20);
				
		Despesa despesa = new Despesa(18, "Conta de Luz", data , 256.76);
		JDBCDespesaDAO daoDespesa = new JDBCDespesaDAO();
		System.out.println(despesa.getData());
		Date dataSQL = DateConverter.convertToDatabaseColumn(despesa.getData());
		System.out.println(dataSQL);
//		daoDespesa.inserir(despesa);
		daoDespesa.listar().forEach(action -> System.out.println(action.getData()));
		
//		System.out.println(daoFormaPagamento.buscar(2).getNome());
//		daoFormaPagamento.remover(10);
		
//		JDBCClienteDAO daoCliente = new JDBCClienteDAO();
//		
//		System.out.println(daoCliente.buscar(1).getRazaoSocial());
//		daoCliente.listar().forEach(action -> System.out.println(action.getRazaoSocial()));
		
		
	}

}
