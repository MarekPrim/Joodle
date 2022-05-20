package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloFX extends Application {

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
