package controller.cadastro;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.w3c.dom.ls.LSInput;

import app.AlertaApp;
import app.pesquisa.TelaPesquisaClienteApp;
import app.pesquisa.TelaPesquisaFornecedorApp;
import controller.pesquisa.TelaPesquisaClienteController;
import controller.pesquisa.TelaPesquisaFornecedorController;
import dao.jdbc.JDBCClienteDAO;
import dao.jdbc.JDBCEnderecoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cliente;
import model.Endereco;
import model.Fornecedor;

public class CadastroClienteController implements Initializable {
	
	JDBCClienteDAO clienteDAO = new JDBCClienteDAO();
	JDBCEnderecoDAO enderecoDAO = new JDBCEnderecoDAO();

    @FXML
    private TextField txtId;

    @FXML
    private ListView<Endereco> listEndereco;

    @FXML
    private TextField txtRuaAv;

    @FXML
    private Button btPesquisar;

    @FXML
    private TextField txtRazaoSocial;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtCep;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtBairro;

    @FXML
    private Button btAdicionaEndereco;
    
    @FXML
    private ContextMenu opcaoListEndereco;
    
    private List<Endereco> enderecosDaLista = new ArrayList<Endereco>();
    
    private Cliente clienteSelecionado;

    @FXML
    void salvar(ActionEvent event) throws Exception {
    	if (txtId.getText().isEmpty()) {
			Cliente cliente = new Cliente();
			cliente = montaCliente();
			if(!listEndereco.getItems().isEmpty())
			listEndereco.getItems().forEach(action-> enderecoDAO.inserir(action));
			
			clienteDAO.inserir(cliente);
			clienteSelecionado = cliente;
			new AlertaApp().start(new Stage(), "Salvo com Sucesso!");
			txtId.setText(Integer.toString(cliente.getId()));

		} else {
			clienteSelecionado = montaCliente();
			clienteDAO.editar(clienteSelecionado);
			new AlertaApp().start(new Stage(), "Alterado com Sucesso!");
		}
    }
    
    public Cliente montaCliente() {
    	Cliente cliente = new Cliente();
		if (!txtId.getText().isEmpty())
			cliente.setId(Integer.parseInt(txtId.getText()));

		if (!txtCnpj.getText().isEmpty())
			cliente.setCnpj(Long.parseLong(txtCnpj.getText()));

		if (!txtRazaoSocial.getText().isEmpty())
			cliente.setRazaoSocial(txtRazaoSocial.getText());

		if (!txtTelefone.getText().isEmpty())
			cliente.setTelefone(Long.parseLong(txtTelefone.getText()));

		if (!txtEmail.getText().isEmpty())
			cliente.setEmail(txtEmail.getText());
		
		if(listEndereco.getItems()!=null)
		cliente.setEnderecos(listEndereco.getItems());
		
		return cliente;
	}

    @FXML
    void pesquisar(ActionEvent event) throws Exception {
    	Stage stageTelaPesquisa = new Stage();
		stageTelaPesquisa.initModality(Modality.APPLICATION_MODAL);
		new TelaPesquisaClienteApp().start(stageTelaPesquisa);
		if (TelaPesquisaClienteController.getCliente() != null){
			posicionaCliente(TelaPesquisaClienteController.getCliente());
			clienteSelecionado = TelaPesquisaClienteController.getCliente();
			
		}
    }
    
    private void posicionaCliente(Cliente cliente) {
    	
		limpaCampos();
		
		if(cliente.getCnpj()!=null)
		txtCnpj.setText(Long.toString(cliente.getCnpj()));
		
		if(cliente.getRazaoSocial()!=null&&!cliente.getRazaoSocial().isEmpty())
		txtRazaoSocial.setText(cliente.getRazaoSocial());
		
		txtId.setText(Integer.toString(cliente.getId()));
		
		if(cliente.getEmail()!=null&&!cliente.getEmail().isEmpty())
		txtEmail.setText(cliente.getEmail());
		
		if(cliente.getTelefone()!=null)
		txtTelefone.setText(Long.toString(cliente.getTelefone()));
		
		if(!cliente.getEnderecos().isEmpty()){
		listEndereco.getItems().setAll(cliente.getEnderecos());
		}
	}
    
	private void limpaCampos(){
		txtId.setText("");
		txtCnpj.setText("");
		txtRazaoSocial.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		
		//Endereço
		limpaCamposEndereco();
		
		if(!listEndereco.getItems().isEmpty())
		listEndereco.getItems().clear();
		
		if(enderecosDaLista!=null)
		enderecosDaLista.clear();
	}

    @FXML
    void novo(ActionEvent event) {
    	limpaCampos();
    }
    
    private void limpaCamposEndereco(){
		txtNumero.setText("");
		txtBairro.setText("");
		txtRuaAv.setText("");
		txtCep.setText("");
    }
    
    @FXML
    void excluir(ActionEvent event) throws Exception {
    	if(!txtId.getText().isEmpty()){
			clienteDAO.remover(Integer.parseInt(txtId.getText()));
			new AlertaApp().start(new Stage(), "Excluído com Sucesso!");
			TelaPesquisaClienteController.setCliente(null);
			limpaCampos();
		}else{
			new AlertaApp().start(new Stage(), "Selecione um Cliente para excluir.");
		}
    }
    
    @FXML
    void adicionarEndereco(ActionEvent event) throws NumberFormatException  {
    	Endereco endereco = new Endereco();
    	endereco.setRua(txtRuaAv.getText());
    	endereco.setNumeroEstabeleciemnto(Integer.parseInt(txtNumero.getText()));
    	endereco.setBairro(txtBairro.getText());
    	endereco.setCep(Long.parseLong(txtCep.getText()));
    	enderecosDaLista.add(endereco);
    	listEndereco.getItems().add(endereco);
    	limpaCamposEndereco();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listEndereco.setOnMouseReleased(value-> {
			if(value.isSecondaryButtonDown()){
		
			}
		});
		
	}



}
