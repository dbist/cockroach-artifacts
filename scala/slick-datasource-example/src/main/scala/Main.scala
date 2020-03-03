import slick.jdbc.PostgresProfile.api._  // as of slick 3.3
import slick.jdbc.PostgresProfile.Table
import scala.concurrent.Await
import scala.concurrent.duration._
import java.util.concurrent.TimeUnit._
import org.postgresql.ds.PGSimpleDataSource;

object Main {
    class Users(tag: Tag) extends Table[(String, String)](tag, "users") {
    def id = column[String]("id")
    def username = column[String]("username")
    def * = (id, username)
  }
    
    def main(args: Array[String]): Unit = {
       // val db = Database.forURL("jdbc:postgresql://maxroach@crdb-1:26257/defaultdb?sslmode=disable",
  //driver="org.postgresql.Driver")
        
        val ds = new PGSimpleDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(26257);
        ds.setDatabaseName("defaultdb");
        ds.setUser("maxroach");
        ds.setPassword(null);
        ds.setReWriteBatchedInserts(true);
        
        val db = Database.forDataSource(ds, Some(10))
        val users = TableQuery[Users]

        val defaultTimeout = 10 seconds

       // must use Futures to get result back 
       //Vector((ee810878-bef2-49d6-ab93-0bf85953a71e,john), (f2248032-94cd-4724-8693-395a5c9c17d6,mary))
       println(Await.result(db.run(users.result), defaultTimeout))
  }
}
