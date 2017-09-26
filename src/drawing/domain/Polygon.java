package drawing.domain;

import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Polygon extends DrawingItem {
    private Point[] vertices;
    private double weight;

    public Polygon(Point[] vertices, double weight, ColorTransfer color) {
        super(color);
        this.vertices = vertices;
        this.weight = weight;
        boundingBox = new Rectangle(getAnchor().x, getAnchor().y, getWidth(), getHeight());
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
    public boolean insideBoundingBox(Point point) {
        return this.boundingBox.contains(point.getX(), point.getY());
    }

    @Override
    public Point getAnchor() {
        return new Point((int) lowestX(), (int) lowestY());
    }

    @Override
    public double getWidth() {
        return (highestX() - lowestX());
    }

    @Override
    public double getHeight() {
        return (highestY() - lowestY());
    }

    private double lowestX() {
        double x = vertices[0].getX();
        for (Point p : vertices) {
            if (p.getX() < x) {
                x = p.getX();
            }
        }
        return x;
    }

    private double lowestY() {
        double y = vertices[0].getY();
        for (Point p : vertices) {
            if (p.getY() < y) {
                y = p.getY();
            }
        }
        return y;
    }

    private double highestX() {
        double x = vertices[0].getX();
        for (Point p : vertices) {
            if (p.getX() > x) {
                x = p.getX();
            }
        }
        return x;
    }

    private double highestY() {
        double y = vertices[0].getY();
        for (Point p : vertices) {
            if (p.getY() > y) {
                y = p.getY();
            }
        }
        return y;
    }

    @Override
    public void paintUsing(IPaintable paintable) {
        paintable.paint(this);
    }

    @Override
    public String toString() {
        return String.format("Polygon x:%d y:%d h:%s w:%s color:%s", getAnchor().x, getAnchor().y, getHeight(), getWidth(), color);
    }
}
