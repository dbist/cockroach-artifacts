package com.cockroachlabs;

import com.sun.security.auth.callback.TextCallbackHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
 
public class PostgreSqlExampleKerberos {
    public static void main(String[] args) {
        validateKerberosWorks();
    
      System.out.println("Authentication succeeded!");
        
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "pguser");
            
            // need ssmode=require with kerberos, otherwise asking for sslrootcert
            properties.setProperty("sslmode", "require");
            properties.setProperty("jaasLogin", "true");
            properties.setProperty("jaasApplicationName", "KerberosExample");
            properties.setProperty("kerberosServerName", "postgres");
            properties.setProperty("gsslib", "auto");
                        
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

    private static void validateKerberosWorks() {
        // Obtain a LoginContext, needed for authentication. Tell
        // it to use the LoginModule implementation specified by
        // the entry named "JaasSample" in the JAAS login
        // configuration file and to also use the specified
        // CallbackHandler.
        LoginContext lc = null;
        try {
            lc = new LoginContext("KerberosExample",
                    new TextCallbackHandler());
        } catch (LoginException | SecurityException le) {
            System.err.println("Cannot create LoginContext. "
                    + le.getMessage());
            System.exit(-1);
        }
        
        try {
            
            // attempt authentication
            lc.login();
            
        } catch (LoginException le) {
            
            System.err.println("Authentication failed: ");
            System.err.println("  " + le.getMessage());
            System.exit(-1);
            
        }
    }

    private static Connection getConnection(Properties properties) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:26257/defaultdb", properties);
        Class.forName("org.postgresql.Driver");
        return connection;
    }
}