package controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;

public class TestControlleur {

    @FXML
    private Text V1;

    @FXML
    private WebView Browser;
    
    @FXML
    private Text V2;

    @FXML
    private Text edt_text;

    @FXML
    void Print(MouseEvent event) {

    }

    @FXML
    void incremente(MouseEvent event) {
    	System.out.println(V1.getText());
    	V1.setText(Integer.parseInt(V1.getText())+1+"");
    	Browser.getEngine().load("https://mdw.inp-toulouse.fr/mdw3/#!notesView");
    }

}