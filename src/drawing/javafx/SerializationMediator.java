package drawing.javafx;

import drawing.domain.Drawing;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class SerializationMediator implements IPersistanceMediator {
    private Properties props;

    @Override
    public Drawing load(String drawingName) {
        return null;
        //TODO: Finish this
    }

    @Override
    public boolean save(Drawing drawing) {
        try {
            FileOutputStream fileOut = new FileOutputStream("drawing.draw");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(drawing);
            out.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean init(Properties props) {
        this.props = props;
        //TODO: Finish this
        return true;
    }
}
