package day01;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C03_CountriesTest2 {
    @Test
    public void countriesTest() throws SQLException {
        // Create the connection
        String url="jdbc:postgresql://localhost:5432/jobcenter";
        String user="ZakirJdbc";
        String password="jdbc";

        Connection connection = DriverManager.getConnection(url, user, password);
        if (connection != null){
            System.out.println("Connection is successful!");
        }else {
            System.out.println("Connection is not successful!");
        }

        // Create the statement
        Statement statement = connection.createStatement();

        // Execute the SQL query
        // Task: Get all the country codes from countries table and print them as a list

        String query1="SELECT country_code FROM countries;";
        ResultSet rs1= statement.executeQuery(query1);

        List<String> countryCodesList = new ArrayList<>();

        while (rs1.next()) {
            String countryCode = rs1.getString("country_code");
            countryCodesList.add(countryCode);

        }

        System.out.println(countryCodesList);
        System.out.println("country CodesList size = " + countryCodesList.size()); // 50

        assertEquals(50, countryCodesList.size());


        //Task: Get all the phone codes from countries table and verify that number of phone codes greater than 300 is 13
        String query2 = "SELECT phone_code FROM countries;";
        ResultSet rs2 = statement.executeQuery(query2);

        List<Integer> phoneCodesList = new ArrayList<>();

        while (rs2.next()) {
            int phoneCode = rs2.getInt("phone_code");
            phoneCodesList.add(phoneCode);
        }
        System.out.println("phoneCodesList = " + phoneCodesList);

        // verify that number of phone codes greater than 300 is 13

        int counter = 0;

        for (Integer w: phoneCodesList){
            if (w > 300){
                counter++;
            }
        }
        System.out.println("number of codes greater than 300: " + counter);
        assertEquals(15, counter, "the result is not as expected!!");

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
