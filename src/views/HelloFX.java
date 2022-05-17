package views;

import java.lang.ModuleLayer.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

	private static final int Infinity = 0;

	@Override
    public void start(Stage stage) throws Exception {
		Pane titledPane0 = new AppContainerView();
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
