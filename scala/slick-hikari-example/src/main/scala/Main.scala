//https://toree.apache.org/docs/current/user/quick-start/
//import slick.driver.PostgresDriver.api._  // as of slick 3.2
import slick.jdbc.PostgresProfile.api._  // as of slick 3.3
import slick.jdbc.PostgresProfile.Table
import scala.concurrent.Await
import scala.concurrent.duration._
import java.util.concurrent.TimeUnit._

object Main {

  /**
    *   users      | CREATE TABLE users (
             |     id UUID NOT NULL DEFAULT gen_random_uuid(),
             |     username VARCHAR NULL,
             |     FAMILY "primary" (id, username, rowid)
             | )
    *  insert into users(username) values ('john'), ('mary');
    */ 

  // this is a class that represents the table I've created in the database
  class Users(tag: Tag) extends Table[(String, String)](tag, "users") {
    def id = column[String]("id")
    def username = column[String]("username")
    def * = (id, username)
  }

  /**
    *   company    | CREATE TABLE company (
             |     id INT8 NOT NULL,
             |     name STRING NOT NULL,
             |     age INT8 NOT NULL,
             |     address CHAR(50) NULL,
             |     salary FLOAT4 NULL,
             |     CONSTRAINT "primary" PRIMARY KEY (id ASC),
             |     FAMILY "primary" (id, name, age, address, salary)
             | )
    *
    * @param args
    */

   class Company(tag: Tag) extends Table[(Int, String, Int, String, Float)](tag, "company") {
      def id = column[Int]("id")
      def name = column[String]("name")
      def age = column[Int]("age")
      def address = column[String]("address")
      def salary = column[Float]("salary")
      def * = (id, name, age, address, salary)
    }

  def main(args: Array[String]): Unit = {

        // http://scala-slick.org/doc/3.3.1/database.html
        // using TypeSafe config with Hikari

        val db = Database.forConfig("cockroach")
        val users = TableQuery[Users]

        val defaultTimeout = 10 seconds

       // must use Futures to get result back 
       //Vector((ee810878-bef2-49d6-ab93-0bf85953a71e,john), (f2248032-94cd-4724-8693-395a5c9c17d6,mary))
       println(Await.result(db.run(users.result), defaultTimeout))

       val company = TableQuery[Company]
       //Vector((1,Paul,32,California,20000.0), (2,Allen,25,Texas,15000.0), (3,Teddy,23,Norway,20000.0), (4,Mark,25,Rich-Mond ,65000.0))
       println(Await.result(db.run(company.result), defaultTimeout))
  }
}

