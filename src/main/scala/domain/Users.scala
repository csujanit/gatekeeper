package domain


import db.DbAccs
case class Users(user_id:Int,user_name:String)

trait usersRepos extends  DbAccs{
  import ctx._
  val get_all_users = quote(query[Users])
}