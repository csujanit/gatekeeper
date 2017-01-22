enablePlugins(JavaAppPackaging)

name := "myprojects"

version := "1.0"

scalaVersion := "2.11.0"

val akkaVersion = "2.4.10"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % akkaVersion

libraryDependencies += "com.typesafe.akka" % "akka-stream_2.11" % "2.4.11"

libraryDependencies += "com.typesafe.akka" % "akka-http-core_2.11" % "10.0.1"

libraryDependencies += "com.typesafe.akka" % "akka-http_2.11" % "10.0.1"

libraryDependencies += "com.typesafe.akka" % "akka-http-jackson_2.11" % "10.0.1"

libraryDependencies += "com.typesafe.akka" % "akka-http-spray-json_2.11" % "10.0.1"

libraryDependencies += "com.github.mauricio" % "postgresql-async_2.11" % "0.2.20"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1212.jre6"

libraryDependencies += "io.getquill" % "quill-jdbc_2.11" % "1.0.1"

libraryDependencies += "io.getquill" %% "quill-async-postgres" % "1.0.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")


Revolver.settings