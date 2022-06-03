package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class ControllerCours implements Initializable{

    @FXML
    private WebView webMoodle;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		webMoodle.getEngine().load("https://moodle-n7.inp-toulouse.fr/");
	}

}
