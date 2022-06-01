package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import modele.Semaine;

public class ControllerEDT implements Initializable{
	
	private Semaine semaineSelectionne = new Semaine();
	
    @FXML private ListView<Text> liste_vendredi;
    
    @FXML
    private Button next_edt;

    @FXML
    private Button previous_edt;
    
    @FXML
    private Button S1;

    @FXML
    private Button S2;

    @FXML
    private Button S3;

    @FXML
    private Button S4;

    @FXML
    private Button S5;
    
    

	
	@FXML
    void changeWeek(MouseEvent event) {
		String idSource = event.getPickResult().getIntersectedNode().getId();
		if(idSource.equals("previous_edt")) {
			//semaine.decrease
		} else {
			//semaine.increase
		}
		//Maj weeks graphique
    }
    
 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("tt");
	}

}
