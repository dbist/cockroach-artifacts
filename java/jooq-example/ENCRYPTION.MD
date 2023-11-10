brew install kotlin

install java 21

use jooq 3.17.6
run ./maven-install.sh to install the local dependencies

https://github.com/cashapp/jooq-encryption/blob/main/build.gradle.kts#L18C15-L22


java -cp jooq-3.17.16.jar:jooq-meta-extensions-3.17.16.jar:jooq-meta-3.17.16.jar:jooq-codegen-3.17.16.jar:jooq-kotlin-3.17.16.jar:jakarta.xml.bind-api-3.0.0.jar:r2dbc-spi-0.9.1.RELEASE.jar:reactive-streams-1.0.3.jar:jooq-encryption-1.0.1.jar:postgresql-42.5.4.jar:kotlin-stdlib-1.9.20.jar org.jooq.codegen.GenerationTool jooq-encryption-config.xml



08:46:08 INFO Initialising properties  : jooq-encryption-config.xml
08:46:09 INFO No <inputCatalog/> was provided. Generating ALL available catalogs instead.
08:46:09 INFO License parameters
08:46:09 INFO ----------------------------------------------------------
08:46:09 INFO   Thank you for using jOOQ and jOOQ's code generator
08:46:09 INFO
08:46:09 INFO Database parameters
08:46:09 INFO ----------------------------------------------------------
08:46:09 INFO   dialect                : COCKROACHDB
08:46:09 INFO   URL                    : jdbc:postgresql://localhost:26257/library?sslmode=disable
08:46:09 INFO   target dir             : /Users/artem/NetBeansProjects/jooq-example
08:46:09 INFO   target package         : encryption
08:46:09 INFO   includes               : [.*]
08:46:09 INFO   excludes               : []
08:46:09 INFO   includeExcludeColumns  : false
08:46:09 INFO ----------------------------------------------------------
08:46:09 INFO
08:46:09 INFO JavaGenerator parameters
08:46:09 INFO ----------------------------------------------------------
08:46:09 INFO annotations
08:46:09 INFO   generated              : false
08:46:09 INFO   JPA                    : false
08:46:09 INFO   JPA version            :
08:46:09 INFO   validation             : false
08:46:09 INFO   spring                 : false
08:46:09 INFO comments
08:46:09 INFO   comments               : true
08:46:09 INFO   on attributes          : true
08:46:09 INFO   on catalogs            : true
08:46:09 INFO   on columns             : true
08:46:09 INFO   on embeddables         : true
08:46:09 INFO   on keys                : true
08:46:09 INFO   on links               : true
08:46:09 INFO   on packages            : true
08:46:09 INFO   on parameters          : true
08:46:09 INFO   on queues              : true
08:46:09 INFO   on routines            : true
08:46:09 INFO   on schemas             : true
08:46:09 INFO   on sequences           : true
08:46:09 INFO   on tables              : true
08:46:09 INFO   on udts                : true
08:46:09 INFO sources
08:46:09 INFO   sources                : true
08:46:09 INFO   sources on views       : true
08:46:09 INFO global references
08:46:09 INFO   global references      : true
08:46:09 INFO   catalogs               : true
08:46:09 INFO   domains                : true
08:46:09 INFO   indexes                : true
08:46:09 INFO   keys                   : true
08:46:09 INFO   links                  : true
08:46:09 INFO   queues                 : true
08:46:09 INFO   routines               : true
08:46:09 INFO   schemas                : true
08:46:09 INFO   sequences              : true
08:46:09 INFO   tables                 : true
08:46:09 INFO   udts                   : true
08:46:09 INFO object types
08:46:09 INFO   daos                   : false
08:46:09 INFO   indexes                : true
08:46:09 INFO   instance fields        : true
08:46:09 INFO   interfaces             : false
08:46:09 INFO   interfaces (immutable) : false
08:46:09 INFO   javadoc                : true
08:46:09 INFO   keys                   : true
08:46:09 INFO   links                  : true
08:46:09 INFO   pojos                  : false
08:46:09 INFO   pojos (immutable)      : false
08:46:09 INFO   queues                 : true
08:46:09 INFO   records                : true
08:46:09 INFO   routines               : true
08:46:09 INFO   sequences              : true
08:46:09 INFO   sequenceFlags          : true
08:46:09 INFO   table-valued functions : true
08:46:09 INFO   tables                 : true
08:46:09 INFO   udts                   : true
08:46:09 INFO   relations              : true
08:46:09 INFO other
08:46:09 INFO   deprecated code        : true
08:46:09 INFO ----------------------------------------------------------
08:46:09 INFO
08:46:09 INFO Generation remarks
08:46:09 INFO ----------------------------------------------------------
08:46:09 INFO
08:46:09 INFO ----------------------------------------------------------
08:46:09 INFO Generating catalogs      : Total: 1
08:46:09 INFO Version                  : Database version is supported by dialect COCKROACHDB: CockroachDB CCL v23.1.11 (aarch64-apple-darwin21.2, built 2023/09/27 02:20:44, go1.19.10)
08:46:09 INFO ARRAYs fetched           : 0 (0 included, 0 excluded)
08:46:09 INFO Domains fetched          : 0 (0 included, 0 excluded)
08:46:09 INFO Tables fetched           : 1 (1 included, 0 excluded)
08:46:09 INFO Embeddables fetched      : 0 (0 included, 0 excluded)
08:46:09 INFO Enums fetched            : 0 (0 included, 0 excluded)
08:46:09 INFO Packages fetched         : 0 (0 included, 0 excluded)
08:46:09 INFO Routines fetched         : 0 (0 included, 0 excluded)
08:46:09 INFO Sequences fetched        : 0 (0 included, 0 excluded)
08:46:09 INFO No schema version is applied for catalog . Regenerating.
08:46:09 INFO
08:46:09 INFO Generating catalog       : DefaultCatalog.java
08:46:09 INFO ==========================================================
08:46:09 INFO Generating schemata      : Total: 1
08:46:09 INFO No schema version is applied for schema public. Regenerating.
08:46:09 INFO Generating schema        : Public.java
08:46:09 INFO ----------------------------------------------------------
08:46:09 INFO UDTs fetched             : 0 (0 included, 0 excluded)
08:46:09 INFO Generating tables
08:46:09 INFO Generating table         : Author.java [input=author, pk=author_pkey]
08:46:09 SEVERE Error while generating table public.author
java.lang.NullPointerException: table.comment must not be null
        at app.cash.jooq.EncryptionAwareJavaGenerator$EncryptionAwareTableDefinition.getComment(EncryptionAwareJavaGenerator.kt:82)
        at org.jooq.codegen.JavaGenerator.printClassJavadoc(JavaGenerator.java:9036)
        at org.jooq.codegen.JavaGenerator.generateTableClassJavadoc(JavaGenerator.java:7337)
        at org.jooq.codegen.JavaGenerator.generateTable(JavaGenerator.java:5989)
        at app.cash.jooq.EncryptionAwareJavaGenerator.generateTable(EncryptionAwareJavaGenerator.kt:40)
        at org.jooq.codegen.JavaGenerator.generateTable(JavaGenerator.java:5954)
        at org.jooq.codegen.JavaGenerator.generateTables(JavaGenerator.java:5924)
        at org.jooq.codegen.JavaGenerator.generate(JavaGenerator.java:673)
        at org.jooq.codegen.JavaGenerator.generate(JavaGenerator.java:628)
        at org.jooq.codegen.JavaGenerator.generate0(JavaGenerator.java:540)
        at org.jooq.codegen.AbstractGenerator.generate(AbstractGenerator.java:187)
        at org.jooq.codegen.JavaGenerator.generate(JavaGenerator.java:228)
        at org.jooq.codegen.GenerationTool.run0(GenerationTool.java:929)
        at org.jooq.codegen.GenerationTool.run(GenerationTool.java:244)
        at org.jooq.codegen.GenerationTool.generate(GenerationTool.java:239)
        at org.jooq.codegen.GenerationTool.main(GenerationTool.java:211)

08:46:09 INFO Tables generated         : Total: 512.9ms
08:46:09 INFO Generating table references
08:46:09 INFO Table refs generated     : Total: 514.744ms, +1.844ms
08:46:09 INFO Generating Keys
08:46:09 INFO Keys generated           : Total: 516.127ms, +1.382ms
08:46:09 INFO Generating Indexes
08:46:09 INFO Indexes fetched          : 0 (0 included, 0 excluded)
08:46:09 INFO Skipping empty indexes
08:46:09 INFO Generating table records
08:46:09 SEVERE Error while generating table record public.author
java.lang.NullPointerException: table.comment must not be null
        at app.cash.jooq.EncryptionAwareJavaGenerator$EncryptionAwareTableDefinition.getComment(EncryptionAwareJavaGenerator.kt:82)
        at org.jooq.codegen.JavaGenerator.printClassJavadoc(JavaGenerator.java:9036)
        at org.jooq.codegen.JavaGenerator.generateRecordClassJavadoc(JavaGenerator.java:2766)
        at org.jooq.codegen.JavaGenerator.generateRecord0(JavaGenerator.java:1528)
        at org.jooq.codegen.JavaGenerator.generateRecord(JavaGenerator.java:1508)
        at app.cash.jooq.EncryptionAwareJavaGenerator.generateRecord(EncryptionAwareJavaGenerator.kt:49)
        at org.jooq.codegen.JavaGenerator.generateRecords(JavaGenerator.java:1482)
        at org.jooq.codegen.JavaGenerator.generate(JavaGenerator.java:703)
        at org.jooq.codegen.JavaGenerator.generate(JavaGenerator.java:628)
        at org.jooq.codegen.JavaGenerator.generate0(JavaGenerator.java:540)
        at org.jooq.codegen.AbstractGenerator.generate(AbstractGenerator.java:187)
        at org.jooq.codegen.JavaGenerator.generate(JavaGenerator.java:228)
        at org.jooq.codegen.GenerationTool.run0(GenerationTool.java:929)
        at org.jooq.codegen.GenerationTool.run(GenerationTool.java:244)
        at org.jooq.codegen.GenerationTool.generate(GenerationTool.java:239)
        at org.jooq.codegen.GenerationTool.main(GenerationTool.java:211)

08:46:09 INFO Table records generated  : Total: 555.969ms, +39.841ms
08:46:09 INFO Generation finished: public: Total: 556.233ms, +0.264ms
08:46:09 INFO
08:46:09 INFO Affected files: 4
08:46:09 INFO Modified files: 0
08:46:09 INFO No modified files        : This code generation run has not produced any file modifications.
This means, the schema has not changed, and no other parameters (jOOQ version, driver version, database version,
and any configuration elements) have changed either.

In automated builds, it is recommended to prevent unnecessary code generation runs. This run took: 530.691ms
Possible means to prevent this:
- Use manual code generation and check in generated sources: https://www.jooq.org/doc/latest/manual/code-generation/codegen-version-control/
- Use schema version providers: https://www.jooq.org/doc/latest/manual/code-generation/codegen-advanced/codegen-config-database/codegen-database-version-providers/
- Use gradle tasks and inputs: https://github.com/etiennestuder/gradle-jooq-plugin/blob/master/README.md
08:46:09 INFO Removing excess files



After adding table comment on Author



08:59:08 INFO Initialising properties  : jooq-encryption-config.xml
08:59:08 INFO No <inputCatalog/> was provided. Generating ALL available catalogs instead.
08:59:08 INFO License parameters
08:59:08 INFO ----------------------------------------------------------
08:59:08 INFO   Thank you for using jOOQ and jOOQ's code generator
08:59:08 INFO
08:59:08 INFO Database parameters
08:59:08 INFO ----------------------------------------------------------
08:59:08 INFO   dialect                : COCKROACHDB
08:59:08 INFO   URL                    : jdbc:postgresql://localhost:26257/library?sslmode=disable
08:59:08 INFO   target dir             : /Users/artem/Documents/cockroach-work/cockroach-artifacts/java/jooq-example
08:59:08 INFO   target package         : encryption
08:59:08 INFO   includes               : [.*]
08:59:08 INFO   excludes               : []
08:59:08 INFO   includeExcludeColumns  : false
08:59:08 INFO ----------------------------------------------------------
08:59:08 INFO
08:59:08 INFO JavaGenerator parameters
08:59:08 INFO ----------------------------------------------------------
08:59:08 INFO annotations
08:59:08 INFO   generated              : false
08:59:08 INFO   JPA                    : false
08:59:08 INFO   JPA version            :
08:59:08 INFO   validation             : false
08:59:08 INFO   spring                 : false
08:59:08 INFO comments
08:59:08 INFO   comments               : true
08:59:08 INFO   on attributes          : true
08:59:08 INFO   on catalogs            : true
08:59:08 INFO   on columns             : true
08:59:08 INFO   on embeddables         : true
08:59:08 INFO   on keys                : true
08:59:08 INFO   on links               : true
08:59:08 INFO   on packages            : true
08:59:08 INFO   on parameters          : true
08:59:08 INFO   on queues              : true
08:59:08 INFO   on routines            : true
08:59:08 INFO   on schemas             : true
08:59:08 INFO   on sequences           : true
08:59:08 INFO   on tables              : true
08:59:08 INFO   on udts                : true
08:59:08 INFO sources
08:59:08 INFO   sources                : true
08:59:08 INFO   sources on views       : true
08:59:08 INFO global references
08:59:08 INFO   global references      : true
08:59:08 INFO   catalogs               : true
08:59:08 INFO   domains                : true
08:59:08 INFO   indexes                : true
08:59:08 INFO   keys                   : true
08:59:08 INFO   links                  : true
08:59:08 INFO   queues                 : true
08:59:08 INFO   routines               : true
08:59:08 INFO   schemas                : true
08:59:08 INFO   sequences              : true
08:59:08 INFO   tables                 : true
08:59:08 INFO   udts                   : true
08:59:08 INFO object types
08:59:08 INFO   daos                   : false
08:59:08 INFO   indexes                : true
08:59:08 INFO   instance fields        : true
08:59:08 INFO   interfaces             : false
08:59:08 INFO   interfaces (immutable) : false
08:59:08 INFO   javadoc                : true
08:59:08 INFO   keys                   : true
08:59:08 INFO   links                  : true
08:59:08 INFO   pojos                  : false
08:59:08 INFO   pojos (immutable)      : false
08:59:08 INFO   queues                 : true
08:59:08 INFO   records                : true
08:59:08 INFO   routines               : true
08:59:08 INFO   sequences              : true
08:59:08 INFO   sequenceFlags          : true
08:59:08 INFO   table-valued functions : true
08:59:08 INFO   tables                 : true
08:59:08 INFO   udts                   : true
08:59:08 INFO   relations              : true
08:59:08 INFO other
08:59:08 INFO   deprecated code        : true
08:59:08 INFO ----------------------------------------------------------
08:59:08 INFO
08:59:08 INFO Generation remarks
08:59:08 INFO ----------------------------------------------------------
08:59:08 INFO
08:59:08 INFO ----------------------------------------------------------
08:59:08 INFO Generating catalogs      : Total: 1
08:59:08 INFO Version                  : Database version is supported by dialect COCKROACHDB: CockroachDB CCL v23.1.11 (aarch64-apple-darwin21.2, built 2023/09/27 02:20:44, go1.19.10)
08:59:09 INFO ARRAYs fetched           : 0 (0 included, 0 excluded)
08:59:09 INFO Domains fetched          : 0 (0 included, 0 excluded)
08:59:09 INFO Tables fetched           : 1 (1 included, 0 excluded)
08:59:09 INFO Embeddables fetched      : 0 (0 included, 0 excluded)
08:59:09 INFO Enums fetched            : 0 (0 included, 0 excluded)
08:59:09 INFO Packages fetched         : 0 (0 included, 0 excluded)
08:59:09 INFO Routines fetched         : 0 (0 included, 0 excluded)
08:59:09 INFO Sequences fetched        : 0 (0 included, 0 excluded)
08:59:09 INFO No schema version is applied for catalog . Regenerating.
08:59:09 INFO
08:59:09 INFO Generating catalog       : DefaultCatalog.java
08:59:09 INFO ==========================================================
08:59:09 INFO Generating schemata      : Total: 1
08:59:09 INFO No schema version is applied for schema public. Regenerating.
08:59:09 INFO Generating schema        : Public.java
08:59:09 INFO ----------------------------------------------------------
08:59:09 INFO UDTs fetched             : 0 (0 included, 0 excluded)
08:59:09 INFO Generating tables
08:59:09 INFO Generating table         : Author.java [input=author, pk=author_pkey]
08:59:09 INFO Indexes fetched          : 0 (0 included, 0 excluded)
08:59:09 INFO Tables generated         : Total: 590.635ms
08:59:09 INFO Generating table references
08:59:09 INFO Table refs generated     : Total: 592.036ms, +1.4ms
08:59:09 INFO Generating Keys
08:59:09 INFO Keys generated           : Total: 593.234ms, +1.198ms
08:59:09 INFO Generating Indexes
08:59:09 INFO Skipping empty indexes
08:59:09 INFO Generating table records
08:59:09 INFO Table records generated  : Total: 609.788ms, +16.554ms
08:59:09 INFO Generation finished: public: Total: 610.105ms, +0.317ms
08:59:09 INFO
08:59:09 INFO Affected files: 6
08:59:09 INFO Modified files: 6
08:59:09 INFO Removing excess files
