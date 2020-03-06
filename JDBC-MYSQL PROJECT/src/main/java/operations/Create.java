package operations;
import connection.JDBCConnection;
import model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Create extends CRUD {
    int id;
    String name;
    String city;
    String department;
    int age;

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

    @Override
    public void performOperation() throws SQLException, IOException {
        Connection myConn = JDBCConnection.createConnection();
        Statement myStmt = myConn.createStatement();
        String sql;
        PreparedStatement statement;

        sql = "INSERT INTO empdb.employee(id, name, city, department, age) VALUES (?, ?, ?, ?,?)";
        statement = myConn.prepareStatement(sql);
        System.out.println("Enter the Values");
        getData();
        Employee employee = new Employee(id, name, city,department,age);

        statement.setString(1, Integer.toString(employee.id));
        statement.setString(2, employee.name);
        statement.setString(3, employee.city);
        statement.setString(5, employee.department);
        statement.setString(4, Integer.toString(employee.age));

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }
}
