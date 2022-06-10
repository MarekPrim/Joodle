package views;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Etudiant;
import modele.LectureProfilException;
import utils.Utils;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    private static PagesDisponibles pageActuelle;

    @Override
    public void start(Stage stage) throws IOException, LectureProfilException {
    	if(Etudiant.estConnecte()) {
    		System.out.println("Connecté");
            setPageActuelle(PagesDisponibles.ACCUEIL);
    		scene = new Scene(loadFXML("view_Accueil"), 1200, 800);
    	} else {
            setPageActuelle(PagesDisponibles.PROFIL_ETUDIANT);
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
    
    public static FXMLLoader getFXMLLoader(String fxml) {
    	return new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    }
    
    public static Scene getRoot() {
    	return scene;
    }

    public static void main(String[] args){
    	try {
			Utils.chargerClasse();
			Utils.chargerSalles();
			launch();
		} catch (NumberFormatException | IOException e) {
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