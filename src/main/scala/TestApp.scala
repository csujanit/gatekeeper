import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import spray.json._
import db.DbAccs
import scala.io.StdIn
import domain._
import routes.guestentry

object TestApp extends  App with SprayJsonSupport with DefaultJsonProtocol with usersRepos with guestentry with DbAccs{
  {

    implicit  val system = ActorSystem()
    implicit  val materializer  = ActorMaterializer()
    implicit  val executionContext = system.dispatcher
    implicit  val testFormat = jsonFormat2(Users)
    val route = {
      get {
        path("test"/LongNumber){ ls =>
             complete("OK")
        }
      }
    }
    println("Starting the server")
    Http().bindAndHandle(route ~ guestroute,sys.env("OPENSHIFT_DIY_IP"),8080)
/*    val bindingFuture = Http().bindAndHandle(route ~ guestroute,"localhost",8080)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate())*/
  }
}