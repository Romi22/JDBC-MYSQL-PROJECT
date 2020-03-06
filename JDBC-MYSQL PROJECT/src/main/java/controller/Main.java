package controller;

import operations.Delete;
import operations.Create;
import operations.Read;
import operations.Update;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        int choice;

        while(true) {

            System.out.println("Press for the appropriate functionality\n 1.Create\n 2.Read\n 3.Update\n 4.Delete\n 5.Stop\n");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Create i = new Create();
                    i.performOperation();
                    break;
                case 2:
                    Read s = new Read();
                    s.performOperation();
                    break;
                case 3:
                    Update u = new Update();
                    u.performOperation();
                    break;
                case 4:
                    Delete d = new Delete();
                    d.performOperation();
                    break;
                case 5:
                    return;

            }

        }

    }
}
