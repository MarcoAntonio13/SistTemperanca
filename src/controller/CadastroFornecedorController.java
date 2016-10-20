package controller;


import dao.jdbc.JDBCFornecedorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
    void salvar(ActionEvent event) {
    	fornecedorDAO.inserir(montaFornecedor());
    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void excluir(ActionEvent event) {

    }
    
    public Fornecedor montaFornecedor(){
    	Fornecedor fornecedor = new Fornecedor();
    	fornecedor.setCnpj(txtCnpj.getText());
    	fornecedor.setRazaoSocial(txtRazaoSocial.getText());
    	fornecedor.setTelefone(Long.parseLong(txtTelefone.getText()));
    	fornecedor.setEmail(txtEmail.getText());
    	return fornecedor;
    }
    
}
