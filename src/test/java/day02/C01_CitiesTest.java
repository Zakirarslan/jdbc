package day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.LocalDBUtilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_CitiesTest {
    @Test
    public void citiesTest() throws SQLException {
        // Create connection
        LocalDBUtilities.connectToDatabase();

        //Create statement
        LocalDBUtilities.createStatement();

        //Execute query
        // Task 1.
        //-- Get the license plate codes of cities with a population of less than 700 000 from the 'cities' table
        String query="Select  plate_code From cities WHERE population <700000;";
        ResultSet rs1=LocalDBUtilities.executeQuery(query);

        List<Integer> plateCodeList=new ArrayList<>();
        while (rs1.next()){
            plateCodeList.add(rs1.getInt("plate_code"));
        }
        System.out.println("plateCodeList = " + plateCodeList);

        // Task 2.
        //--verify that the number of results from the database is 4
        Assertions.assertEquals(4,plateCodeList.size());

        // Task 3.
        //-- Verify that the results from the database include license plate codes 58 and 43
        List<Integer> expectedData= Arrays.asList(58);
        Assertions.assertTrue(plateCodeList.contains(expectedData));


        //Close connection


    }
}















