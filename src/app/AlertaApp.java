package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class AlertaApp extends Application {
	
	private static Stage stage;
	private static String mensagem;
	
	public void start(Stage primaryStage, String mensagem) throws Exception {
		stage = primaryStage;
		AlertaApp.mensagem = mensagem;
		//AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
		AnchorPane loader = FXMLLoader.load(getClass().getResource("/view/AlertaView.fxml"));
		
		Scene scene = new Scene(loader);
		stage.setScene(scene);
		stage.setTitle("Alerta");

		stage.showAndWait();
		
	}
	
	public static void main(String[]args){
		launch(args);
	}
	
	public static Stage getStage(){
		return AlertaApp.stage;
	}
	
	public static String getMensagem(){
		return AlertaApp.mensagem;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
