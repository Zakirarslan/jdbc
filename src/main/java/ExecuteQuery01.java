import com.sun.source.tree.WhileLoopTree;

import java.sql.*;
import java.util.Arrays;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Step 1: Register the class with the Driver (optional)
        Class.forName("org.postgresql.Driver");

        //step 2: Create connection with the DB (using given credentials)
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jobcenter","ZakirJdbc","jdbc");
        if (connection !=null){
            System.out.println("Connection is successufull!");
        }else {
            System.out.println("Connection is not successufull!");
        }

        //step 3: Create a statement
        Statement statement=connection.createStatement();

        // Get the country_name from table whre id is between 3-9
        String query ="SELECT id, country_name From countries Where id between 3 and 9;";
        ResultSet rs1=statement.executeQuery(query);

       // System.out.println(rs1.next());
       // System.out.println(rs1.getInt("id"));
       // System.out.println(rs1.getString("country_name"));
       // System.out.println("=============");

        while (rs1.next()) {
            System.out.println(rs1.getInt(1)+" - "+rs1.getString(2));
        }
        System.out.println("=============");
        // Task 2: Get phone_code and country_name from the countries table where code is greater than 500

        String query1="SELECT phone_code, country_name FROM countries Where phone_code >500;";

        ResultSet r2=statement.executeQuery(query1);

        while (r2.next()) {
            System.out.println(r2.getObject("phone_code"));
        }





        if (connection !=null){
            statement.close();
            connection.close();
            System.out.println("Connection is closed");
        }else {
            System.out.println("Connection is not closed");
        }



    }
}
