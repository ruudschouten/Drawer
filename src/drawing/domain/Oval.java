package drawing.domain;

import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Oval extends DrawingItem {
    private Point anchor;
    private double width;
    private double height;
    private double weight;

    public Oval(Point anchor, double width, double height, double weight, ColorTransfer color) {
        super(color);
        this.anchor = anchor;
        this.width = width;
        this.height = height;
        this.weight = weight;
        boundingBox = new Rectangle(getAnchor().x, getAnchor().y, getWidth(), getHeight());
    }

    @Override
    public boolean insideBoundingBox(Point point) {
        return this.boundingBox.contains(point.getX(), point.getY());
    }

    @Override
    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void paintUsing(IPaintable paintable) {
        paintable.paint(this);
    }

    @Override
    public String toString() {
        return String.format("Oval x:%d y:%d h:%s w:%s color:%s", getAnchor().x, getAnchor().y, getHeight(), getWeight(), color);
    }
}
