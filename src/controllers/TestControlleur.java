package controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.scene.control.ListView;

public class TestControlleur {

    @FXML
    private Text V1;
    
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
    	System.out.println(V1.getText());
    	V1.setText(Integer.parseInt(V1.getText())+1+"");
    	liste_test.getItems().add(new Text("Test"+V1.getText()));
    }

}