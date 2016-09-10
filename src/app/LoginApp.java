package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {

	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));
		Scene scene = new Scene(anchorPane);
		stage.setScene(scene);
		stage.setTitle("SisTemperança - Login");
		stage.show();
		LoginApp.stage = stage;

	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}

}
