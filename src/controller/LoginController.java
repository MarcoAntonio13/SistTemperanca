package controller;

import javax.swing.JOptionPane;

import app.LoginApp;
import app.MenuInicialApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField txtSenha;

	@FXML
	private Label labelLogin;

	@FXML
	private Button btnSair;

	@FXML
	private Button btnEntrar;

	@FXML
	void entrar(ActionEvent event) throws Exception {
		logar();
	}
	
	public void logar() throws Exception{
		if (txtLogin.getText().equals("admin") && txtSenha.getText().equals("admin")) {
			new MenuInicialApp().start(new Stage());
			LoginApp.getStage().close();
		} else {
			JOptionPane.showMessageDialog(null, "Senha ou Usuário Incorreto");
		}
	}

	@FXML
	void sair(ActionEvent event) {
		LoginApp.getStage().close();

	}
	

    @FXML
    void entrarEnter(KeyEvent event) throws Exception {
    	if(event.getCode() == KeyCode.ENTER){
    		logar();
    	}
    }
	
	

}
