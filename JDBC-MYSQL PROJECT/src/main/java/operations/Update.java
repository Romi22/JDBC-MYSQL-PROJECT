package operations;

import connection.JDBCConnection;
import model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update extends CRUD {

    private int id;
    private String name;
    private String city;
    private String department;
    private int age;

    private void getData() throws IOException {

        BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Enter Id:");
        id=Integer.parseInt(br.readLine());

        System.out.println("Enter Name:");
        name=br.readLine();

        System.out.println("Enter City:");
        city=br.readLine();

        System.out.println("Enter Department:");
        department=br.readLine();

        System.out.println("Enter Age:");
        age=Integer.parseInt(br.readLine());
    }

    public void performOperation() throws SQLException, IOException {
        Connection myConn = JDBCConnection.createConnection();
        Statement myStmt = myConn.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "UPDATE empdb.employee SET name=?, city=?,department=?,age=?  WHERE id=?";
        System.out.println("Enter the ID to update");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Enter the new values\n");
        getData();
        Employee employee = new Employee(id, name, city,department,age);

        statement = myConn.prepareStatement(sql);
        statement.setString(1, employee.name);
        statement.setString(2, employee.city);
        statement.setString(4, employee.department);
        statement.setString(3, Integer.toString(employee.age));
        statement.setString(5, Integer.toString(employee.id));


        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }
}
