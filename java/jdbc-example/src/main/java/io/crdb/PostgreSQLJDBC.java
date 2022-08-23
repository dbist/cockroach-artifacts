// https://www.tutorialspoint.com/postgresql/postgresql_java.htm
package io.crdb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.ds.PGSimpleDataSource;

/**
 *
 * @author artem
 */
public class PostgresqlJDBC {

    public static void main(String args[]) {

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(26257);
        ds.setDatabaseName("defaultdb");
        ds.setUser("root");
        ds.setPassword(null);
        ds.setReWriteBatchedInserts(true); // add `rewriteBatchedInserts=true` to pg connection string
        ds.setApplicationName("BasicExample");

        connectToDB(ds);
        createTable(ds);
        truncateTable(ds);
        insertIntoTable(ds);
        upsertIntoTable(ds);
        upsertMultiRow(ds);

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
            String sql = "CREATE TABLE IF NOT EXISTS COMPANY "
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

    public static void truncateTable(PGSimpleDataSource ds) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = ds.getConnection();
                    stmt = c.createStatement();
            String sql = "TRUNCATE TABLE COMPANY";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table truncated successfully");
    }

    public static void insertIntoTable(PGSimpleDataSource ds) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = ds.getConnection();
            c.setAutoCommit(false);
            final String INSERT = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES ";

            stmt = c.createStatement();
            String sql = INSERT + "(1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = INSERT + "(2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = INSERT + "(3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = INSERT + "(4, 'Mark', 25, 'Richmond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records inserted successfully");
    }

    public static void upsertIntoTable(PGSimpleDataSource ds) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = ds.getConnection();
            c.setAutoCommit(false);
            final String UPSERT = "UPSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES ";

            stmt = c.createStatement();
            String sql = UPSERT + "(5, 'Dan', 25, 'Delaware', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = UPSERT + "(6, 'Stan', 35, 'Kansas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = UPSERT + "(7, 'Fran', 46, 'Florida', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = UPSERT + "(8, 'Ben', 50, 'Minnesota ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records upserted successfully");
    }

    public static void upsertMultiRow(PGSimpleDataSource ds) {
        Connection c = null;
        Statement stmt = null;
        long start = System.currentTimeMillis();

        try {
            c = ds.getConnection();
            c.setAutoCommit(true);

            stmt = c.createStatement();
            String sql = "UPSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                                + " VALUES (9, 'Tom', 11, 'Arizona', 20000.00 ), "
                                    + "(10, 'Dick', 22, 'Ohio', 15000.00 ), "
                                    + "(11, 'Harry', 33, 'Omaha', 20000.00 ), "
                                    + "(12, 'Mercedes', 44, 'Kentucky ', 65000.00 );";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Time in milliseconds: " + (System.currentTimeMillis() - start));
        System.out.println("Records upserted successfully");
    }

}
