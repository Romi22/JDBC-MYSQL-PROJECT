package operations;

import connection.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete extends CRUD {
    @Override
    public void performOperation() throws SQLException {
        Connection myConn = JDBCConnection.createConnection();
        Statement myStmt = myConn.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "DELETE FROM empdb.employee WHERE id=?";
        statement = myConn.prepareStatement(sql);
        System.out.println("Enter the Employee id to delete");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();

        statement.setString(1, Integer.toString(id));

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
    }
}
