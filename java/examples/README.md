# Sample kerberos example

jaas.conf

```java
KerberosExample {
  com.sun.security.auth.module.Krb5LoginModule required;
};
```

cli command to execute

This currently works as part of stand-alone class, not via Maven.

```bash
mkdir example
cd example
cp jaas.conf .
javac JaasAcn.java
java -Djava.security.krb5.realm=EXAMPLE.COM -Djava.security.krb5.kdc=krb.example.com -Djava.security.auth.login.config=jaas.conf JaasAcn
```

if maven is used and maven-assembly has main class manifest, then command changes to

```bash
java -jar examples-1.0-SNAPSHOT-jar-with-dependencies.jar -Djava.security.krb5.realm=EXAMPLE.COM -Djava.security.krb5.kdc=node.example.com -Djava.security.auth.login.config=jaas.conf
```

```bash
Kerberos username [vagrant]: carl
Kerberos password for carl:
Authentication succeeded!
```

if you get error message `message stream modified (41)`, this is an issue with CentOS 7 and it is required that `renew_lifetime = 7d` is removed from the `[libdefaults]` section of the `/etc/krb5.conf` file.


```bash
javac -cp ".:postgresql-42.2.12.jar" PostgresqlJDBC.java
java -Djava.security.krb5.realm=EXAMPLE.COM -Djava.security.krb5.kdc=krb.example.com -Djava.security.auth.login.config=jaas.conf PostgresqlJDBC
```

```bash
[vagrant@node example]$ java -jar examples-1.0-SNAPSHOT-jar-with-dependencies.jar -Djava.security.krb5.realm=EXAMPLE.COM -Djava.security.krb5.kdc=node.example.com -Djava.security.auth.login.config=jaas.conf
Jun 11, 2020 3:31:29 PM com.cockroachlabs.PostgreSqlExampleKerberos main
SEVERE: null
org.postgresql.util.PSQLException: GSS Authentication failed
        at org.postgresql.gss.MakeGSS.authenticate(MakeGSS.java:65)
        at org.postgresql.core.v3.ConnectionFactoryImpl.doAuthentication(ConnectionFactoryImpl.java:652)
        at org.postgresql.core.v3.ConnectionFactoryImpl.tryConnect(ConnectionFactoryImpl.java:146)
        at org.postgresql.core.v3.ConnectionFactoryImpl.openConnectionImpl(ConnectionFactoryImpl.java:197)
        at org.postgresql.core.ConnectionFactory.openConnection(ConnectionFactory.java:49)
        at org.postgresql.jdbc.PgConnection.<init>(PgConnection.java:217)
        at org.postgresql.Driver.makeConnection(Driver.java:458)
        at org.postgresql.Driver.connect(Driver.java:260)
        at java.sql.DriverManager.getConnection(DriverManager.java:664)
        at java.sql.DriverManager.getConnection(DriverManager.java:208)
        at com.cockroachlabs.PostgreSqlExampleKerberos.getConnection(PostgreSqlExampleKerberos.java:41)
        at com.cockroachlabs.PostgreSqlExampleKerberos.main(PostgreSqlExampleKerberos.java:25)
Caused by: javax.security.auth.login.LoginException: No LoginModules configured for KerberosExample
        at javax.security.auth.login.LoginContext.init(LoginContext.java:264)
        at javax.security.auth.login.LoginContext.<init>(LoginContext.java:417)
        at org.postgresql.gss.MakeGSS.authenticate(MakeGSS.java:55)
        ... 11 more

[vagrant@node example]$ klist
Ticket cache: KEYRING:persistent:1000:1000
Default principal: pguser@EXAMPLE.COM
```
