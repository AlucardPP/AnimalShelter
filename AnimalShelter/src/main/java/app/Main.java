package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// po ki chuj tu castujesz ?
		Parent parent=(Parent)FXMLLoader.load(getClass().getResource("/view/MainPane.fxml"));
		Scene scene=new Scene(parent);
		scene.getStylesheets().add(getClass().getResource("/css/text-field-red-border.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static void main(String[] args){
		launch(args);
	}

}
