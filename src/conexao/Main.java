package conexao;


import java.time.LocalDate;
import java.sql.Date;

import converter.DateConverter;
import dao.jdbc.JDBCDespesaDAO;
import model.Despesa;


public class Main {
	
	public static void main (String[]args){
		
		LocalDate data = LocalDate.of(2010, 4 , 20);
				
		Despesa despesa = new Despesa(19, "Oeeee", data , 3000.67);
		JDBCDespesaDAO daoDespesa = new JDBCDespesaDAO();

		daoDespesa.inserir(despesa);
//		daoDespesa.listar().forEach(action -> System.out.println(action.getData()));
//		daoDespesa.editar(despesa);
//		System.out.println(daoFormaPagamento.buscar(2).getNome());
//		daoFormaPagamento.remover(10);
//		
//		JDBCClienteDAO daoCliente = new JDBCClienteDAO();
//		
//		System.out.println(daoCliente.buscar(1).getRazaoSocial());
//		daoCliente.listar().forEach(action -> System.out.println(action.getRazaoSocial()));
		
		
	}

}
