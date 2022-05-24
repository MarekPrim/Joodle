package com.joodle.javafx_edt;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private void switchToEDT(ActionEvent e) throws IOException {
        App.setRoot("View_EDT");
    }

    @FXML
    private void switchToCours(ActionEvent e) throws IOException {
        App.setRoot("View_Cours");
    }

    @FXML
    private void switchToNotes(ActionEvent e) throws IOException {
        App.setRoot("View_Notes");
    }

    @FXML
    private void switchToTaches(ActionEvent e) throws IOException {
        App.setRoot("View_Taches");
    }
}
