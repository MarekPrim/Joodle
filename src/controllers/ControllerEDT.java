package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ControllerEDT implements Initializable{
	
	
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
			S1.setText((Integer.parseInt(S1.getText())-1)+"");
			S2.setText((Integer.parseInt(S2.getText())-1)+"");
			S3.setText((Integer.parseInt(S3.getText())-1)+"");
			S4.setText((Integer.parseInt(S4.getText())-1)+"");
			S5.setText((Integer.parseInt(S5.getText())-1)+"");
		} else {
			S1.setText((Integer.parseInt(S1.getText())+1)+"");
			S2.setText((Integer.parseInt(S2.getText())+1)+"");
			S3.setText((Integer.parseInt(S3.getText())+1)+"");
			S4.setText((Integer.parseInt(S4.getText())+1)+"");
			S5.setText((Integer.parseInt(S5.getText())+1)+"");
		}
    }
    
 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("tt");
	}
}
