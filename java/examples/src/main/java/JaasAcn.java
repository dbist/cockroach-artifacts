import javax.security.auth.login.*;
import com.sun.security.auth.callback.TextCallbackHandler;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/guides/security/jgss/tutorials/AcnOnly.html
 * This JaasAcn application attempts to authenticate a user
 * and reports whether or not the authentication was successful.
 */

public class JaasAcn {

  public static void main(String[] args) {

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

      System.out.println("Authentication succeeded!");

    }
}
