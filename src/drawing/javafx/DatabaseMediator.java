package drawing.javafx;

import drawing.domain.Drawing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseMediator implements IPersistanceMediator {
    private Properties props;
    private Connection con;

    @Override
    public Drawing load(String drawingName) {
        //TODO: Finish this
        return null;
    }

    @Override
    public boolean save(Drawing drawing) {
        //TODO: Finish this
        return false;
    }

    @Override
    public boolean init(Properties props) {
        //TODO: Finish this
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
        //TODO: Finish this
        con.close();
    }

    private void initConnection() throws SQLException {
        //TODO: Finish this
        String dbUrl = props.getProperty("dbUrl");
        String dbTable = props.getProperty("dbTable");
        String dbReconnect = props.getProperty("reconnect");
        String dbSsl = props.getProperty("ssl");
        String dbUser = props.getProperty("dbUser");
        String dbPass = props.getProperty("dbPass");
        con = DriverManager.getConnection(String.format("%s/%s?autoReconnect=%s&useSSL=%s", dbUrl, dbTable, dbReconnect, dbSsl), dbUser, dbPass);
    }
}
