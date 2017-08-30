package GUI;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    public Label lbImagePath;
    @FXML
    public ComboBox cbDrawing;
    @FXML
    public Label lbColor;
    @FXML
    public ColorPicker cpColor;
    @FXML
    public ChoiceBox cbMode;
    @FXML
    public Label lbBrowse;
    @FXML
    public Button btnBrowse;

    private String drawing = "Gallo";
    private String mode = "Create";
    private Color color;

    @FXML
    public void initialize() {
        cbDrawing.valueProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            drawing = cbDrawing.getValue().toString();

            switch (drawing) {
                case "Oval":
                case "Polygon":
                    changeImageControlVisibility(false);
                    changeColorControlVisibility(true);
                    break;
                case "Image":
                    changeImageControlVisibility(true);
                    changeColorControlVisibility(false);
                    break;
                case "Text":
                    changeImageControlVisibility(false);
                    changeColorControlVisibility(true);
                    break;
            }
        });

        cpColor.valueProperty().addListener((observable, oldValue, newValue) -> color = cpColor.getValue());

        cbMode.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mode = newValue.toString());
    }

    private void changeImageControlVisibility(boolean visible) {
        lbBrowse.setVisible(visible);
        btnBrowse.setVisible(visible);
        lbImagePath.setVisible(visible);
    }

    private void changeColorControlVisibility(boolean visible) {
        lbColor.setVisible(visible);
        cpColor.setVisible(visible);
    }
}
