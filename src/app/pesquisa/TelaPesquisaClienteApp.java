package app.pesquisa;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaPesquisaClienteApp extends Application {
	
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/pesquisa/TelaPesquisaClienteView.fxml"));
		Scene scene = new Scene(anchorPane);
		stage.setScene(scene);
		stage.setTitle("Pesquisar Cliente");
		stage.showAndWait();
		
	}
	
	public static void main(String[]args){
		launch(args);
	}
	
	public static Stage getStage(){
		return stage;
	}

}
