package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import utils.ICSTimeSlot;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;

public class TestControlleur implements Initializable{

    @FXML
    private Text V1;
    
    private int i = 0;
    private ArrayList<ICSTimeSlot> ics = new ArrayList<ICSTimeSlot>();
    
    @FXML
    private Text V2;

    @FXML
    private Text edt_text;
    
    @FXML
    private ListView<Text> liste_test;

    @FXML
    void Print(MouseEvent event) {

    }

    @FXML
    void incremente(MouseEvent event) {
    	String[] color = {"green","red","blue","black"};
    	System.out.println(V1.getText());
    	V1.setText(Integer.parseInt(V1.getText())+1+"");
    	Text te = new Text(this.ics.get(i).getCours());
    	Random r = new Random();
    	te.setStyle("-fx-text-fill: "+color[r.nextInt(3)]+"; -fx-font-size: 16px;");
    	liste_test.getItems().add(te);
    	if(this.i<3) {
    		this.i++;
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.ics.add(new ICSTimeSlot("Fri Mar 11 09:15:00 CET 2022","Fri Mar 11 09:15:00 CET 2022","Réseau","B00","Gentian"));
		this.ics.add(new ICSTimeSlot("Fri Mar 11 09:15:00 CET 2022","Fri Mar 11 09:15:00 CET 2022","Algorithmie","B00","Gentian"));
		this.ics.add(new ICSTimeSlot("Fri Mar 11 09:15:00 CET 2022","Fri Mar 11 09:15:00 CET 2022","Math","B00","Gentian"));
		this.ics.add(new ICSTimeSlot("Fri Mar 11 09:15:00 CET 2022","Fri Mar 11 09:15:00 CET 2022","Sport","B00","Gentian"));
	}

}