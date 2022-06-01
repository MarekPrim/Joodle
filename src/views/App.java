package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    private static PagesDisponibles pageActuelle;

    @Override
    public void start(Stage stage) throws IOException {
    	setPageActuelle(PagesDisponibles.EDT);
        scene = new Scene(loadFXML("view_EDT"), 1200, 800);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static Scene getRoot() {
    	return scene;
    }

    public static void main(String[] args){
    	try {
			Utils.chargerClasse();
			launch();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

	public static PagesDisponibles getPageActuelle() {
		return pageActuelle;
	}

	public static void setPageActuelle(PagesDisponibles pageActuelle) {
		App.pageActuelle = pageActuelle;
	}

}