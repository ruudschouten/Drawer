package drawing.domain;

import java.util.ArrayList;
import java.util.Comparator;

public class Drawing implements Comparator<DrawingItem> {
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

    @Override
    public int compare(DrawingItem o1, DrawingItem o2) {
        return Integer.compare((int) ((int) o1.getAnchor().getX() + o1.getAnchor().getY()), (int) ((int) o2.getAnchor().getX() + o2.getAnchor().getY()));
    }
}
