package common.sbt

import sbt.Keys._
import sbt._

object Base {

  // TODO understad the settings below
  val baseSettings = Seq(
    // Scala/Java Compiler Settings
    scalaVersion := "2.11.7",
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-Xlint",
      "-Ywarn-dead-code",
      //"-Ywarn-unused-import",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions"
    ),
    javacOptions in compile ++= Seq(
      "-encoding", "UTF-8",
      "-source", "1.8",
      "-target", "1.8"
    ),
    resolvers ++= Seq(
      Opts.resolver.sonatypeReleases,
      "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
    )
  )

}
