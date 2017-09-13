package drawing.domain;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class ColorTransfer implements Serializable {
    private double r;
    private double g;
    private double b;
    private double opacity;

    public ColorTransfer(double r, double g, double b, double opacity) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.opacity = opacity;
    }

    public ColorTransfer(Color c) {
        r = c.getRed();
        g = c.getGreen();
        b = c.getBlue();
        opacity = c.getOpacity();
    }

    public Color getColor() {
        return new Color(r, g, b, opacity);
    }

    public void setColor(Color c) {
        r = c.getRed();
        g = c.getGreen();
        b = c.getBlue();
        opacity = c.getOpacity();
    }
}
