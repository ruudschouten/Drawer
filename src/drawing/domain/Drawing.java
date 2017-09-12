package drawing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Drawing implements Comparator<DrawingItem>, Serializable {
    private String name;
    private ArrayList<DrawingItem> items;

    public Drawing(String name, ArrayList<DrawingItem> items) {
        this.name = name;
        this.items = items;
    }

    public ArrayList<DrawingItem> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void paintUsing(IPaintable paintable) throws ClassCastException {
        for (DrawingItem d : items) {
            if (d.getClass() == Oval.class) paintable.paint((Oval) d);
            else if (d.getClass() == Polygon.class) paintable.paint((Polygon) d);
            else if (d.getClass() == PaintedText.class) paintable.paint((PaintedText) d);
            else if (d.getClass() == Image.class) paintable.paint((Image) d);
        }
    }

    @Override
    public int compare(DrawingItem o1, DrawingItem o2) {
        return Integer.compare((int) ((int) o1.getAnchor().getX() + o1.getAnchor().getY()), (int) ((int) o2.getAnchor().getX() + o2.getAnchor().getY()));
    }
}
