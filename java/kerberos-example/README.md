jaas.conf

```
JaasSample {
  com.sun.security.auth.module.Krb5LoginModule required;
};
```

cli command to execute

This currently works as part of stand-alone class, not via Maven.

```
mkdir example
cd example
cp jaas.conf .
javac JaasAcn.java
java -Djava.security.krb5.realm=EXAMPLE.COM -Djava.security.krb5.kdc=krb.example.com -Djava.security.auth.login.config=jaas.conf JaasAcn
```

```
Kerberos username [vagrant]: carl
Kerberos password for carl:
Authentication succeeded!
```

if you get error message `message stream modified (41)`, this is an issue with CentOS 7 and it is required that `renew_lifetime = 7d` is removed from the `[libdefaults]` section of the `/etc/krb5.conf` file.


```
javac -cp ".:postgresql-42.2.12.jar" PostgresqlJDBC.java
java -Djava.security.krb5.realm=EXAMPLE.COM -Djava.security.krb5.kdc=krb.example.com -Djava.security.auth.login.config=jaas.conf PostgresqlJDBC
```
