package GUI;

import drawing.domain.*;
import drawing.domain.Image;
import drawing.domain.Polygon;
import drawing.javafx.DatabaseMediator;
import drawing.javafx.DrawingTool;
import drawing.javafx.JavaFXPaintable;
import drawing.javafx.SerializationMediator;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;
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
    @FXML
    private ComboBox cbItems;

    private Drawing drawing;
    private String item = "Oval";
    private String mode = "Create";
    private JavaFXPaintable paintable;
    private Color javaFxColor = Color.RED;
    private SerializationMediator serial;
    private DatabaseMediator database;

    @FXML
    public void initialize() {
        paintable = new JavaFXPaintable(canvas.getGraphicsContext2D());
////        Serial
//        serial = new SerializationMediator();
//        drawing = serial.load("untitled.draw");
////        Database
//        database = new DatabaseMediator();
//        try {
//            Properties props = new Properties();
//            props.load(new FileInputStream("db.properties"));
//            database.init(props);
//            //drawing = database.load("untitled");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (drawing == null) {
            drawing = new Drawing("untitled", new ArrayList<>());
        } else {
            drawing.paintUsing(paintable);
        }
        ArrayList newItems = new ArrayList<DrawingItem>();
        Oval oval = new Oval(new Point(190, 265), 50, 50, 1, new ColorTransfer(0.65, 0.80, 0.05, 1));
        Oval oval2 = new Oval(new Point(290, 187), 40, 40, 1, new ColorTransfer(0.465, 0.280, 0.95, 1));
        Oval oval3 = new Oval(new Point(50, 90), 30, 30, 1, new ColorTransfer(0.265, 0.80, 0.05, 1));
        newItems.add(oval);
        newItems.add(oval2);
        newItems.add(oval3);
        Drawing newDrawing = new Drawing("newDrawing", newItems);
        drawing.addItem(newDrawing);
        drawing.paintUsing(paintable);

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

        cpColor.valueProperty().addListener((observable, oldValue, newValue) -> javaFxColor = cpColor.getValue());

        cbMode.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mode = newValue.toString());

        cbItems.setItems(drawing.itemsToObserve());
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
                    Oval oval = new Oval(pos, 20 + rand.nextInt(50), 20 + rand.nextInt(50), 1, new ColorTransfer(javaFxColor));
                    drawing.addItem(oval);
                    oval.paintUsing(paintable);
                    break;
                case "Polygon":
                    Point[] vertices = new Point[3];
                    vertices[0] = new Point((int) (pos.getX() + rand.nextInt(20)), (int) (pos.getY() + rand.nextInt(50)));
                    vertices[1] = new Point((int) (pos.getX() + rand.nextInt(30)), (int) (pos.getY() + rand.nextInt(70)));
                    vertices[2] = new Point((int) (pos.getX() + rand.nextInt(40)), (int) (pos.getY() + rand.nextInt(60)));
                    Polygon poly = new Polygon(vertices, 1, new ColorTransfer(javaFxColor));
                    drawing.addItem(poly);
                    poly.paintUsing(paintable);
                    break;
                case "Image":
                    File file = new File("minion.jpg");
                    Image img = new Image(file, new Point((int) pos.getX(), (int) pos.getY()), 100, 100);
                    drawing.addItem(img);
                    img.paintUsing(paintable);
                    break;
                case "Text":
                    PaintedText text = new PaintedText("Content", "Arial", pos, new ColorTransfer(javaFxColor));
                    drawing.addItem(text);
                    text.paintUsing(paintable);
                    break;
            }
//            if (!drawing.getItems().isEmpty()) {
//                serial.save(drawing);
//                database.save(drawing);
//            }
        }
    }
}
