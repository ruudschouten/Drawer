package drawing.javafx;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import drawing.domain.Drawing;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DatabaseMediator implements IPersistanceMediator {
    private Properties props;
    private Connection con;

    @Override
    public Drawing load(String drawingName) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT FROM drawer WHERE Name like ? LIMIT 1");
            statement.setString(1, drawingName);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                ByteArrayInputStream bais = new ByteArrayInputStream(rs.getBytes("Source"));
                ObjectInput input = new ObjectInputStream(bais);
                Drawing d = (Drawing) input.readObject();
                bais.close();
                input.close();
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            ByteOutputStream bos = new ByteOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(drawing);
            out.flush();
            byte[] bytes = bos.getBytes();
            String query = "insert into drawing (Name, Source) VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, drawing.getName());
            statement.setBytes(2, bytes);
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean init(Properties props) {
        this.props = props;
        try {
            initConnection();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void closeConnection() throws SQLException {
        con.close();
    }

    private void initConnection() throws SQLException {
        String dbUrl = props.getProperty("dbUrl");
        String dbTable = props.getProperty("dbTable");
        String dbReconnect = props.getProperty("reconnect");
        String dbSsl = props.getProperty("ssl");
        String dbUser = props.getProperty("dbUser");
        String dbPass = props.getProperty("dbPass");
        con = DriverManager.getConnection(String.format("%s/%s?autoReconnect=%s&useSSL=%s", dbUrl, dbTable, dbReconnect, dbSsl), dbUser, dbPass);
    }
}
