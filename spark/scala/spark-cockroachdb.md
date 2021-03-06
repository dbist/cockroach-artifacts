# Sample Spark CockroachDB app

```scala
%AddDeps org.postgresql postgresql 42.2.10
```

```bash
    Marking org.postgresql:postgresql:42.2.10 for download
    Obtained 2 files
```


```scala
val jdbcDF = spark.read
.format("jdbc")
.option("url", "jdbc:postgresql://crdb-1:26257/defaultdb?sslmode=disable")
.option("driver", "org.postgresql.Driver")
.option("user", "maxroach")
.option("password", "")
.option("dbtable", "users")
.load()
```

```bash
    jdbcDF = [id: string, username: string]

    lastException: Throwable = null

    [id: string, username: string]
```

```scala
jdbcDF.show()
```

```bash
    +--------------------+--------+
    |                  id|username|
    +--------------------+--------+
    |ee810878-bef2-49d...|    john|
    |f2248032-94cd-472...|    mary|
    +--------------------+--------+
```

```scala
jdbcDF.explain
```

```bash
    == Physical Plan ==
    *(1) Scan JDBCRelation(users) [numPartitions=1] [id#0,username#1] PushedFilters: [], ReadSchema: struct<id:string,username:string>
```

```scala
val companyDF = spark.read
.format("jdbc")
.option("url", "jdbc:postgresql://crdb-1:26257/defaultdb?sslmode=disable")
.option("driver", "org.postgresql.Driver")
.option("user", "maxroach")
.option("password", "")
.option("dbtable", "company")
.load()
```

```bash
    companyDF = [id: bigint, name: string ... 3 more fields]

    [id: bigint, name: string ... 3 more fields]
```

```scala
companyDF.head()
```

```bash
    [1,Paul,32,California,20000.0]
```
