package drawing.domain;

import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Comparator;

public abstract class DrawingItem implements Comparator<DrawingItem> {
    private DrawingItem previousState;
    private Color color;

    public DrawingItem() {
        previousState = null;
    }

    public DrawingItem(Color color) {
        this.color = color;
        previousState = null;
    }

    public abstract Point getAnchor();
    public abstract double getWidth();
    public abstract double getHeight();

    public DrawingItem getPreviousState() {
        return previousState;
    }

    @Override
    public int compare(DrawingItem o1, DrawingItem o2) {
        return Integer.compare((int) o1.getAnchor().getX(), (int) o2.getAnchor().getX());
    }
}
