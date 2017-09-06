package drawing.javafx;

import drawing.domain.*;
import drawing.domain.Image;
import drawing.domain.Polygon;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class JavaFXPaintable implements IPaintable {

    private GraphicsContext gc;

    JavaFXPaintable(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void paint(Oval oval) {
        gc.setFill(oval.color);
        gc.fillOval(oval.getAnchor().getX(), oval.getAnchor().getY(), oval.getWidth(), oval.getHeight());
    }

    @Override
    public void paint(Polygon polygon) {
        gc.setFill(polygon.color);
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
        gc.setFill(text.color);
        gc.fillText(text.getContent(), text.getAnchor().getX(), text.getAnchor().getY(), text.getWidth());
    }

    @Override
    public void paint(Image image) {
        //TODO: Do this
    }
}
