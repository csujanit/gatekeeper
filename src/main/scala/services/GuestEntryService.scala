package services

import db.DbAccs
import domain.{FlatUsersRepos, flat_users}
import tables.GuestEntryRepos
import tables.guest_entry_table
import org.joda.time.DateTime
import routes.guest_entry_request

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global

trait GuestEntryService extends FlatUsersRepos with GuestEntryRepos with DbAccs {
  def active_user_check(ls:Boolean):String = "T0001"
  def guest_entry_log(ls:guest_entry_request): Future[String] =
  {
    import ctx._
    def flat_user:Future[Option[flat_users]] = ctx.run(get_flat_user(ls.flat_no)).map(_.headOption)
    flat_user map{
      case Some(flat_users) => flat_users.active_status  match
                                {
                                   case "Y" => ctx.run(guest_entry_request(ls.flat_no,ls.guest_name,ls.guest_mobile_no,ls.guest_type,DateTime.now.toDateTime.toString))
                                               "T0001"
                                   case "N" => "T3433"
                                }
      case None => "T0002"
    }
   }
  }


