import java.sql.*;

public class ExecuteUpdate01 {
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
        // Execute the query
        // Task 1: -- Update salaries of developers whose salaries are less than average salary with average salary
//        String query1 = "UPDATE developers SET salary = (SELECT AVG(salary) FROM developers) WHERE salary < (SELECT AVG(salary) FROM developers);";
//        // 5410.5
//
//        int noOfRowsUpdated = statement.executeUpdate(query1);
//        System.out.println("Number Of Rows Updated = " + noOfRowsUpdated); // 13

        String query2 = "SELECT * FROM developers;";
        ResultSet rs2 = statement.executeQuery(query2);

        // to reach to the data
        while (rs2.next()){
            String dev_name = rs2.getString("name");
            int dev_id = rs2.getInt("id");
            int dev_salary = rs2.getInt("salary");
            String dev_prog_lang = rs2.getString("prog_lang");

            System.out.println(dev_id +" - "+ dev_name +" - "+ dev_salary +" - "+dev_prog_lang);
        }

        System.out.println("======Task2========");

        // Task 2: Add a new developer to the developers table (id, name, salary, prog_lang)
            String query3 = "INSERT INTO developers VALUES(51,'Tom Hanks',7000,'Film');";
            int numberOfRows = statement.executeUpdate(query3);
          System.out.println("A new developer added = " + numberOfRows); // 1

        String query4 = "SELECT * FROM developers;";
        ResultSet rs4 = statement.executeQuery(query4);


        // to reach to the data
        while (rs4.next()){
            String dev_name = rs4.getString("name");
            int dev_id = rs4.getInt("id");
            int dev_salary = rs4.getInt("salary");
            String dev_prog_lang = rs4.getString("prog_lang");

            System.out.println(dev_id +" - "+ dev_name +" - "+ dev_salary +" - "+dev_prog_lang);
        }

        System.out.println("======Task3========");
        // Task 3: Delete the rows from the developers table where prog_lang is 'Ruby'
        String query5 = "DELETE FROM developers WHERE prog_lang = 'Ruby';";

        int rowsDeleted = statement.executeUpdate(query5);
        System.out.println("rowsDeleted = " + rowsDeleted); // 4

        String query6 = "SELECT * FROM developers;";

        ResultSet rs6 = statement.executeQuery(query6);
        // to reach to the data
        while (rs6.next()){
            String dev_name = rs6.getString("name");
            int dev_id = rs6.getInt("id");
            int dev_salary = rs6.getInt("salary");
            String dev_prog_lang = rs6.getString("prog_lang");

            System.out.println(dev_id +" - "+ dev_name +" - "+ dev_salary +" - "+dev_prog_lang);
        }

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