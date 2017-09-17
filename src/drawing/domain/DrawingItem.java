package drawing.domain;

import java.awt.*;
import java.io.Serializable;

public abstract class DrawingItem implements Serializable {
    private DrawingItem previousState;
    public ColorTransfer color;

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

