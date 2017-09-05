package drawing.javafx;

import drawing.domain.Drawing;
import drawing.javafx.JavaFXPaintable;
import javafx.embed.swt.FXCanvas;

public class DrawingTool {
    private Drawing drawing;
    private JavaFXPaintable paintable;

    public DrawingTool (FXCanvas canvas, Drawing drawing) {
        this.drawing = drawing;
        paintable = new JavaFXPaintable(canvas);
    }

    public void draw() {

    }
}
