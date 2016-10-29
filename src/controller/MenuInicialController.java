package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MenuInicialController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @FXML
    private AnchorPane telaPane;

    @FXML
    private TabPane tabPane;
    
    @FXML
    private BorderPane principalBorderPane;
    
    @FXML
    void abrirCadastroMaterial(ActionEvent event) throws IOException {
    	AnchorPane painelMaterial = FXMLLoader.load(getClass().getResource("/view/cadastro/CadastroMaterialView.fxml"));
    	
    	Tab tab = new Tab("Cadastro de Materiais");
    	tab.setContent(painelMaterial);
    	tab.setClosable(true);
    	tabPane.getTabs().add(tab);
    	tabPane.getSelectionModel().select(tab);
    	
    	principalBorderPane.setCenter(tabPane);
    }
    

	@FXML
	void abrirCadastroFornecedor(ActionEvent event) throws IOException {
		AnchorPane painelFornecedor = FXMLLoader.load(getClass().getResource("/view/cadastro/CadastroFornecedorView.fxml"));
		Tab tab = new Tab("Cadastro de Fornecedor");
		tab.setContent(painelFornecedor);
		tab.setClosable(true);
		tabPane.getTabs().add(tab);
		tabPane.getSelectionModel().select(tab);

		principalBorderPane.setCenter(tabPane);

	}
	
	@FXML
	void abrirCadastroCliente(ActionEvent event) throws IOException {
		AnchorPane painelCliente = FXMLLoader.load(getClass().getResource("/view/cadastro/CadastroClienteView.fxml"));
		Tab tab = new Tab("Cadastro de Cliente");
		tab.setContent(painelCliente);
		tab.setClosable(true);
		tabPane.getTabs().add(tab);
		tabPane.getSelectionModel().select(tab);

		principalBorderPane.setCenter(tabPane);

	}
	
	@FXML
	void abrirCadastroTempero(ActionEvent event) throws IOException {
		AnchorPane painelCliente = FXMLLoader.load(getClass().getResource("/view/cadastro/CadastroTemperoView.fxml"));
		Tab tab = new Tab("Cadastro de Tempero");
		tab.setContent(painelCliente);
		tab.setClosable(true);
		tabPane.getTabs().add(tab);
		tabPane.getSelectionModel().select(tab);

		principalBorderPane.setCenter(tabPane);

	}
	
	@FXML
	void abrirVenda(ActionEvent event) throws IOException {
		AnchorPane painelCliente = FXMLLoader.load(getClass().getResource("/view/VendaView.fxml"));
		Tab tab = new Tab("Venda");
		tab.setContent(painelCliente);
		tab.setClosable(true);
		tabPane.getTabs().add(tab);
		tabPane.getSelectionModel().select(tab);

		principalBorderPane.setCenter(tabPane);

	}
	
	@FXML
	void abrirLancamentoMaterial(ActionEvent event) throws IOException {
		AnchorPane painelCliente = FXMLLoader.load(getClass().getResource("/view/lancamento/LancamentoMaterialView.fxml"));
		Tab tab = new Tab("Lancamento de Material");
		tab.setContent(painelCliente);
		tab.setClosable(true);
		tabPane.getTabs().add(tab);
		tabPane.getSelectionModel().select(tab);

		principalBorderPane.setCenter(tabPane);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tabPane.getTabs().clear();
		
		
	}
	
	public TabPane getTabPane (){
		return this.tabPane;
	}

}
