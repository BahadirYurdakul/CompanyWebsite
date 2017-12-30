name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)


scalaVersion := "2.11.11"

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs
libraryDependencies += jdbc
libraryDependencies += "com.google.code.gson"%"gson"%"2.8.2"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"

