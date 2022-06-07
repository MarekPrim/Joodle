package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class ControllerResultats implements Initializable{

    @FXML
    private WebView web_resultats;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		web_resultats.getEngine().load("https://mdw.inp-toulouse.fr/mdw3/#!notesView");
	}

}
