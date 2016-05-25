package common.sbt

import sbt.Keys._
import sbt._

import play.sbt._, PlayImport._, PlayKeys._
import play.sbt.routes.RoutesKeys._


object API {

  val appVersion = "1.0.0"

  val apiDependencies = Seq(
    jdbc,
    cache
  )

  lazy val project = Project(
      "api",
      file("api")
    ).enablePlugins(
      PlayScala
    ).settings(
      Base.baseSettings: _*
    ).settings(
      libraryDependencies ++= apiDependencies,
      version := appVersion,
      playDefaultPort := 9000,
      routesGenerator := InjectedRoutesGenerator
    ).dependsOn(
      Common.project   
    )

}
