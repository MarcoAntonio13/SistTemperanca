package controller.lancamento;

import java.time.LocalDate;

import org.hibernate.loader.entity.EntityJoinWalker;

import app.AlertaApp;
import app.pesquisa.TelaPesquisaLancamentoMaterialApp;
import app.pesquisa.TelaPesquisaMaterialApp;
import app.pesquisa.TelaPesquisaTemperoApp;
import controller.pesquisa.TelaPesquisaLancamentoMaterialController;
import controller.pesquisa.TelaPesquisaMaterialController;
import controller.pesquisa.TelaPesquisaTemperoController;
import dao.jdbc.JDBCEstoqueMaterialDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.EstoqueMaterial;
import model.Material;
import model.Produto;

public class LancamentoMaterialController {

	@FXML
	private TextField txtId;

	@FXML
	private Button btPesquisar;

	@FXML
	private TextField txtQuantidade;

	@FXML
	private TextField txtMaterial;

	@FXML
	private DatePicker dtLancamento;

	private EstoqueMaterial estoqueMaterialSelecionado;

	private Material materialSelecionado;
	
	private JDBCEstoqueMaterialDAO estoqueMaterialDAO = new JDBCEstoqueMaterialDAO();

	@FXML
	void pesquisar(ActionEvent event) throws Exception {
		Stage stageTelaPesquisa = new Stage();
		stageTelaPesquisa.initModality(Modality.APPLICATION_MODAL);
		new TelaPesquisaLancamentoMaterialApp().start(stageTelaPesquisa);
		if (TelaPesquisaLancamentoMaterialController.getEstoqueMaterial() != null) {
			System.out.println("Data da entrada: "+TelaPesquisaLancamentoMaterialController.getEstoqueMaterial().getDataEntrada());
			posicionaLancamentoMaterial(TelaPesquisaLancamentoMaterialController.getEstoqueMaterial());
			estoqueMaterialSelecionado = TelaPesquisaLancamentoMaterialController.getEstoqueMaterial();
			TelaPesquisaLancamentoMaterialController.setEstoqueMaterial(null);
		}
	}

	private void posicionaLancamentoMaterial(EstoqueMaterial estoqueMaterial) {
		limpaCampos();

		if (estoqueMaterial.getMaterial() != null) {
			txtMaterial.setText(estoqueMaterial.getMaterial().getNome());
		}

		if (estoqueMaterial.getDataEntrada() != null)
			dtLancamento.setValue(estoqueMaterial.getDataEntrada());

		txtId.setText(Integer.toString(estoqueMaterial.getId()));

		if (estoqueMaterial.getQuantidade() != null)
			txtQuantidade.setText(Integer.toString(estoqueMaterial.getQuantidade()));

		estoqueMaterialSelecionado = estoqueMaterial;
	}

	private void limpaCampos() {
		txtId.setText("");
		txtMaterial.setText("");
		dtLancamento.setValue(null);
		txtQuantidade.setText("");
		estoqueMaterialSelecionado = null;
	}

	@FXML
	void lancar(ActionEvent event) throws Exception {
		if (txtId.getText().isEmpty()) {
			EstoqueMaterial estoqueMaterial = new EstoqueMaterial();
			estoqueMaterial = montaEstoqueMaterial();
			estoqueMaterialDAO.inserir(estoqueMaterial);
			txtId.setText(Integer.toString(estoqueMaterial.getId()));
			dtLancamento.setValue(estoqueMaterial.getDataEntrada());
			new AlertaApp().start(new Stage(), "Salvo com Sucesso!");

		} else {
			EstoqueMaterial estoqueMaterial = new EstoqueMaterial();
			estoqueMaterial = montaEstoqueMaterial();
			estoqueMaterialDAO.editar(estoqueMaterial);
			new AlertaApp().start(new Stage(), "Alterado com Sucesso!");

		}
	}

	private EstoqueMaterial montaEstoqueMaterial() {
		EstoqueMaterial estoqueMaterial = new EstoqueMaterial();
		
		if(materialSelecionado!=null)
			estoqueMaterial.setMaterial(materialSelecionado);
		
		if(dtLancamento.getValue()== null)
			estoqueMaterial.setDataEntrada(LocalDate.now());
		else
			estoqueMaterial.setDataEntrada(estoqueMaterialSelecionado.getDataEntrada());
		
		if(txtQuantidade.getText()!=null&&!txtQuantidade.getText().isEmpty())
			estoqueMaterial.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
		
		return estoqueMaterial;
	}

	@FXML
	void novoLancamento(ActionEvent event) {
		limpaCampos();
	}

	@FXML
	void excluir(ActionEvent event) throws Exception {
		if (!txtId.getText().isEmpty()) {
			estoqueMaterialDAO.remover(Integer.parseInt(txtId.getText()));
			new AlertaApp().start(new Stage(), "Excluído com Sucesso!");
			limpaCampos();
		} else {
			new AlertaApp().start(new Stage(), "Selecione um Tempero para excluir.");
		}
	}
	
	@FXML
	void pesquisarMaterial(ActionEvent event) throws Exception {
		Stage stageTelaPesquisa = new Stage();
		stageTelaPesquisa.initModality(Modality.APPLICATION_MODAL);
		new TelaPesquisaMaterialApp().start(stageTelaPesquisa);
		if (TelaPesquisaMaterialController.getMaterial() != null) {
			posicionaMaterial(TelaPesquisaMaterialController.getMaterial());
			TelaPesquisaMaterialController.setMaterial(null);
		}
	}

	private void posicionaMaterial(Material material) {
		
		if(material.getNome()!=null&&!material.getNome().isEmpty())
			txtMaterial.setText(material.getNome());
		
		materialSelecionado = material;
		
	}
	
	

}
