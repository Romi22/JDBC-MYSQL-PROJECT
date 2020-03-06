package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
    String url;
    String user;
    String password;

    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/empdb";
        String user = "root";
        String password = "Romi@0075";
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(url, user, password);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return myConn;
    }
}
