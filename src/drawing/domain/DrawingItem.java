package drawing.domain;

import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.Serializable;

public abstract class DrawingItem implements Serializable {
    private DrawingItem previousState;
    public ColorTransfer color;
    public Rectangle boundingBox;
    public boolean overlaps(DrawingItem item) { return this.insideBoundingBox(item.getAnchor()); }
    public abstract boolean insideBoundingBox(Point point);

    DrawingItem() {
        previousState = null;
    }

    DrawingItem(ColorTransfer color) {
        this.color = color;
        previousState = null;
    }

    public abstract Point getAnchor();

    public abstract double getWidth();

    public abstract double getHeight();

    public DrawingItem getPreviousState() {
        return previousState;
    }

    public abstract void paintUsing(IPaintable paintable);
}

