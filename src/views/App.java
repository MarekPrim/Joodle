package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Etudiant;
import modele.LectureProfilException;
import utils.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, LectureProfilException {
    	if(Etudiant.estConnecte()) {
    		scene = new Scene(loadFXML("view_EDT"), 1200, 800);
    	} else {
    		scene = new Scene(loadFXML("view_Profil_Etudiant"), 1200, 800);
    	}
        
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

    public static void main(String[] args){
    	try {
			Utils.chargerClasse();
			launch();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

}