package drawing.javafx;

import drawing.domain.Drawing;

import java.io.*;
import java.util.Properties;

public class SerializationMediator implements IPersistanceMediator {
    private Properties props;

    @Override
    public Drawing load(String drawingName) {
        try {
            Drawing d;
            FileInputStream fileIn = new FileInputStream(drawingName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            d = (Drawing) in.readObject();
            in.close();
            fileIn.close();
            return d;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Drawing drawing) {
        try {
            FileOutputStream fileOut = new FileOutputStream("drawing.draw");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(drawing);
            out.close();
            fileOut.close();
            return true;
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
