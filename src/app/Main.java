package app;

import dao.jdbc.HibernateStarter;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HibernateStarter.getSessionFactory();
		new LoginApp().start(primaryStage);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
