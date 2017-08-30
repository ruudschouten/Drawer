package drawing.domain;

import javafx.scene.paint.Color;

import java.awt.*;

public class Polygon extends DrawingItem {
    private Point[] vertices;
    private double weight;

    public Polygon(Point[] vertices, double weight, Color color) {
        super(color);
        this.vertices = vertices;
        this.weight = weight;
    }

    public Point[] getVertices() {
        return vertices;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Point getAnchor() {
        return null;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }
}
