
import io.getquill._


object testingDB  {
  def main(args:Array[String]):Unit= {
    lazy val ctx = new JdbcContext[PostgresDialect,SnakeCase]("db.default")
    case class test(pd:Int,somes:String)
      import ctx._
       val ses = quote{
          query[test]
       }
      val out = ctx.run(ses)
      println(out)
    }
}
