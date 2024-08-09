import java.sql.*;

public class PreparedStatement02 {
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

        String query="DELETE FROM students WHERE department ILIKE ?;";
        PreparedStatement prs1= connection.prepareStatement(query);

        prs1.setString(1,"Comp.ENG");













        // To see the data
        String query2 = "SELECT * FROM students;";
        ResultSet rs1 = statement.executeQuery(query);

        while (rs1.next()){
            int stdnt_id = rs1.getInt("id");
            String stdnt_name = rs1.getString("name");
            String stdnt_city = rs1.getString("city");
            String stdnt_deaprtment = rs1.getString("department");
            int grade=rs1.getInt("grade");

            System.out.println( stdnt_id + " - "+ stdnt_name + " - "+ stdnt_city + " - "+ stdnt_deaprtment+" - "+grade);
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
