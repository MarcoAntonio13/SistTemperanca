

package controller.pesquisa;

import java.net.URL;
import java.util.ResourceBundle;

import app.pesquisa.TelaPesquisaTemperoApp;

import dao.jdbc.JDBCProdutoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import model.Produto;

public class TelaPesquisaTemperoController implements Initializable {

	@FXML
	private TextField txtPesquisa;

	@FXML
	private Button btPesquisa;

	@FXML
	private Label labelParametroPesquisa;

	@FXML
	private ListView<Produto> listPesquisa;

	private static Produto produto;

	private JDBCProdutoDAO produtoDAO = new JDBCProdutoDAO();

	@FXML
	void pesquisar(ActionEvent event) {
		listPesquisa.getItems().setAll(produtoDAO.listarPorNome(txtPesquisa.getText()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.listPesquisa.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listPesquisa.getItems().setAll(produtoDAO.listarPorNome(txtPesquisa.getText()));
		this.listPesquisa.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				TelaPesquisaTemperoController.produto = this.listPesquisa.getSelectionModel().getSelectedItem();
				TelaPesquisaTemperoApp.getStage().close();
			}
		});

	}

	public static Produto getProduto() {
		return produto;
	}
	
	public static void setProduto(Produto produto){
		TelaPesquisaTemperoController.produto = produto;
	}

}