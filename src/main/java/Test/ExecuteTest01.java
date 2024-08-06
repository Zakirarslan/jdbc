package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteTest01 {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jobcenter",
                "ZakirJdbc","jdbc");
        if (connection !=null){
            System.out.println("Connection is successfull");
        }else {
            System.out.println("Connection is not successfull");
        }
        Statement statement=connection.createStatement();
       // statement.execute("DROP TABLE students;");
      statement.execute("CREATE TABLE IF NOT EXISTS colleague (id serial PRIMARY KEY, name VARCHAR (30), age INT, country VARCHAR(30));");



      System.out.println(statement.execute("INSERT INTO  colleague (name, age, country) VALUES ('Zakir', 40, 'Turkmenistan'); "));
      System.out.println(statement.execute("INSERT INTO  colleague (name, age, country) VALUES ( 'Isa', 40, 'Turkey'); "));
      System.out.println(statement.execute("INSERT INTO  colleague (name, age, country) VALUES ( 'Anisa', 30, 'Albania'); "));








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
