package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Executed2 {
    public static void main(String[] args) throws SQLException {

        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jobcenter",
                "ZakirJdbc","jdbc");
        if (connection !=null){
            System.out.println("Connection is successfull");
        }else {
            System.out.println("Connection is not successfull");
        }
        // Create the statement
        Statement statement = connection.createStatement();

        System.out.println("======Task3========");
// Task 3: Delete the rows from the developers table where prog_lang is 'Film'
        String ts3="DELETE FROM developers WHERE prog_lang = 'Java';";
        int rowsDeleted=statement.executeUpdate(ts3);
        System.out.println("rowsDeleted = " + rowsDeleted);



        // Close the connection and statement
        if (connection != null){
            statement.close();
            connection.close();
            System.out.println("Connection is closed!!");
        }else {
            System.out.println("Connection is not closed");
        }
    }
}
