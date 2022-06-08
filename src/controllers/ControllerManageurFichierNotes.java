package controllers;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import modele.DossierNotes;
import modele.FichierNotes;

public class ControllerManageurFichierNotes implements Initializable{
	

    @FXML
    private ListView<Text> liste_fichiers;
    
	private DossierNotes dossier;
	
	@FXML
	private Button bouton_ajouter_fichier;
	
	@FXML
	private TitledPane panneauDossier;
	
	@FXML
	private void ajouterFichier(ActionEvent e) {
		this.bouton_ajouter_fichier.setVisible(true);
		System.out.println("Fichiers :");
		liste_fichiers.getItems().add(new Text("fff"));
	}
	
	public ControllerManageurFichierNotes(DossierNotes dossier) {
		this.dossier = dossier;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		panneauDossier.setText(dossier.getNomDossier());
		BorderPane p = new BorderPane();ListView<Text> t = new ListView<Text>();
		p.setCenter(t);
		
		panneauDossier.setGraphic(p);
		
		t.setOnMouseClicked(event -> System.out.println(event));
		System.out.println(liste_fichiers);
		for(FichierNotes f : this.dossier.getListeFichier()) {
			t.getItems().add(new Text(f.getNomFichier()));
		}
	}
	
    @FXML
    void select_notes(MouseEvent event) {
    	System.out.println(event.getSource());
    }

}
