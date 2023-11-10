CREATE DATABASE library;
USE library;
CREATE TABLE author (
  id int NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  first_name_encrypted bytea DEFAULT NULL,
  last_name_encrypted bytea DEFAULT NULL,
  PRIMARY KEY (id)
);

-- must be used with jooq-encryption, otherwise throws NullPointerException
COMMENT ON TABLE author IS 'jooq encryption example.';
