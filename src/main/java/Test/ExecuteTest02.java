package Test;

import java.sql.*;

public class ExecuteTest02 {
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

        String query1="SELECT * FROM developers WHERE salary=(SELECT MIN(salary) FROM developers);";
        ResultSet rs1=statement.executeQuery(query1);
        while (rs1.next()){
            int id=rs1.getInt("id");
            int salary=rs1.getInt("salary");
            String dev_name=rs1.getString("name");
            String prog_lang=rs1.getString("prog_lang");
            System.out.println("id = "+id+ ", Name = "+dev_name+", Program = "+prog_lang+", Salary = "+salary);
      }
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
        String homeWorkWay1="SELECT department, pass_grade FROM departments WHERE " +
                "pass_grade=(SELECT MAX(pass_grade) From departments Where " +
                "pass_grade<(SELECT MAX (pass_grade) FROM departments));";
        ResultSet rshw1=statement.executeQuery(homeWorkWay1);
        while (rshw1.next()){
            String DepName=rshw1.getString("department");
            int grade=rshw1.getInt("pass_grade");
            System.out.println("Department = "+DepName+", Grade = "+grade+".");
        }



        // 2nd way: Using ORDER BY
        String homeWorkWAy2="SELECT department, pass_grade FROM departments ORDER BY pass_grade DESC LIMIT 1 OFFSET 1;";
        ResultSet rshw2=statement.executeQuery(homeWorkWAy2);

        while (rshw2.next()){
            String DepName=rshw2.getString("department");
            int grade=rshw2.getInt("pass_grade");
            System.out.println("Department = "+DepName+", Grade = "+grade+".");
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
