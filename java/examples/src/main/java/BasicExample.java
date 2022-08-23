
import java.sql.*;
import java.util.Arrays;
import org.postgresql.ds.PGSimpleDataSource;

public class BasicExample {

    public static void main(String[] args) {

        // Configure the database connection.
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(26257);
        ds.setDatabaseName("defaultdb");
        ds.setUser("carl");
//        ds.setPassword(null);
        ds.setSsl(false);
        ds.setKerberosServerName("postgres");
        ds.setJaasApplicationName("BasicExample");
        ds.setJaasLogin(true);
        ds.setGssLib("auto"); // can also be auto
        ds.setUseSpNego(true);

//      ds.setSsl(true);
//        ds.setSslMode("require");
//        ds.setSslCert("certs/client.root.crt");
//        ds.setSslKey("certs/client.root.key.pk8");
//



        ds.setReWriteBatchedInserts(true); // add `rewriteBatchedInserts=true` to pg connection string
        ds.setApplicationName("BasicExample");

        connectToDB(ds);
    }

    public static void connectToDB(PGSimpleDataSource ds) {
        Connection c = null;
        try {
            c = ds.getConnection();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            // stack trace
            System.err.println(Arrays.toString(e.getStackTrace()) + "\n");
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
