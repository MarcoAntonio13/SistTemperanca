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
    	if(txtId.getText().isEmpty()){
    	fornecedorDAO.inserir(montaFornecedor());
    	new AlertaApp().start(new Stage(), "Salvo com Sucesso!");
    	}
    	else{
    		fornecedorDAO.editar(montaFornecedor());
    		new AlertaApp().start(new Stage(), "Alterado com Sucesso!");
    	}
    	
    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void excluir(ActionEvent event) {

    }
    
    @FXML
    void pesquisar(ActionEvent event) throws Exception {
    	Stage stageTelaPesquisa = new Stage();
    	stageTelaPesquisa.initModality(Modality.APPLICATION_MODAL);
    	new TelaPesquisaApp().start(stageTelaPesquisa);
    	if(TelaPesquisaController.getFornecedor() != null)
    	posicionaFornecedor(TelaPesquisaController.getFornecedor());
    }
    
    public Fornecedor montaFornecedor(){
    	Fornecedor fornecedor = new Fornecedor();
    	if(!txtId.getText().isEmpty())
    	fornecedor.setId(Integer.parseInt(txtId.getText()));
    	
    	if(!txtCnpj.getText().isEmpty())
    	fornecedor.setCnpj(txtCnpj.getText());
    	
    	if(!txtRazaoSocial.getText().isEmpty())
    	fornecedor.setRazaoSocial(txtRazaoSocial.getText());
    	
    	if(!txtTelefone.getText().isEmpty())
    	fornecedor.setTelefone(Long.parseLong(txtTelefone.getText()));
    	
    	if(!txtEmail.getText().isEmpty())
    	fornecedor.setEmail(txtEmail.getText());
    	
    	return fornecedor;
    }
    
    public void posicionaFornecedor(Fornecedor fornecedor){
    	txtCnpj.setText(fornecedor.getCnpj());
    	txtRazaoSocial.setText(fornecedor.getRazaoSocial());
    	txtId.setText(Integer.toString(fornecedor.getId()));
    	txtEmail.setText(fornecedor.getEmail());
    	txtTelefone.setText(Long.toString(fornecedor.getTelefone()));
    }
    
}
