package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.AlertaApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AlertaController implements Initializable {
	


    @FXML
    private Button btOk;

    @FXML
    private Label lbMensagem;

    @FXML
    void fechar(ActionEvent event) {
    	AlertaApp.getStage().close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbMensagem.setText(AlertaApp.getMensagem());
	}



	
	

}
