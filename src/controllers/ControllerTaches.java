package controllers;


import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import modele.Taches;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerTaches implements Initializable,Observer{

    @FXML
    private ListView<Text> a_faire;

    @FXML
    private Button ajouter_taches;

    @FXML
    private ListView<Text> fini;

    @FXML
    private TextField tache;
    
    Taches taches;

    @FXML
    void ajouter_taches(MouseEvent event) {
    	Text t = new Text(tache.getText());
    	this.taches.ajouter(t.getText());
    	tache.clear();
    }
    
    @FXML
    void entree(KeyEvent event) {
    	System.out.println(event);
    	if(event.getCode().equals(KeyCode.ENTER)) {
    		Text t = new Text(tache.getText());
        	this.taches.ajouter(t.getText());
        	tache.clear();
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		taches = new Taches();
		taches.addObserver(this);
	}
	
	@FXML
    void finir(MouseEvent event) {
		Text clicked = a_faire.getSelectionModel().getSelectedItem();
		this.taches.finir(clicked.getText());
    }
	
	@FXML
	void reprendre(MouseEvent event) {
		Text clicked = fini.getSelectionModel().getSelectedItem();
		this.taches.reprendre(clicked.getText());
	}

	@Override
	public void update(Observable o, Object arg) {
		this.a_faire.getItems().clear();
		this.fini.getItems().clear();
		Taches tasks = (Taches) o;
		for(String s : tasks.getToDo()) {
			this.a_faire.getItems().add(new Text(s));
		}
		for(String s : tasks.getDone()) {
			this.fini.getItems().add(new Text(s));
		}
	}

}
