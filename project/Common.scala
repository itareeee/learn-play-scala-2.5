package common.sbt

import sbt.Keys._
import sbt._

import play.sbt._, PlayImport._

object Common {

  val commonDependencies = Seq(
    ws,
    //"org.scalactic" %% "scalactic" % "2.2.6", // TODO: superSafe と併せて検討: http://www.scalatest.org/install
    "org.scalatest" %% "scalatest" % "2.2.6" % "test",
    "org.scalatestplus" %% "play" % "1.4.0" % "test"
  )

  lazy val project = Project(
      "common",
      file("common")
    ).enablePlugins(
      PlayScala  
    ).settings(
      Base.baseSettings: _*  
    ).settings(
      libraryDependencies ++= commonDependencies  
    )

}
