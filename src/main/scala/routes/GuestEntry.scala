package routes

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.{as, complete, entity, pathPrefix, post}
import akka.http.scaladsl.server.Route
import spray.json.DefaultJsonProtocol
import services.GuestEntryService

case class   guest_entry_request(flat_no:Int,guest_name:String,guest_type:String,guest_mobile_no:Long)
trait guestentryprotocol extends SprayJsonSupport with DefaultJsonProtocol
{
  implicit val guestentryFormat = jsonFormat4(guest_entry_request)
}

trait guestentry extends guestentryprotocol with GuestEntryService {
  val guestroute:Route = pathPrefix("guestentry"){
    post{
      entity(as[guest_entry_request]){
        ls =>
        {
           complete(guest_entry_log(ls))
        }
        }
      }
    }
  }