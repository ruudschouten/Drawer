package drawing.domain;

public interface IPaintable {
    void paint(Oval oval);
    void paint(Polygon polygon);
    void paint(PaintedText text);
    void paint(Image image);
}
