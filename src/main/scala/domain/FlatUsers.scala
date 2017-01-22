package domain
import db.DbAccs
import io.getquill.Embedded


case class flat_users(flat_no:Int,first_name:String,last_name:String,mobile_no:Long,email_id:String,active_status:String) extends Embedded

trait FlatUsersRepos  extends DbAccs{
  import ctx._


  def get_flat_user(flat_number:Int) = {
    quote{
         query[flat_users].filter(ls => ls.flat_no == lift(flat_number))
       }
    }
  }
