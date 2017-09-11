package GUI;

import drawing.domain.*;
import drawing.domain.Image;
import drawing.domain.Polygon;
import drawing.javafx.DrawingTool;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Controller {
    @FXML
    private Label lbImagePath;
    @FXML
    private ComboBox cbDrawing;
    @FXML
    private Label lbColor;
    @FXML
    private ColorPicker cpColor;
    @FXML
    private ChoiceBox cbMode;
    @FXML
    private Label lbBrowse;
    @FXML
    private Button btnBrowse;
    @FXML
    private Canvas canvas;

    private Drawing drawing;
    private String item = "Oval";
    private String mode = "Create";
    private Color color = Color.RED;

    @FXML
    public void initialize() {
        drawing = new Drawing("unnammed", new ArrayList<>());
        cbDrawing.valueProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            item = cbDrawing.getValue().toString();

            switch (item) {
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

    public void paintPaintable(MouseEvent mouseEvent) {
        Random rand = new Random();
        if (Objects.equals(mode, "Create")) {
            Point pos = new Point((int) mouseEvent.getX(), (int) mouseEvent.getY());
            switch (this.item) {
                case "Oval":
                    Oval oval = new Oval(pos, 20+ rand.nextInt(50), 20 + rand.nextInt(50), 1, color);
                    drawing.getItems().add(oval);
                    break;
                case "Polygon":
                    Point[] vertices = new Point[3];
                    vertices[0] = new Point((int) (pos.getX() + rand.nextInt(20)), (int) (pos.getY() + rand.nextInt(50)));
                    vertices[1] = new Point((int) (pos.getX() + rand.nextInt(30)), (int) (pos.getY() + rand.nextInt(70)));
                    vertices[2] = new Point((int) (pos.getX() + rand.nextInt(40)), (int) (pos.getY() + rand.nextInt(60)));
                    Polygon poly = new Polygon(vertices, 1, color);
                    drawing.getItems().add(poly);
                    break;
                case "Image":
                    File file = new File("D:\\Programming\\Java\\Drawer\\src\\drawing\\minion.jpg");
                    Image img = new Image(file, new Point((int) pos.getX(), (int) pos.getY()), 100,100);
                    drawing.getItems().add(img);
                    break;
                case "Text":
                    PaintedText text = new PaintedText("Content", "Arial", pos, 50, 50, color);
                    drawing.getItems().add(text);
                    break;
            }

            DrawingTool drawingTool = new DrawingTool(canvas.getGraphicsContext2D(), drawing);
            drawingTool.draw();
        }
    }
}
