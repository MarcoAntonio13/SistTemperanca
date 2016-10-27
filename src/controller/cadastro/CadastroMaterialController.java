package controller.cadastro;

import app.AlertaApp;
import app.pesquisa.TelaPesquisaFornecedorApp;
import app.pesquisa.TelaPesquisaMaterialApp;
import controller.pesquisa.TelaPesquisaFornecedorController;
import controller.pesquisa.TelaPesquisaMaterialController;
import dao.jdbc.JDBCMaterialDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Fornecedor;
import model.Material;

public class CadastroMaterialController {
	
	JDBCMaterialDAO materialDAO = new JDBCMaterialDAO();

    @FXML
    private Button btPesquisarMaterial;

    @FXML
    private TextField txtFornecedor;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPeso;

    @FXML
    private Button btPesquisarFornecedor;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtValorCompra;
    
    private Fornecedor fornecedorSelecionado;

    @FXML
    void pesquisarMaterial(ActionEvent event) throws Exception {
    	Stage stageTelaPesquisa = new Stage();
		stageTelaPesquisa.initModality(Modality.APPLICATION_MODAL);
		new TelaPesquisaMaterialApp().start(stageTelaPesquisa);
		if (TelaPesquisaMaterialController.getMaterial() != null)
			posicionaMaterial(TelaPesquisaMaterialController.getMaterial());
    }
    
    private void posicionaMaterial(Material material) {
		limpaCampos();
		
		if(material.getNome()!=null&&!material.getNome().isEmpty())
		txtNome.setText(material.getNome());
		
		if(material.getPeso()!=null)
		txtPeso.setText(Double.toString(material.getPeso()));
		
		txtId.setText(Integer.toString(material.getId()));
		
		if(material.getValorCompra()!=null)
		txtValorCompra.setText(Double.toString(material.getValorCompra()));
		
		if(material.getFornecedor()!=null){
		txtFornecedor.setText(material.getFornecedor().getRazaoSocial());
		fornecedorSelecionado = material.getFornecedor();
		}
	}
    
    private void limpaCampos(){
		txtId.setText("");
		txtNome.setText("");
		txtPeso.setText("");
		txtValorCompra.setText("");
		txtFornecedor.setText("");
		fornecedorSelecionado = null;
	}

    @FXML
    void salvar(ActionEvent event) throws Exception {
    	if (txtId.getText().isEmpty()) {
			Material material = new Material();
			material = montaMaterial();
			materialDAO.inserir(material);
			new AlertaApp().start(new Stage(), "Salvo com Sucesso!");
			txtId.setText(Integer.toString(material.getId()));

		} else {
			Material material = montaMaterial();
			materialDAO.editar(material);
			new AlertaApp().start(new Stage(), "Alterado com Sucesso!");
			posicionaMaterial(material);
		}
    }
    
    public Material montaMaterial() {
    	Material material = new Material();
		if (!txtId.getText().isEmpty())
			material.setId(Integer.parseInt(txtId.getText()));

		if (!txtNome.getText().isEmpty())
			material.setNome(txtNome.getText());

		if (!txtPeso.getText().isEmpty())
			material.setPeso(Double.valueOf(txtPeso.getText()));

		if (!txtValorCompra.getText().isEmpty())
			material.setValorCompra(Double.valueOf((txtValorCompra.getText())));

		if (!txtFornecedor.getText().isEmpty())
			material.setFornecedor(fornecedorSelecionado);
		

		return material;
	}

    @FXML
    void novo(ActionEvent event) {
    	limpaCampos();
    }

    @FXML
    void excluir(ActionEvent event) throws Exception {
    	if(!txtId.getText().isEmpty()){
			materialDAO.remover(Integer.parseInt(txtId.getText()));
			new AlertaApp().start(new Stage(), "Excluído com Sucesso!");
			limpaCampos();
		}else{
			new AlertaApp().start(new Stage(), "Selecione um Material para excluir.");
		}
    }

    @FXML
    void pesquisarFornecedor(ActionEvent event) throws Exception {
    	Stage stageTelaPesquisa = new Stage();
		stageTelaPesquisa.initModality(Modality.APPLICATION_MODAL);
		new TelaPesquisaFornecedorApp().start(stageTelaPesquisa);
		if (TelaPesquisaFornecedorController.getFornecedor() != null)
			posicionaFornecedor(TelaPesquisaFornecedorController.getFornecedor());
    }
    
    public void posicionaFornecedor(Fornecedor fornecedor){
    	fornecedorSelecionado = fornecedor;
    	txtFornecedor.setText(fornecedor.getRazaoSocial());
    }

}
