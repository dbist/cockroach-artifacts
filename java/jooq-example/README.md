java -cp jooq-3.17.16.jar:jooq-meta-extensions-3.17.16.jar:jooq-meta-3.17.16.jar:jooq-codegen-3.17.16.jar:jakarta.xml.bind-api-3.0.0.jar:r2dbc-spi-0.9.1.RELEASE.jar:reactive-streams-1.0.3.jar:postgresql-42.5.4.jar org.jooq.codegen.GenerationTool jooq-config.xml


13:42:48 INFO Initialising properties  : jooq-config.xml
13:42:49 INFO No <inputCatalog/> was provided. Generating ALL available catalogs instead.
13:42:49 INFO License parameters
13:42:49 INFO ----------------------------------------------------------
13:42:49 INFO   Thank you for using jOOQ and jOOQ's code generator
13:42:49 INFO
13:42:49 INFO Database parameters
13:42:49 INFO ----------------------------------------------------------
13:42:49 INFO   dialect                : COCKROACHDB
13:42:49 INFO   URL                    : jdbc:postgresql://localhost:26257/library?sslmode=disable
13:42:49 INFO   target dir             : /Users/artem/Documents/cockroach-work/cockroach-artifacts/java/jooq-example/src/main/java/com/cockroachlabs/jooq
13:42:49 INFO   target package         : generated
13:42:49 INFO   includes               : [.*]
13:42:49 INFO   excludes               : []
13:42:49 INFO   includeExcludeColumns  : false
13:42:49 INFO ----------------------------------------------------------
13:42:49 INFO
13:42:49 INFO JavaGenerator parameters
13:42:49 INFO ----------------------------------------------------------
13:42:49 INFO annotations
13:42:49 INFO   generated              : false
13:42:49 INFO   JPA                    : false
13:42:49 INFO   JPA version            :
13:42:49 INFO   validation             : false
13:42:49 INFO   spring                 : false
13:42:49 INFO comments
13:42:49 INFO   comments               : true
13:42:49 INFO   on attributes          : true
13:42:49 INFO   on catalogs            : true
13:42:49 INFO   on columns             : true
13:42:49 INFO   on embeddables         : true
13:42:49 INFO   on keys                : true
13:42:49 INFO   on links               : true
13:42:49 INFO   on packages            : true
13:42:49 INFO   on parameters          : true
13:42:49 INFO   on queues              : true
13:42:49 INFO   on routines            : true
13:42:49 INFO   on schemas             : true
13:42:49 INFO   on sequences           : true
13:42:49 INFO   on tables              : true
13:42:49 INFO   on udts                : true
13:42:49 INFO sources
13:42:49 INFO   sources                : true
13:42:49 INFO   sources on views       : true
13:42:49 INFO global references
13:42:49 INFO   global references      : true
13:42:49 INFO   catalogs               : true
13:42:49 INFO   domains                : true
13:42:49 INFO   indexes                : true
13:42:49 INFO   keys                   : true
13:42:49 INFO   links                  : true
13:42:49 INFO   queues                 : true
13:42:49 INFO   routines               : true
13:42:49 INFO   schemas                : true
13:42:49 INFO   sequences              : true
13:42:49 INFO   tables                 : true
13:42:49 INFO   udts                   : true
13:42:49 INFO object types
13:42:49 INFO   daos                   : false
13:42:49 INFO   indexes                : true
13:42:49 INFO   instance fields        : true
13:42:49 INFO   interfaces             : false
13:42:49 INFO   interfaces (immutable) : false
13:42:49 INFO   javadoc                : true
13:42:49 INFO   keys                   : true
13:42:49 INFO   links                  : true
13:42:49 INFO   pojos                  : false
13:42:49 INFO   pojos (immutable)      : false
13:42:49 INFO   queues                 : true
13:42:49 INFO   records                : true
13:42:49 INFO   routines               : true
13:42:49 INFO   sequences              : true
13:42:49 INFO   sequenceFlags          : true
13:42:49 INFO   table-valued functions : true
13:42:49 INFO   tables                 : true
13:42:49 INFO   udts                   : true
13:42:49 INFO   relations              : true
13:42:49 INFO other
13:42:49 INFO   deprecated code        : true
13:42:49 INFO ----------------------------------------------------------
13:42:49 INFO
13:42:49 INFO Generation remarks
13:42:49 INFO ----------------------------------------------------------
13:42:49 INFO
13:42:49 INFO ----------------------------------------------------------
13:42:49 INFO Generating catalogs      : Total: 1
13:42:49 INFO Version                  : Database version is supported by dialect COCKROACHDB: CockroachDB CCL v23.1.11 (aarch64-apple-darwin21.2, built 2023/09/27 02:20:44, go1.19.10)
13:42:49 INFO ARRAYs fetched           : 0 (0 included, 0 excluded)
13:42:49 INFO Domains fetched          : 0 (0 included, 0 excluded)
13:42:49 INFO Tables fetched           : 1 (1 included, 0 excluded)
13:42:49 INFO Embeddables fetched      : 0 (0 included, 0 excluded)
13:42:49 INFO Enums fetched            : 0 (0 included, 0 excluded)
13:42:49 INFO Packages fetched         : 0 (0 included, 0 excluded)
13:42:49 INFO Routines fetched         : 0 (0 included, 0 excluded)
13:42:49 INFO Sequences fetched        : 0 (0 included, 0 excluded)
13:42:49 INFO No schema version is applied for catalog . Regenerating.
13:42:49 INFO
13:42:49 INFO Generating catalog       : DefaultCatalog.java
13:42:49 INFO ==========================================================
13:42:49 INFO Generating schemata      : Total: 1
13:42:49 INFO No schema version is applied for schema public. Regenerating.
13:42:49 INFO Generating schema        : Public.java
13:42:49 INFO ----------------------------------------------------------
13:42:49 INFO UDTs fetched             : 0 (0 included, 0 excluded)
13:42:49 INFO Generating tables
13:42:49 INFO Generating table         : Author.java [input=author, pk=author_pkey]
13:42:49 INFO Indexes fetched          : 0 (0 included, 0 excluded)
13:42:49 INFO Tables generated         : Total: 561.388ms
13:42:49 INFO Generating table references
13:42:49 INFO Table refs generated     : Total: 563.061ms, +1.673ms
13:42:49 INFO Generating Keys
13:42:49 INFO Keys generated           : Total: 564.304ms, +1.243ms
13:42:49 INFO Generating Indexes
13:42:49 INFO Skipping empty indexes
13:42:49 INFO Generating table records
13:42:49 INFO Generating record        : AuthorRecord.java
13:42:49 INFO Table records generated  : Total: 587.217ms, +22.913ms
13:42:49 INFO Generation finished: public: Total: 587.572ms, +0.354ms
13:42:49 INFO
13:42:49 INFO Affected files: 6
13:42:49 INFO Modified files: 6
13:42:49 INFO Removing excess files
