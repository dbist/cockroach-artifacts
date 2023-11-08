/*
 * This file is generated by jOOQ.
 */
package test.generated;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import test.generated.tables.Author;
import test.generated.tables.records.AuthorRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> AUTHOR__AUTHOR_PKEY = Internal.createUniqueKey(Author.AUTHOR, DSL.name("author_pkey"), new TableField[] { Author.AUTHOR.ID }, true);
}
