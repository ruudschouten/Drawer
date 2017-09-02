package Console;

import drawing.domain.*;
import drawing.domain.Image;
import drawing.domain.Polygon;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main (String[] arguments) {
        testToString();
    }

    private static void testToString() {
        Polygon polygon = new Polygon(new Point[0], 5, Color.PURPLE);
        Oval oval = new Oval(new Point(10,20), 20,30, 2, Color.ALICEBLUE);
        Image img = new Image(null, new Point(0,10), 20,20);
        PaintedText text = new PaintedText("Text", "Consolas", new Point(30,10), 40, 10, Color.CORAL);
        ArrayList<DrawingItem> items = new ArrayList<>();
        items.add(img);
        items.add(oval);
        items.add(text);
        items.add(polygon);

        Drawing d = new Drawing("Nice drawing", items);

        d.getItems().sort(d);

        for (DrawingItem di : d.getItems()) {
            System.out.println(di.toString());
        }
    }
}
