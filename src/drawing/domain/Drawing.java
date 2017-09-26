package drawing.domain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Drawing extends DrawingItem implements Comparator<DrawingItem>, Serializable {
    private ObservableList<DrawingItem> observableList;
    private String name;
    private ArrayList<DrawingItem> items;

    public Drawing(String name, ArrayList<DrawingItem> items) {
        this.name = name;
        this.items = items;
        observableList = FXCollections.observableList(items);
        boundingBox = new Rectangle(getAnchor().x, getAnchor().y, getWidth(), getHeight());
    }

    public void addItem(DrawingItem item) {
        observableList.add(item);
    }

    public List<DrawingItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public ObservableList<DrawingItem> itemsToObserve() {
        return FXCollections.unmodifiableObservableList(observableList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void paintUsing(IPaintable paintable) {
        for (DrawingItem d : items) {
            d.paintUsing(paintable);
        }
    }

    @Override
    public int compare(DrawingItem o1, DrawingItem o2) {
        return Integer.compare((int) ((int) o1.getAnchor().getX() + o1.getAnchor().getY()), (int) ((int) o2.getAnchor().getX() + o2.getAnchor().getY()));
    }

    @Override
    public boolean insideBoundingBox(Point point) {
        return this.boundingBox.contains(point.getX(), point.getY());
    }

    @Override
    public Point getAnchor() {
        return new Point((int) getWidth(), (int) getHeight());
    }

    @Override
    public double getWidth() {
        double x = 0;
        for (DrawingItem d : observableList) {
            if (d.getAnchor().getX() + d.getWidth() > x) {
                x = d.getAnchor().getX() + d.getWidth();
            }
        }
        return x;
    }

    @Override
    public double getHeight() {
        double y = 0;
        for (DrawingItem d : observableList) {
            if (d.getAnchor().getY() + d.getHeight() > y) {
                y = d.getAnchor().getY() + d.getHeight();
            }
        }
        return y;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(String.format("Drawing: %s, h: %s, w: %s\n", name, getHeight(), getWidth()));
        for (DrawingItem d : observableList) {
            s.append(String.format("\t%s\n", d));
        }
        return s.toString();
    }
}
