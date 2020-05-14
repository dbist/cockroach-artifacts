// https://www.tutorialspoint.com/postgresql/postgresql_java.htm

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.ds.PGSimpleDataSource;
import javax.security.auth.login.*;
import com.sun.security.auth.callback.TextCallbackHandler;

/**
 *
 * @author artem
 */
public class PGSimpleDataSourceExample {

    public static void main(String args[]) {

        LoginContext lc = null;
        try {
            lc = new LoginContext("JaasSample",
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
        System.out.println("Authentication succeeded!");

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(26257);
        ds.setDatabaseName("defaultdb");
        ds.setUseSpNego(true);
        ds.setPassword(null);
        ds.setReWriteBatchedInserts(true); // add `rewriteBatchedInserts=true` to pg connection string
        ds.setApplicationName("BasicExample");

        connectToDB(ds);
        //createTable(ds);
        insertIntoTable(ds);
    }

    public static void connectToDB(PGSimpleDataSource ds) {
        Connection c = null;
        try {
            c = ds.getConnection();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public static void createTable(PGSimpleDataSource ds) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = ds.getConnection();
            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY "
                    + "(ID INT PRIMARY KEY     NOT NULL,"
                    + " NAME           TEXT    NOT NULL, "
                    + " AGE            INT     NOT NULL, "
                    + " ADDRESS        CHAR(50), "
                    + " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void insertIntoTable(PGSimpleDataSource ds) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = ds.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

}
