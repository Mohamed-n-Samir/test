package databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseProject {


    public static void main(String[] args) {
         String connectionUrl =
                "jdbc:sqlserver://PANDETA:1433;"
                + "database=employees;"
//                + "user=nash2t@PANDETA;"
//                + "password=test123@;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;"
                + "integratedSecurity=true;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from employee";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) +" "+ resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    }
    

