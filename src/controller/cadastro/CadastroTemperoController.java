package controller.cadastro;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import app.AlertaApp;
import app.pesquisa.TelaPesquisaMaterialApp;
import app.pesquisa.TelaPesquisaTemperoApp;
import controller.pesquisa.TelaPesquisaMaterialController;
import controller.pesquisa.TelaPesquisaTemperoController;
import dao.jdbc.JDBCProdutoDAO;
import dao.jdbc.JDBCReceitaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Material;
import model.Produto;
import model.Receita;

public class CadastroTemperoController {

	@FXML
	private Button btPesquisarMaterial;

	@FXML
	private ListView<Receita> listReceita;

	@FXML
	private TextField txtId;

	@FXML
	private Button btPesquisar;

	@FXML
	private Button btAdicionarMaterial;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtMaterial;

	@FXML
	private TextField txtPesoProduto;

	@FXML
	private TextField txtValorVenda;

	@FXML
	private TextField txtValorProducao;

	@FXML
	private TextField txtPesoMaterial;

	JDBCProdutoDAO produtoDAO = new JDBCProdutoDAO();

	JDBCReceitaDAO receitaDAO = new JDBCReceitaDAO();

	private Material materialSelecionado;

	private Produto produtoSelecionado;

	@FXML
	void pesquisar(ActionEvent event) throws Exception {
		Stage stageTelaPesquisa = new Stage();
		stageTelaPesquisa.initModality(Modality.APPLICATION_MODAL);
		new TelaPesquisaTemperoApp().start(stageTelaPesquisa);
		if (TelaPesquisaTemperoController.getProduto() != null) {
			posicionaTempero(TelaPesquisaTemperoController.getProduto());
			produtoSelecionado = TelaPesquisaTemperoController.getProduto();
			TelaPesquisaTemperoController.setProduto(null);
		}
	}

	private void posicionaTempero(Produto produto) {

		limpaCampos();

		if (produto.getNome() != null && !produto.getNome().isEmpty())
			txtNome.setText(produto.getNome());

		if (produto.getValorVenda() != null)
			txtValorVenda.setText(Double.toString(produto.getValorVenda()));

		txtId.setText(Integer.toString(produto.getId()));

		if (produto.getPesoPorEmbalagem() != null)
			txtPesoProduto.setText(Double.toString(produto.getPesoPorEmbalagem()));

		if (produto.getValorProducao() != null)
			txtValorProducao.setText(Double.toString(produto.getValorProducao()));

		if (!produto.getReceitas().isEmpty())
			listReceita.getItems().addAll(produto.getReceitas());

	}

	private void limpaCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtValorVenda.setText("");
		txtPesoProduto.setText("");
		txtValorProducao.setText("");

		limpaCamposMaterial();

		if (!listReceita.getItems().isEmpty())
			listReceita.getItems().clear();

	}

	private void limpaCamposMaterial() {
		txtMaterial.setText("");
		txtPesoMaterial.setText("");
	}

	@FXML
	void salvar(ActionEvent event) throws Exception {
		if (txtId.getText().isEmpty()) {
			Produto produto = new Produto();
			produto = montaProduto();
			produtoDAO.inserir(produto);
			txtId.setText(Integer.toString(produto.getId()));
			produtoSelecionado = produto;
			produto = montaProduto();
			produtoDAO.editar(produto);
			new AlertaApp().start(new Stage(), "Salvo com Sucesso!");

		} else {
			Produto produto = new Produto();
			produto = montaProduto();
			produtoDAO.editar(produto);
			new AlertaApp().start(new Stage(), "Alterado com Sucesso!");

		}
	}

	public Produto montaProduto() {
		Produto produto = new Produto();
		if (!txtId.getText().isEmpty())
			produto.setId(Integer.parseInt(txtId.getText()));

		if (!txtNome.getText().isEmpty())
			produto.setNome(txtNome.getText());

		if (!txtValorVenda.getText().isEmpty())
			produto.setValorVenda(Double.parseDouble(txtValorVenda.getText()));

		if (!txtPesoProduto.getText().isEmpty())
			produto.setPesoPorEmbalagem(Double.parseDouble(txtPesoProduto.getText()));

		if (!txtValorProducao.getText().isEmpty())
			produto.setValorProducao(Double.parseDouble(txtValorProducao.getText()));

		if (!listReceita.getItems().isEmpty()) {
			listReceita.getItems().forEach(action -> {
				action.setProduto(produtoSelecionado);
			});
			produto.setReceitas(listReceita.getItems());
		}

		return produto;
	}

	@FXML
	void novo(ActionEvent event) {
		limpaCampos();
	}

	@FXML
	void excluir(ActionEvent event) throws Exception {
		if (!txtId.getText().isEmpty()) {
			produtoDAO.remover(Integer.parseInt(txtId.getText()));
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
			materialSelecionado = TelaPesquisaMaterialController.getMaterial();
		}
	}

	private void posicionaMaterial(Material material) {
		txtMaterial.setText(material.getNome());
	}

	@FXML
	void adicionarMaterial(ActionEvent event) {
		Receita receita = new Receita();
		// System.out.println("Material Selecionado
		// ID:"+materialSelecionado.getId());
		if (materialSelecionado != null)
			receita.setMaterial(materialSelecionado);

		if (!txtPesoMaterial.getText().isEmpty())
			receita.setPesoMaterial(Double.parseDouble(txtPesoMaterial.getText()));

		// System.out.println("Material Selecionado
		// ID:"+produtoSelecionado.getId());
		if (produtoSelecionado != null)
			receita.setProduto(produtoSelecionado);

		listReceita.getItems().add(receita);
		limpaCamposMaterial();
	}

}
