package drawing.domain;

import java.awt.*;

public class PaintedText extends DrawingItem {
    private String content;
    private String fontName;
    private Point anchor;
    private double width;
    private double height;

    public PaintedText(String content, String fontName, Point anchor, double width, double height, ColorTransfer color) {
        super(color);
        this.content = content;
        this.fontName = fontName;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
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
    public void paintUsing(IPaintable paintable) {
        paintable.paint(this);
    }

    @Override
    public String toString() {
        return String.format("Painted %s x:%d y:%d h:%s w:%s color:%s font:%s", content, getAnchor().x, getAnchor().y, getHeight(), getWidth(), color, getFontName());
    }
}
