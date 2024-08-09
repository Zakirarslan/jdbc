package utilities;

import java.sql.*;

public class LocalDBUtilities {
    public static Connection connection;
    public static Statement statement;
    public static Connection connectToDatabase(){
        String url="jdbc:postgresql://localhost:5432/jobcenter";
        String user="ZakirJdbc";
        String password="jdbc";

        try {
            connection =DriverManager.getConnection(url,user,password);
            if (connection!=null){
                System.out.println("Connection is successfull");
            }else {
                System.out.println("Connection is not successfull");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    public  static Statement createStatement(){
        try {
             statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }


    public static ResultSet executeQuery(String query) throws SQLException {

        try {
            return  statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeConnection() throws SQLException {
       try {
           statement.close();
           connection.close();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }


}























