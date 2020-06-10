package com.cockroachlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class PostgreSqlExampleKerberos {
    public static void main(String[] args) {
        try {
            /**
             * https://www.cockroachlabs.com/docs/stable/build-a-java-app-with-cockroachdb.html#step-2-create-the-maxroach-user-and-bank-database
             * cockroach sql --certs-dir=certs
             * CREATE USER IF NOT EXISTS maxroach;
             * GRANT ALL ON DATABASE bank TO maxroach;
             * 
             * https://www.cockroachlabs.com/docs/stable/build-a-java-app-with-cockroachdb.html#step-3-generate-a-certificate-for-the-maxroach-user
             * cockroach cert create-client maxroach --certs-dir=certs --ca-key=my-safe-directory/ca.key --also-generate-pkcs8-key
             */
            
            Properties properties = new Properties();
            properties.setProperty("user", "pguser");
            
            // need ssmode=verify-full as otherwise it forces password authentication
            properties.setProperty("sslmode", "verify-full");
            //properties.setProperty("sslcert", "certs/client.maxroach.crt");
            
            // make sure the key is in the pk8 format "--also-generate-pkcs8-key" option above
            //properties.setProperty("sslkey", "certs/client.maxroach.key.pk8");
            //properties.setProperty("sslrootcert", "certs/ca.crt");
                        
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
            Logger.getLogger(PostgreSqlExampleKerberos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection getConnection(Properties properties) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:26257/defaultdb", properties);
        Class.forName("org.postgresql.Driver");
        return connection;
    }
}