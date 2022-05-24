package views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Button button = new Button();
		button.setText("Enregistrer");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Connexion.connexionStage(stage).show();
			}
		});
		

		Pane titledPane0 = new AppContainerView();
		titledPane0.getChildren().add(button);
		GridPane select = new SelectionMenuView();

		titledPane0.getChildren().add(select);

		Scene scene = new Scene(titledPane0, 300, 275);
		stage.setTitle("Joodle");
		stage.setScene(scene);
		stage.setMaximized(true);

		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
