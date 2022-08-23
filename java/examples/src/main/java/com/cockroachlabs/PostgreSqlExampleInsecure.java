package com.cockroachlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSqlExampleInsecure {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("sslmode", "disable");

            Connection connection = getConnection(properties);

            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading car records...");
            System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.cars");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("model"), resultSet.getString("price"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PostgreSqlExampleInsecure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection getConnection(Properties properties) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:26257/defaultdb", properties);
        Class.forName("org.postgresql.Driver");
        return connection;
    }
}
