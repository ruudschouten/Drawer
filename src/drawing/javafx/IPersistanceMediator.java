package drawing.javafx;

import drawing.domain.Drawing;

import java.util.Properties;

public interface IPersistanceMediator {
    Drawing load(String drawingName);
    boolean save(Drawing drawing);
    boolean init(Properties props);
}
