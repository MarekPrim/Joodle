package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import views.App;
import views.PagesDisponibles;
import javafx.scene.control.DialogPane;
import javafx.scene.text.Text;
import modele.Erreurs;

@SuppressWarnings("deprecation")
public class ControllerMenuNavigation implements Initializable,Observer{
	
	@FXML private Button boutonEDT;
	
	@FXML private Button boutonCours;
	
	@FXML private Button boutonNotes;
	
	@FXML private Button boutonResultats;
	
	@FXML private Button boutonTaches;
	
	@FXML private Button boutonMenuRu;
	
	@FXML private Button boutonSallesLibres;
	
    @FXML
    private DialogPane popup;
	
    private Erreurs error;
	
	
	@FXML
    private void switchToEDT(ActionEvent e) throws IOException {
		App.setPageActuelle(PagesDisponibles.EDT);
        App.setRoot("view_EDT");
    }

    @FXML
    private void switchToCours(ActionEvent e) throws IOException {
		App.setPageActuelle(PagesDisponibles.COURS);
        App.setRoot("view_Cours");
    }

    @FXML
    private void switchToNotes(ActionEvent e) throws IOException {
		App.setPageActuelle(PagesDisponibles.NOTES);
        App.setRoot("view_Notes");
    }

    @FXML
    private void switchToTaches(ActionEvent e) throws IOException {
		App.setPageActuelle(PagesDisponibles.TACHES);
        App.setRoot("view_Taches");
    }
    
    @FXML
    private void switchToSalleLibre(ActionEvent e) throws IOException {
		App.setPageActuelle(PagesDisponibles.SALLE_LIBRE);
    	App.setRoot("view_Salle_Libre");
    }
    
    @FXML
    private void switchToMenuRu(ActionEvent e) throws IOException {
    	App.setPageActuelle(PagesDisponibles.RESTAUU);
    	App.setRoot("view_RestauU");
    }
    
    @FXML
    private void switchToResultats(ActionEvent e) throws IOException {
		App.setPageActuelle(PagesDisponibles.RESULTATS);
        App.setRoot("view_Resultats");
    }
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Erreurs.getInstanceErreur().addObserver(this);
		switch (App.getPageActuelle()) {
			case COURS:
				boutonCours.setUnderline(true);
				break;
			case EDT:
				boutonEDT.setUnderline(true);
				break;
			case NOTES:
				boutonNotes.setUnderline(true);
				break;
			case RESULTATS:
				boutonNotes.setUnderline(true);
				break;
			case RESTAUU:
				boutonMenuRu.setUnderline(true);
				break;
			case SALLE_LIBRE:
				boutonSallesLibres.setUnderline(true);
				break;
			case TACHES:
				boutonTaches.setUnderline(true);
				break;
			default:
				break;
			}
	}

	@Override
	public void update(Observable o, Object arg) {
		String msg = (String) arg;
		popup.setDisable(false);
		popup.setContent(new Text(msg));
	}

}
