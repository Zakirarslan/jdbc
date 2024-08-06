import java.sql.*;

public class ExecuteQuery02 {
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

        // Create developers table through pgAdmin4
        // Task 1: Get all information about the developers whose salary is the lowest

        System.out.println("========Task 1=========");
        String query1 = "SELECT * FROM developers WHERE salary = (SELECT MIN(salary) FROM developers);";
        ResultSet rs1 = statement.executeQuery(query1);

        // to reach to the data
        while (rs1.next()){
            String dev_name = rs1.getString("name");
            int dev_id = rs1.getInt("id");
            int dev_salary = rs1.getInt("salary");
            String dev_prog_lang = rs1.getString("prog_lang");

            System.out.println(dev_id +" - "+ dev_name +" - "+ dev_salary +" - "+dev_prog_lang);
        }
        System.out.println("========Task2=========");

        // Create students table
        // Task 2: Display names of the students and their grades if their grades are higher than the pass grade of their department

        String query2 = "SELECT name, grade, s.department FROM students s JOIN departments d ON s.department = d.department WHERE s.grade > d.pass_grade\n";

        ResultSet rs2 = statement.executeQuery(query2);

        while (rs2.next()){
            String std_name = rs2.getString("name");
            String std_dept = rs2.getString("department");
            int std_grade = rs2.getInt("grade");

            System.out.println(std_name + " = " +std_grade + " = " + std_dept);
        }

        System.out.println("========= HW TASK =========");
        // Print department name and grade of department which has the second-highest pass_grade
        // 1st way: Using SUB-QUERY
        // 2nd way: Using ORDER BY









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
