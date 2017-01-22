package tables

import db.DbAccs
import io.getquill.Embedded

case class guest_entry_table(guest_entry_flat_no:Int,guest_name:String,guest_mobile_no:Long,guest_type:String,entry_time:String)


trait GuestEntryRepos extends  DbAccs{
  import ctx._

  def guest_entry_request(flat_no:Int,guest_name:String,guest_mob_no:Long,guest_type:String,entry_time:String) = {
    quote {
         query[guest_entry_table].insert(lift(guest_entry_table(flat_no,guest_name,guest_mob_no,guest_type,entry_time)))
     }
  }
}