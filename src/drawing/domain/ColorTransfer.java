package drawing.domain;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class ColorTransfer implements Serializable {
    private double r;
    private double g;
    private double b;

    public ColorTransfer(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public ColorTransfer(Color c) {
        r = c.getRed();
        g = c.getGreen();
        b = c.getBlue();
    }

    public Color getColor() {
        return new Color(r, g, b, 1);
    }

    public void setColor(Color c) {
        r = c.getRed();
        g = c.getGreen();
        b = c.getBlue();
    }
}
