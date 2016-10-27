package controller.pesquisa;

import java.net.URL;

import java.util.ResourceBundle;

import app.pesquisa.TelaPesquisaMaterialApp;

import dao.jdbc.JDBCMaterialDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import model.Material;

public class TelaPesquisaMaterialController implements Initializable {

	@FXML
	private TextField txtPesquisa;

	@FXML
	private Button btPesquisa;

	@FXML
	private Label labelParametroPesquisa;

	@FXML
	private ListView<Material> listPesquisa;

	private static Material material;

	private JDBCMaterialDAO materialDAO = new JDBCMaterialDAO();

	@FXML
	void pesquisar(ActionEvent event) {
		listPesquisa.getItems().setAll(materialDAO.listarPorNome(txtPesquisa.getText()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.listPesquisa.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listPesquisa.getItems().setAll(materialDAO.listarPorNome(txtPesquisa.getText()));
		this.listPesquisa.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				TelaPesquisaMaterialController.material = this.listPesquisa.getSelectionModel().getSelectedItem();
				TelaPesquisaMaterialApp.getStage().close();
			}
		});

	}

	public static Material getMaterial() {
		return material;
	}

}
