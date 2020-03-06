package operations;

import connection.JDBCConnection;

import java.sql.*;

public class Read extends CRUD {
    @Override
    public void performOperation() throws SQLException {
        Connection myConn = JDBCConnection.createConnection();
        Statement myStmt = myConn.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "select * from empdb.employee";
        ResultSet rs = myStmt.executeQuery(sql);

        while (rs.next()){
            String id = rs.getString("id");
            String name = rs.getString("name");
            String city = rs.getString("city");
            String department = rs.getString("department");
            String age = rs.getString("age");
            System.out.println("Record " + id + " is " + name + " " + city + " " + age + " " + department);
        }
    }
}
