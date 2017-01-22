package db


import io.getquill.{JdbcContext, PostgresAsyncContext, PostgresDialect, SnakeCase}

 trait DbAccs{
  //implicit lazy val ctx = new JdbcContext[PostgresDialect,SnakeCase]("db.default")
    implicit lazy val ctx = new PostgresAsyncContext[SnakeCase]("db.default")

  }


