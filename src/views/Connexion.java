package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Connexion {

	public static Stage connexionStage(Stage stage) {
		Button button = new Button();
		button.setText("Enregistrer");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Connexion.connexionStage(stage).show();
			}
		});

		TextField labelNom = new TextField("nom");
		TextField labelPrenom = new TextField("prenom");
		TextField labelClasse = new TextField("classe");
		TextField labelLogin = new TextField("login");

		FlowPane secondaryLayout = new FlowPane();
		secondaryLayout.getChildren().addAll(labelNom, labelPrenom, labelClasse,
				labelLogin, button);

		Scene connexionScene = new Scene(secondaryLayout, 230, 100);

		// New window (Stage)
		Stage newWindow = new Stage();
		newWindow.setTitle("Connexion");
		newWindow.setScene(connexionScene);

		// Set position of second window, related to primary window.
		newWindow.setX(stage.getX() + 200);
		newWindow.setY(stage.getY() + 100);
		return newWindow;

	}

}
