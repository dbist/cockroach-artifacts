package com.example.kotlin.cockroachdbkotlinjdbc

import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.math.BigDecimal
import java.sql.ResultSet

data class Accounts(val id: Int, val balance: BigDecimal)

@SpringBootApplication
class CockroachdbKotlinJdbcApplication(@Autowired val jdbcTemplate: JdbcTemplate) : CommandLineRunner {
	lateinit var rowMapper: RowMapper<Accounts>
	lateinit var results: List<Accounts>

	companion object {
		@Suppress("JAVA_CLASS_ON_COMPANION")
		@JvmStatic
		private val logger
				= getLogger(CockroachdbKotlinJdbcApplication::class.java)
	}

	override fun run(vararg args: String?) {
		// Create table ("IF NOT EXISTS"):
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS accounts (id INT PRIMARY KEY, balance DECIMAL(12,2), CONSTRAINT balance_gt_0 CHECK (balance >= 0))")

		// Truncate the table if records exist
		jdbcTemplate.execute("TRUNCATE TABLE accounts")

		// Insert initial records:
		jdbcTemplate.execute("INSERT INTO accounts(id, balance) VALUES(1, 1000)")
		jdbcTemplate.execute("INSERT INTO accounts(id, balance) VALUES(2, 250)")
		printRows("Original Rows:")

		// Insert another record:
		jdbcTemplate.execute("INSERT INTO accounts(id, balance) VALUES(3, 2000)")
		printRows("After another INSERT")

		// Delete a record:
		jdbcTemplate.execute("DELETE FROM accounts WHERE ID = 3")
		printRows("After DELETE")

		// Handling Duplicate Key value violation:
		jdbcTemplate.execute("UPSERT INTO accounts(id, balance) VALUES(1, 10000)")
		printRows("Handling Duplicate key violation with an UPSERT")
	}

	fun printRows(message: String): Unit {
		logger.info("\n")
		logger.info(message)

		// Declare a rowMapper to map DB records to collection of Account entities:
		rowMapper = RowMapper<Accounts> { resultSet: ResultSet, _: Int ->
			Accounts(resultSet.getInt("id"), resultSet.getBigDecimal("balance"))
		}

		// Query records to print out:
		results = jdbcTemplate.query("SELECT * FROM accounts", rowMapper)
		results.forEach { rec -> logger.info(rec.toString()) }
	}
}

fun main(args: Array<String>) {
	runApplication<CockroachdbKotlinJdbcApplication>(*args)
}
