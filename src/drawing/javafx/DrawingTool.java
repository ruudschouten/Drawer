package drawing.javafx;

import drawing.domain.Drawing;
import drawing.javafx.JavaFXPaintable;
import javafx.scene.canvas.GraphicsContext;

public class DrawingTool {
    private Drawing drawing;
    private JavaFXPaintable paintable;

    public DrawingTool (GraphicsContext gc, Drawing drawing) {
        this.drawing = drawing;
        paintable = new JavaFXPaintable(gc);
    }

    public void draw() {
        drawing.paintUsing(paintable);
    }
}
