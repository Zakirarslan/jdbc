import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        NOTES:
        * pgAdmin4 is used for MANUAL TEST of the DB
        * JDBC Driver is used for AUTOMATION TEST of db

        To connect with the DB, follow these steps:
        Step 1: Register the class with the Driver (optional)
        step 2: Create connection with the DB (using given credentials)
        step 3: Create a statement
        step 4: Execute the query
        step 5: Close the connection

         */

        //Step 1: Register the class with the Driver (optional)
        Class.forName("org.postgresql.Driver");

        //step 2: Create connection with the DB (using given credentials)
        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jobcenter","ZakirJdbc","jdbc");
        if (connection !=null){
            System.out.println("Connection is successufull!");
        }else {
            System.out.println("Connection is not successufull!");
        }

       //step 3: Create a statement
       Statement statement=connection.createStatement();



        //step 4: Execute the query
        System.out.println(statement.execute("CREATE TABLE IF NOT EXISTS employees (employee_id INT, employee_name VARCHAR (30), salary INT);"));

        /*
        NOTES:
        1. execute() method returns boolean
        2. This method can be used with DDL (CREATE, ALTER, DROP table  etc.), DML (ADD, UPDATE data) and DQL (SELECT)
        3. execute() method with DDL and DML => ALWAYS returns false because the query is executed but no resultSet is created.
        3. execute() method with DQL => can return true OR false
                                        With SELECT statements, execute() checks if resultSet is created or not.
                                        Because resultSet is created it will return true.

         */

        // Add a column to the employees table
        String query = "ALTER TABLE employees ADD COLUMN IF NOT EXISTS employees_address VARCHAR (50);";

        boolean sql1 = statement.execute(query);
        System.out.println("sql1 = " + sql1);  // false because no resultSet os produced.

        // Read the data from table
        System.out.println("Before entering Data: "+statement.execute("SELECT * FROM employees;"));
        // Add some data into this table
        boolean sql3=statement.execute("INSERT INTO employees VALUES(101, 'John Doe', 9000, 'Hendon, UK' )");
        System.out.println("Table after adding "+sql3);

        boolean sql4= statement.execute("DROP TABLE employees;");
        System.out.println("sql4 = "+ sql4);


        //step 5: Close the connection
        if (connection !=null){
            statement.close();
            connection.close();
            System.out.println("Connection is closed");
        }else {
            System.out.println("Connection is not closed");
        }














    }
}







