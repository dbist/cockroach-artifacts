package com.cockroachlabs.jooq.example;

// For convenience, always static import your generated tables and jOOQ functions to decrease verbosity:
import static generated.tables.Author.AUTHOR;
import static org.jooq.impl.DSL.*;

import org.jooq.Record;
import java.sql.*;
import org.jooq.*;
import org.jooq.impl.*;

public class JooqExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String userName = "root";
        String password = "";
        String url = "jdbc:postgresql://localhost:26257/library";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.COCKROACHDB);

            create.batch(create.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME).values((Long) null, null, null))
                    .bind(1, "Erich", "Gamma")
                    .bind(2, "Richard", "Helm")
                    .bind(3, "Ralph", "Johnson")
                    .bind(4, "John", "Vlissides")
                    .execute();

            Result<Record> result = create.select().from(AUTHOR).fetch();

            result.forEach(r -> {
                Long id = r.getValue(AUTHOR.ID);
                String firstName = r.getValue(AUTHOR.FIRST_NAME);
                String lastName = r.getValue(AUTHOR.LAST_NAME);

                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            });

        } // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
        }
    }
}
