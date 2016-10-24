package controller;

import java.io.IOException;

import app.AlertaApp;
import app.MenuInicialApp;
import app.TelaPesquisaApp;
import dao.jdbc.JDBCFornecedorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Fornecedor;

public class CadastroFornecedorController {

	JDBCFornecedorDAO fornecedorDAO = new JDBCFornecedorDAO();

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtRazaoSocial;

	@FXML
	private TextField txtTelefone;

	@FXML
	private TextField txtCnpj;

	@FXML
	private TextField txtEmail;

	@FXML
	void salvar(ActionEvent event) throws Exception {
		if (txtId.getText().isEmpty()) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor = montaFornecedor();
			fornecedorDAO.inserir(fornecedor);
			new AlertaApp().start(new Stage(), "Salvo com Sucesso!");
			txtId.setText(Integer.toString(fornecedor.getId()));

		} else {
			Fornecedor fornecedor = montaFornecedor();
			fornecedorDAO.editar(fornecedor);
			new AlertaApp().start(new Stage(), "Alterado com Sucesso!");
			posicionaFornecedor(fornecedor);
		}

	}

	@FXML
	void novo(ActionEvent event) {
		limpaCampos();
	}

	@FXML
	void excluir(ActionEvent event) throws Exception {
		if(!txtId.getText().isEmpty()){
			fornecedorDAO.remover(Integer.parseInt(txtId.getText()));
			new AlertaApp().start(new Stage(), "Excluído com Sucesso!");
			limpaCampos();
		}else{
			new AlertaApp().start(new Stage(), "Selecione um Fornecedor para excluir.");
		}
	}

	@FXML
	void pesquisar(ActionEvent event) throws Exception {
		Stage stageTelaPesquisa = new Stage();
		stageTelaPesquisa.initModality(Modality.APPLICATION_MODAL);
		new TelaPesquisaApp().start(stageTelaPesquisa);
		if (TelaPesquisaController.getFornecedor() != null)
			posicionaFornecedor(TelaPesquisaController.getFornecedor());
	}

	public Fornecedor montaFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		if (!txtId.getText().isEmpty())
			fornecedor.setId(Integer.parseInt(txtId.getText()));

		if (!txtCnpj.getText().isEmpty())
			fornecedor.setCnpj(txtCnpj.getText());

		if (!txtRazaoSocial.getText().isEmpty())
			fornecedor.setRazaoSocial(txtRazaoSocial.getText());

		if (!txtTelefone.getText().isEmpty())
			fornecedor.setTelefone(Long.parseLong(txtTelefone.getText()));

		if (!txtEmail.getText().isEmpty())
			fornecedor.setEmail(txtEmail.getText());
		

		return fornecedor;
	}

	private void posicionaFornecedor(Fornecedor fornecedor) {
		limpaCampos();
		
		if(fornecedor.getCnpj()!=null&&!fornecedor.getCnpj().isEmpty())
		txtCnpj.setText(fornecedor.getCnpj());
		
		if(fornecedor.getRazaoSocial()!=null&&!fornecedor.getRazaoSocial().isEmpty())
		txtRazaoSocial.setText(fornecedor.getRazaoSocial());
		
		txtId.setText(Integer.toString(fornecedor.getId()));
		
		if(fornecedor.getEmail()!=null&&!fornecedor.getEmail().isEmpty())
		txtEmail.setText(fornecedor.getEmail());
		
		if(fornecedor.getTelefone()!=null)
		txtTelefone.setText(Long.toString(fornecedor.getTelefone()));
	}
	
	private void limpaCampos(){
		txtId.setText("");
		txtCnpj.setText("");
		txtRazaoSocial.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
	}
	

}
