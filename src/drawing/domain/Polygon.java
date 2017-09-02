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
        return vertices[0];
    }

    @Override
    public double getWidth() {
        double widest = 0;
        for (Point v : vertices) {
            if(Math.abs(v.y) > widest) widest = Math.abs(v.y);
        }
        return widest;
    }

    @Override
    public double getHeight() {
        double highest = 0;
        for (Point v : vertices) {
            if(Math.abs(v.x) > highest) highest = Math.abs(v.x);
        }
        return highest;
    }

    @Override
    public String toString() {
        return String.format("Polygon x:%d y:%d h:%s w:%s color:%s", getAnchor().x, getAnchor().y, getHeight(), getWidth(), color) ;
    }
}
