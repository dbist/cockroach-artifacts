package com.cockroachlabs.jooq.example;

// For convenience, always static import your generated tables and jOOQ functions to decrease verbosity:
import app.cash.jooq.RealJooqKeyPrimitive;
import static com.cockroachlabs.jooq.encryption.tables.Author.AUTHOR;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeysetHandle;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;

import org.jooq.Record;
import java.sql.*;
import java.util.Map;
import java.util.logging.Logger;
import org.jooq.*;
import org.jooq.impl.*;

public class JooqExample {

    /**
     * @param args
     * @throws java.security.GeneralSecurityException
     */
    public static void main(String[] args) throws GeneralSecurityException, SQLException {
        String userName = "root";
        String password = "";
        String url = "jdbc:postgresql://localhost:26257/library";

        AeadConfig.register();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(
                AeadKeyTemplates.AES256_GCM);

        String plaintext = "baeldung";
        String associatedData = "Tink";

        Aead aead = AeadFactory.getPrimitive(keysetHandle);
        byte[] ciphertext = aead.encrypt(plaintext.getBytes(), associatedData.getBytes());
        //String decrypted = new String(aead.decrypt(ciphertext, associatedData.getBytes()));



        var jooqIndexableKeyMap = Map.of("author.last_name_encrypted", ciphertext);
        //RealJooqKeyPrimitive.initialize(jooqIndexableKeyMap);

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.COCKROACHDB);

            create.batch(create.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME, AUTHOR.FIRST_NAME_ENCRYPTED, AUTHOR.LAST_NAME_ENCRYPTED).values((Long) null, null, null, null, null))
                    .bind(1, "Erich", "Gamma", null, ciphertext)
                    .bind(2, "Richard", "Helm", null, ciphertext)
                    .bind(3, "Ralph", "Johnson", null, ciphertext)
                    .bind(4, "John", "Vlissides", null, ciphertext)
                    .execute();
        } // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
        } // For the sake of this tutorial, let's keep exception handling simple

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.COCKROACHDB);
        Result<Record> result = create.select().from(AUTHOR).fetch();

            result.forEach(r -> {
                Long id = r.getValue(AUTHOR.ID);
                String firstName = r.getValue(AUTHOR.FIRST_NAME);
                String lastName = r.getValue(AUTHOR.LAST_NAME);
                byte[] firstNameEnc = r.getValue(AUTHOR.FIRST_NAME_ENCRYPTED);
                byte[] lastNameEnc = r.getValue(AUTHOR.LAST_NAME_ENCRYPTED);

                try {
                    String decrypted = new String(aead.decrypt(lastNameEnc, associatedData.getBytes()));
                    System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName + " first name encrypted" + firstNameEnc.toString() + " last name encrypted" + decrypted);
                } catch (GeneralSecurityException ex) {
                    Logger.getLogger(JooqExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            });
        } // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
        } // For the sake of this tutorial, let's keep exception handling simple
    }
}
