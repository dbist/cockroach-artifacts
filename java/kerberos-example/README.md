jaas.conf

```
JaasSample {
  com.sun.security.auth.module.Krb5LoginModule required;
};
```

cli command to execute

```
javac JaasAcn.java
java -Djava.security.krb5.realm=EXAMPLE.COM -Djava.security.krb5.kdc=krb.example.com -Djava.security.auth.login.config=jaas.conf JaasAcn

