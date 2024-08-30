import play.sbt.PlayImport.evolutions

name := """authapp"""
organization := "com.f2p"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.14"

//libraryDependencies += guice

libraryDependencies ++= Seq(
  guice,
  "org.postgresql" % "postgresql" % "42.5.0", // PostgreSQL JDBC driver
  "jakarta.persistence" % "jakarta.persistence-api" % "3.1.0",
      "org.hibernate" % "hibernate-entitymanager" % "5.6.15.Final",
  //"com.typesafe.play" %% "play-java-jpa" % "2.9.4 ",

  "org.hibernate" % "hibernate-core" % "6.5.2.Final" // replace by your jpa implementation
)
  //  "com.typesafe.play" %% "play-slick" % "5.0.2",    // Play Slick for database interaction
  //  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.2"  // For database evolutions




