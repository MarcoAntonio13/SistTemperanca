package controller.pesquisa;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Set;

import app.pesquisa.TelaPesquisaFornecedorApp;
import dao.dao.FornecedorDAO;
import dao.jdbc.JDBCFornecedorDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import model.Fornecedor;

public class TelaPesquisaFornecedorController implements Initializable {

    @FXML
    private TextField txtPesquisa;

    @FXML
    private Button btPesquisa;

    @FXML
    private Label labelParametroPesquisa;

    @FXML
    private ListView<Fornecedor> listPesquisa;
    
    private static Fornecedor fornecedor;
    
    private JDBCFornecedorDAO fornecedorDAO = new JDBCFornecedorDAO();
    
    @FXML
    void pesquisar(ActionEvent event) {
    	listPesquisa.getItems().setAll(fornecedorDAO.listarPorRazaoSocial(txtPesquisa.getText()));
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.listPesquisa.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listPesquisa.getItems().setAll(fornecedorDAO.listarPorRazaoSocial(txtPesquisa.getText()));
		this.listPesquisa.setOnMouseClicked(event -> {
			if(event.getClickCount() == 2){
				this.fornecedor = this.listPesquisa.getSelectionModel().getSelectedItem();
				TelaPesquisaFornecedorApp.getStage().close();
			}
		});
		
	}
	
	public static Fornecedor getFornecedor(){
		return fornecedor;
	}

}