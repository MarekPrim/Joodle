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
import modele.LectureTachesException;
import modele.Taches;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;

public class ControllerTaches implements Initializable,Observer{

    @FXML
    private ListView<Text> a_faire;

    @FXML
    private Button ajouter_taches;

    @FXML
    private ListView<Text> fini;

    @FXML
    private TextField tache;
    
    @FXML
    private Button down;
    
    @FXML
    private Button up;
    
    Taches taches;
    
    @FXML
    private Button save;
    
    @FXML
    void ajouter_taches(MouseEvent event) {
    	Text t = new Text(tache.getText());
    	this.taches.ajouter(t.getText());
    	tache.clear();
    }
    
    @FXML
    void entree(KeyEvent event) {
    	if(event.getCode().equals(KeyCode.ENTER)) {
    		Text t = new Text(tache.getText());
        	this.taches.ajouter(t.getText());
        	tache.clear();
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			taches = new Taches();
			for(String s : taches.getToDo()) {
				this.a_faire.getItems().add(new Text(s));
			}
			for(String s : taches.getDone()) {
				this.fini.getItems().add(new Text(s));
			}
		} catch (LectureTachesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		taches.addObserver(this);
	}
	
	@FXML
    void finir(MouseEvent event) {
		if(event.getClickCount()==2) {
			Text clicked = a_faire.getSelectionModel().getSelectedItem();
			this.taches.finir(clicked.getText());
		}
		
    }
	
	@FXML
	void reprendre(MouseEvent event) {
		if(event.getClickCount()==2) {
			Text clicked = fini.getSelectionModel().getSelectedItem();
			this.taches.reprendre(clicked.getText());
		}
		
	}
	
    @FXML
    void reorder(MouseEvent event) {
    	String idSource = event.getPickResult().getIntersectedNode().getId();
		
		if(idSource == null) {
			return;
		}
		Text clicked = a_faire.getSelectionModel().getSelectedItem();
		if(idSource.equals("up")) {
			this.taches.reorder(clicked.getText(),true);
		} else {
			this.taches.reorder(clicked.getText(),false);
		}
    }

	@Override
	public void update(Observable o, Object arg) {
		Boolean bothListChanged = (Boolean) arg;
		Taches tasks = (Taches) o;
		this.a_faire.getItems().clear();
		if(bothListChanged) {
			this.fini.getItems().clear();
			for(String s : tasks.getToDo()) {
				this.a_faire.getItems().add(new Text(s));
			}
			for(String s : tasks.getDone()) {
				this.fini.getItems().add(new Text(s));
			}
		} else {		
			for(String s : tasks.getToDo()) {
				this.a_faire.getItems().add(new Text(s));
			}
		}
		
	}
	
    @FXML
    void sauvegarder(MouseEvent event) {

    }

}
