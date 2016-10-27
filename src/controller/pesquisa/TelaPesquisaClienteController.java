

package controller.pesquisa;

import java.net.URL;
import java.util.ResourceBundle;

import app.pesquisa.TelaPesquisaClienteApp;
import app.pesquisa.TelaPesquisaFornecedorApp;
import dao.jdbc.JDBCClienteDAO;
import dao.jdbc.JDBCFornecedorDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import model.Cliente;
import model.Fornecedor;

public class TelaPesquisaClienteController implements Initializable {

	@FXML
	private TextField txtPesquisa;

	@FXML
	private Button btPesquisa;

	@FXML
	private Label labelParametroPesquisa;

	@FXML
	private ListView<Cliente> listPesquisa;

	private static Cliente cliente;

	private JDBCClienteDAO clienteDAO = new JDBCClienteDAO();

	@FXML
	void pesquisar(ActionEvent event) {
		listPesquisa.getItems().setAll(clienteDAO.listarPorRazaoSocial(txtPesquisa.getText()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.listPesquisa.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listPesquisa.getItems().setAll(clienteDAO.listarPorRazaoSocial(txtPesquisa.getText()));
		this.listPesquisa.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				TelaPesquisaClienteController.cliente = this.listPesquisa.getSelectionModel().getSelectedItem();
				TelaPesquisaClienteApp.getStage().close();
			}
		});

	}

	public static Cliente getCliente() {
		return cliente;
	}
	
	public static void setCliente(Cliente cliente){
		TelaPesquisaClienteController.cliente = cliente;
	}

}