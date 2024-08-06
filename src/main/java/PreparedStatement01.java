import jdk.internal.access.JavaIOFileDescriptorAccess;

import java.sql.*;

public class PreparedStatement01 {
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
        // Task 1: Update pass_grade to 475 of Mathematics department from departments table (use PreparedStatement)

        // Normal query
//        String query1 = "UPDATE departments SET pass_grade = 475 WHERE department = 'Mathematics';";
//        String query2 = "UPDATE departments SET pass_grade = 505 WHERE department = 'Comp.Eng.';";
//        String query3 = "UPDATE departments SET pass_grade = 540 WHERE department = 'Literature';";
//        String query4 = "UPDATE departments SET pass_grade = 5475 WHERE department ILIKE 'Management';";
//        String query4 = "UPDATE departments SET pass_grade = 5475 WHERE department ILIKE 'Management';";

        // dynamic query => reusable query => prepared statement ... to avoid repetition


        // Parameterised query

//        String query1 = "UPDATE departments SET pass_grade =  ?  WHERE department =  ?  ;";
        String query1 = "UPDATE departments SET pass_grade =  ?  WHERE department ILIKE ?  ;";
        PreparedStatement prs1 = connection.prepareStatement(query1); //   We don't need statement when we are dealing with Parameterised query. Instead, we need PreparedStatement.

        prs1.setString(2, "Management");
        prs1.setInt(1, 495);

        int rowsUpdated = prs1.executeUpdate();
        System.out.println("rowsUpdated = " + rowsUpdated);

        // To see the data
        String query2 = "SELECT * FROM departments; ";
        ResultSet rs2 = statement.executeQuery(query2);

        while (rs2.next()){
            int dept_id = rs2.getInt("dept_id");
            int pass_grade = rs2.getInt("pass_grade");
            String dep_name = rs2.getString("department");
            String campus = rs2.getString("campus");

            System.out.println( dept_id + " - "+ dep_name + " - "+ pass_grade + " - "+ campus);
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