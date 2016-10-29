

package controller.pesquisa;

import java.net.URL;
import java.util.ResourceBundle;

import app.pesquisa.TelaPesquisaClienteApp;
import app.pesquisa.TelaPesquisaFornecedorApp;
import app.pesquisa.TelaPesquisaLancamentoMaterialApp;
import dao.jdbc.JDBCClienteDAO;
import dao.jdbc.JDBCEstoqueMaterialDAO;
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
import model.EstoqueMaterial;
import model.Fornecedor;

public class TelaPesquisaLancamentoMaterialController implements Initializable {

	@FXML
	private TextField txtPesquisa;

	@FXML
	private Button btPesquisa;

	@FXML
	private Label labelParametroPesquisa;

	@FXML
	private ListView<EstoqueMaterial> listPesquisa;

	private static EstoqueMaterial estoqueMaterial;

	private JDBCEstoqueMaterialDAO estoqueMaterialDAO = new JDBCEstoqueMaterialDAO();

	@FXML
	void pesquisar(ActionEvent event) {
		listPesquisa.getItems().setAll(estoqueMaterialDAO.listarPorNome(txtPesquisa.getText()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.listPesquisa.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listPesquisa.getItems().setAll(estoqueMaterialDAO.listarPorNome(txtPesquisa.getText()));
		this.listPesquisa.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				TelaPesquisaLancamentoMaterialController.estoqueMaterial = this.listPesquisa.getSelectionModel().getSelectedItem();
				TelaPesquisaLancamentoMaterialApp.getStage().close();
			}
		});

	}

	public static EstoqueMaterial getEstoqueMaterial() {
		return estoqueMaterial;
	}
	
	public static void setEstoqueMaterial(EstoqueMaterial estoqueMaterial){
		TelaPesquisaLancamentoMaterialController.estoqueMaterial = estoqueMaterial;
	}

}