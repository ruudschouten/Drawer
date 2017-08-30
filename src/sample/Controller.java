package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;

public class Controller {
    @FXML ComboBox cbDrawing;
    static String drawing = "Gallo";

    @FXML public void initialize() {
        cbDrawing.valueProperty().addListener((observable, oldValue, newValue) -> drawing = newValue.toString());
    }

    public void showMessage(MouseEvent mouseEvent) {
        JOptionPane.showMessageDialog(null, drawing, "Title", JOptionPane.INFORMATION_MESSAGE);
    }
}
