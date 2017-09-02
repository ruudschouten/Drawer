package Console;

import drawing.domain.*;
import drawing.domain.Image;
import drawing.domain.Polygon;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] arguments) {
        testToString();
    }

    private static void testToString() {
        Point[] vertices = new Point[4];
        vertices[0] = new Point( 15,60);
        vertices[1] = new Point(60,15);
        vertices[2] = new Point(0,90);
        vertices[3] = new Point(105, 10);
        Image img = new Image(null, new Point(0, 10), 20, 20);
        Oval oval = new Oval(new Point(10, 20), 20, 30, 2, Color.ALICEBLUE);
        PaintedText text = new PaintedText("Text", "Consolas", new Point(30, 10), 40, 10, Color.CORAL);
        Polygon polygon = new Polygon(vertices, 5, Color.PURPLE);
        ArrayList<DrawingItem> items = new ArrayList<>();
        items.add(img);
        items.add(polygon);
        items.add(oval);
        items.add(text);

        Drawing d = new Drawing("Nice drawing", items);

        d.getItems().sort(d);

        for (DrawingItem di : d.getItems()) {
            System.out.println(di.toString());
        }
    }
}
