package drawing.domain;

import java.awt.*;
import java.io.File;

public class Image extends DrawingItem {
    private File file;
    private Point anchor;
    private double width;
    private double height;

    public Image(File file, Point anchor, double width, double height) {
        this.file = file;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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

    @Override
    public String toString() {
        if (file != null)
            return String.format("Image x:%d y:%d h:%s w:%s src=%s", getAnchor().x, getAnchor().y, getHeight(), getWidth(), file.getPath());
        return String.format("Image x:%d y:%d h:%s w:%s src=null", getAnchor().x, getAnchor().y, getHeight(), getWidth());
    }
}
