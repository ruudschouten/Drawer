package drawing.domain;

import javafx.scene.paint.Color;

import java.awt.*;

public abstract class DrawingItem {
    private DrawingItem previousState;
    Color color;

    DrawingItem() {
        previousState = null;
    }

    DrawingItem(Color color) {
        this.color = color;
        previousState = null;
    }

    public abstract Point getAnchor();

    public abstract double getWidth();

    public abstract double getHeight();

    public DrawingItem getPreviousState() {
        return previousState;
    }
}

