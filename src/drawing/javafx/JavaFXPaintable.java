package drawing.javafx;

import drawing.domain.*;
import drawing.domain.Image;
import drawing.domain.Polygon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class JavaFXPaintable implements IPaintable {

    private GraphicsContext gc;

    public JavaFXPaintable(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void paint(Oval oval) {
        paintBoundingBox(oval);
        gc.setFill(oval.color.getColor());
        gc.fillOval(oval.getAnchor().getX(), oval.getAnchor().getY(), oval.getWidth(), oval.getHeight());
    }

    @Override
    public void paint(Polygon polygon) {
        paintBoundingBox(polygon);
        gc.setFill(polygon.color.getColor());
        double[] vertical = new double[polygon.getVertices().length];
        double[] horizontal = new double[polygon.getVertices().length];
        for (int i = 0; i < polygon.getVertices().length; i++) {
            Point p = polygon.getVertices()[i];
            vertical[i] = p.getX();
            horizontal[i] = p.getY();
        }
        gc.fillPolygon(vertical, horizontal, polygon.getVertices().length);
    }

    @Override
    public void paint(PaintedText text) {
        paintBoundingBox(text);
        gc.setFill(text.color.getColor());
        gc.fillText(text.getContent(), text.getAnchor().getX(), text.getAnchor().getY() + text.getHeight(), text.getWidth());
    }

    @Override
    public void paint(Image image) {
        try {
            paintBoundingBox(image);
            InputStream input = new FileInputStream(image.getFile());
            javafx.scene.image.Image img = new javafx.scene.image.Image(input);
            gc.drawImage(img, image.getAnchor().getX(), image.getAnchor().getY());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void paintBoundingBox(DrawingItem d) {
        gc.setFill(Color.BLACK);
        gc.strokeRect(d.boundingBox.getX(), d.boundingBox.getY(), d.boundingBox.getWidth(), d.boundingBox.getHeight());
    }
}
